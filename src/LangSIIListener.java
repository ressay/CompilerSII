import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ressay on 23/11/17.
 */
public class LangSIIListener extends TinyLangageSIIBaseListener
{
    private static final int DECLARED = 1;
    private static final int UNDECLARED = 2;
    private static final int FLOAT = 2;
    private static final int INT = 1;

    private static final int WARNINGS = 1;
    private static final int IMPORTANTCOMMENTS = 2;
    private static final int RANDOMCOMMENTS = 4;
    private static final int COMPILERTEXTS = 8;
    private static final int MOREINFORMATIONS = 16;
    private static final int ERROR = 32;

    private String getTextType(int type)
    {
        switch (type)
        {
            case WARNINGS: return "WARNINGS";
            case IMPORTANTCOMMENTS: return "IMPORTANTCOMMENTS";
            case RANDOMCOMMENTS: return "RANDOMCOMMENTS";
            case COMPILERTEXTS: return "COMPILERTEXTS";
            case MOREINFORMATIONS: return "MOREINFORMATIONS";
            case ERROR : return "ERROR";
        }
        return "";
    }
    private static final int ALLTEXTS = WARNINGS|IMPORTANTCOMMENTS|RANDOMCOMMENTS|COMPILERTEXTS|MOREINFORMATIONS|ERROR;
    private TableS table = new TableS();
    private LinkedList<String> errors = new LinkedList<>();
    private HashMap<ParserRuleContext,Integer> types = new HashMap<>();
    int printMask = ERROR|COMPILERTEXTS;

    private void addCtxType(ParserRuleContext ctx,int type)
    {
        types.put(ctx,type);
    }

    private int getCtxType(ParserRuleContext ctx)
    {
        return types.get(ctx);
    }

    private void clearMap()
    {
        types.clear();
    }

    private static boolean typesCompatible(int t1,int t2)
    {
        return (t1 & t2) != 0;
    }

    private static int getResultingType(int t1,int t2)
    {
        return ((t1 & t2 & FLOAT) != 0)?FLOAT:INT;
    }

    private void showText(String text, int typeOfText)
    {
        if((typeOfText & printMask) != 0)
            System.out.println(getTextType(typeOfText) + ": " +text);
    }



    @Override public void exitProg(TinyLangageSIIParser.ProgContext ctx)
    {
        if(errors.size() == 0) { // no errors
            showText("program compiled without errors!",COMPILERTEXTS);
            showText("symbols table: ",COMPILERTEXTS);
            for (int i = 0; i < table.getSize(); i++) {
                showText(table.getElement(i).toString(),COMPILERTEXTS);
            }
        }
        else
        {
            showText("program compiled with the following errors",COMPILERTEXTS);
            for (int i = 0; i < errors.size(); i++) {
                showText(errors.get(i),ERROR);
            }
        }
    }

    @Override public void exitDec(TinyLangageSIIParser.DecContext ctx)
    {
        int type = (ctx.type().getText().equals("intCompil"))?1:2;

        TinyLangageSIIParser.VarsContext vars = ctx.vars();

        for (;;vars = vars.vars()) // loop over vars
        {
            String varName = vars.getChild(0).getText();
            if(table.containsElement(varName)) {
                errors.add("Double declaration of variable: " + varName);
            }
            else
                table.addElement(new TableS.Element(varName,DECLARED,type,1));
            if(vars.vars() == null)
                return;
        }

    }

    @Override public void exitVal(TinyLangageSIIParser.ValContext ctx)
    {
        addCtxType(ctx,(ctx.INTEGERVAL()!=null)?INT:FLOAT);
    }


    @Override public void exitInsts(TinyLangageSIIParser.InstsContext ctx) { }

    @Override public void exitInst(TinyLangageSIIParser.InstContext ctx) { }


    @Override public void exitAffect(TinyLangageSIIParser.AffectContext ctx)
    {
        if(!typesCompatible(getCtxType(ctx.exp()),table.getElement(ctx.identifier().getText()).type))
            errors.add("incompatible types in affectation " + ctx.getText());
        clearMap();
    }

    @Override public void exitIdentifier(TinyLangageSIIParser.IdentifierContext ctx)
    {
        // check if ID has been declared
        if(!table.containsElement(ctx.ID().getText()))
        {
            errors.add("variable " + ctx.ID().getText() + " has not been declared");
            table.addElement(new TableS.Element(ctx.ID().getText(),UNDECLARED,INT,1));
            // adding non declared variable in order to not generate same error again
        }
    }

    @Override public void exitExp(TinyLangageSIIParser.ExpContext ctx)
    {
        if(ctx.exp() == null)
            addCtxType(ctx,getCtxType(ctx.t()));
        else
        {
            if(typesCompatible(getCtxType(ctx.t()),getCtxType(ctx.exp())))
                addCtxType(ctx,getResultingType(getCtxType(ctx.t()),getCtxType(ctx.exp())));
            else {
                addCtxType(ctx, 0); // type 0 will always generate error
                showText("incompatible type between " + ctx.t().getText() + " and " + ctx.exp().getText(),IMPORTANTCOMMENTS);
                showText(ctx.t().getText() + " type: " + getCtxType(ctx.t()) + " and " + ctx.exp().getText() + " type: " + getCtxType(ctx.exp()),MOREINFORMATIONS);
            }

        }
    }

    @Override public void exitT(TinyLangageSIIParser.TContext ctx)
    {
        if(ctx.t() == null)
            addCtxType(ctx,getCtxType(ctx.endEx()));
        else
        {
            if(typesCompatible(getCtxType(ctx.endEx()),getCtxType(ctx.t())))
                addCtxType(ctx,getResultingType(getCtxType(ctx.t()),getCtxType(ctx.endEx())));
            else {
                addCtxType(ctx, 0); // type 0 will always generate error
                showText("incompatible type between " + ctx.t().getText() + " and " + ctx.endEx().getText(),IMPORTANTCOMMENTS);
                showText(ctx.t().getText() + " type: " + getCtxType(ctx.t()) + " and " + ctx.endEx().getText() + " type: " + getCtxType(ctx.endEx()),MOREINFORMATIONS);
            }
        }
    }

    @Override public void exitEndEx(TinyLangageSIIParser.EndExContext ctx)
    {
        if(ctx.identifier() != null)
            addCtxType(ctx,table.getElement(ctx.identifier().getText()).type);
        else if(ctx.exp() != null)
            addCtxType(ctx,getCtxType(ctx.exp()));
        else
            addCtxType(ctx,getCtxType(ctx.val()));
    }

    @Override public void exitComp(TinyLangageSIIParser.CompContext ctx)
    {
        clearMap();
    }

    @Override public void exitIfinst(TinyLangageSIIParser.IfinstContext ctx) { }


    @Override public void exitRead(TinyLangageSIIParser.ReadContext ctx) { }

    @Override public void exitWrite(TinyLangageSIIParser.WriteContext ctx) { }

    @Override public void exitListID(TinyLangageSIIParser.ListIDContext ctx) { }

    @Override public void enterEveryRule(ParserRuleContext ctx) { }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }

    @Override public void visitTerminal(TerminalNode node) { }

    @Override public void visitErrorNode(ErrorNode node) { }
}
