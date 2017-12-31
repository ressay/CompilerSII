import org.antlr.v4.gui.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.dfa.DFA;

import javax.print.PrintException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ressay on 23/11/17.
 */
public class myMain extends TestRig
{
    public myMain(String[] args) throws Exception {
        super(args);
    }

    public static void main(String[] args) throws Exception
    {
        myMain m = new myMain(args);
        if(args.length >= 2) {
            m.process();
        }
    }

    /**
     * this is all I've done in this class
     * basically I add the listeners I've created in this method so that their methods are fired
     * while text is getting parsed x)
     * @param parser
     */
    public static SemanticErrorCheck semanticErrorCheck = new SemanticErrorCheck();
    public static QuadGenerator quadGenerator = new QuadGenerator(semanticErrorCheck);
    public static String tokenstext = "";
    public static boolean lexerError = false;
    public static LinkedList<String> lexerErrors;
    public static void addListeners(Parser parser)
    {
        semanticErrorCheck = new SemanticErrorCheck();
        quadGenerator = new QuadGenerator(semanticErrorCheck);
        lexerErrors = new LinkedList<>();
        parser.addParseListener(quadGenerator);
        parser.addParseListener(semanticErrorCheck);
    }

    protected void process(Lexer lexer, Class<? extends Parser> parserClass, Parser parser, CharStream input) throws IOException, IllegalAccessException, InvocationTargetException, PrintException {
        lexer.setInputStream(input);
        lexer.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                lexerError = true;
                String error = s.substring(27);
                lexerErrors.add("lexer error at line " + i + " unrecognized token " + error);
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

            }
        });
        addListeners(parser);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        if(this.showTokens) {
            Iterator i$ = tokens.getTokens().iterator();

            while(i$.hasNext()) {
                Token tok = (Token)i$.next();
                if(tok instanceof CommonToken) {
//                    System.out.println(((CommonToken)tok).toString(lexer));
                    tokenstext += ((CommonToken)tok).toString(lexer)+"\n";
                } else {
//                    System.out.println(tok.toString());
                    tokenstext += tok.toString()+"\n";
                }
            }
        }

        if(!this.startRuleName.equals("tokens")) {
            if(this.diagnostics) {
                parser.addErrorListener(new DiagnosticErrorListener());
                ((ParserATNSimulator)parser.getInterpreter()).setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            }

            if(this.printTree || this.gui || this.psFile != null) {
                parser.setBuildParseTree(true);
            }

            if(this.SLL) {
                ((ParserATNSimulator)parser.getInterpreter()).setPredictionMode(PredictionMode.SLL);
            }

            parser.setTokenStream(tokens);
            parser.setTrace(this.trace);

            try {
                Method startRule = parserClass.getMethod(this.startRuleName, new Class[0]);
                ParserRuleContext tree = (ParserRuleContext)startRule.invoke(parser, (Object[])null);
                if(this.printTree) {
                    System.out.println(tree.toStringTree(parser));
                }

                if(this.gui) {
                    org.antlr.v4.gui.Trees.inspect(tree, parser);
                }

                if(this.psFile != null) {
                    org.antlr.v4.gui.Trees.save(tree, parser, this.psFile);
                }
            } catch (NoSuchMethodException var8) {
                System.err.println("No method for rule " + this.startRuleName + " or it has arguments");
            }

        }
    }
}
