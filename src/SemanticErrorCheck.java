import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ressay on 23/11/17.
 */

public class SemanticErrorCheck extends TinyLangageSIIBaseListener
{
    private static final int DECLARED = 1;
    private static final int UNDECLARED = 2;
    private static final int FLOAT = 2;
    private static final int INT = 1;

    private TableS table = new TableS();
    private LinkedList<String> errors = new LinkedList<>();
    private HashMap<ParserRuleContext,Integer> types = new HashMap<>();
    private static int typesC[] = {0, INT|FLOAT , INT|FLOAT, INT|FLOAT}; // types compatibility operations 0,int,float
    private static int typesA[] = {0, INT , INT|FLOAT, INT|FLOAT}; // types compatibility affectation 0,int,float

    /**
     * part of grammar which interests us in this section
     * prog : 'compil' ID '(' ')' '{' declarations START insts '}'
     *
     *
     * when we exit prog, we've parsed all text so if there are errors, we show them, else we show symbols table
     * @param ctx
     */
    @Override public void exitProg(TinyLangageSIIParser.ProgContext ctx)
    {
        if(errors.size() == 0) { // no errors
            showText("program compiled without errors!",TextDisplayer.COMPILERTEXTS);
            showText("symbols table: ",TextDisplayer.COMPILERTEXTS);
            showText("******************************************************",TextDisplayer.COMPILERTEXTS);
            for (int i = 0; i < table.getSize(); i++) {
                showText(table.getElement(i).toString(),TextDisplayer.COMPILERTEXTS);
            }
            showText("******************************************************",TextDisplayer.COMPILERTEXTS);
        }
        else
        {
            showText("program compiled with the following errors",TextDisplayer.COMPILERTEXTS);
            for (int i = 0; i < errors.size(); i++) {
                showText(errors.get(i),TextDisplayer.ERROR);
            }
        }
    }

    /**
     * part of grammar which interests us in this section
     * declarations : (dec declarations)|dec  ;
     * dec : type vars ';' ;
     * type : INT | FLOAT;
     * vars : ((ID ',' vars) | ID) ;
     *
     *
     * we check the text returned by "type" if it's intCompil we declare int else float
     * after that we loop over vars to put all IDs (contained in vars.getChild(0) ) into symbols table
     *
     * @param ctx
     */

    @Override public void exitDec(TinyLangageSIIParser.DecContext ctx)
    {
        int type = (ctx.type().getText().equals("intCompil"))?INT:FLOAT;

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


    /**
     * affect : identifier '=' exp ;
     *
     *
     * we get the type of 'exp' and compare it with type of 'identifier'
     * if they are not compatible we generate an error
     * we clear the map that helped us to keep track of types (bricolage)
     * @param ctx
     */

    @Override public void exitAffect(TinyLangageSIIParser.AffectContext ctx)
    {
        showText("1st type is " + getCtxType(ctx.exp()) + " second type is " + table.getElement(ctx.identifier().getText()).type,TextDisplayer.RANDOMCOMMENTS);
        if(!affectTypesCompatible(table.getElement(ctx.identifier().getText()).type,getCtxType(ctx.exp())))
            errors.add("incompatible types in affectation " + ctx.getText());
        clearMap();
    }

    /**
     * exp : exp opmi t | t;
     * t : t opma endEx | endEx;
     * endEx : identifier | '(' exp ')' | val ;
     * opmi : PLUS | MINUS ; ====> + | -
     * opma : MUL | DIV ; ====> * | /
     *
     *
     * we check if ctx.exp() == null
     * => we exited from rule (exp->t) and not (exp->exp opmi t) from the first rule exp : exp opmi t | t;
     * so we keep track of type of exp (left member) which is same as t
     * else
     * => we exited from rule (exp->exp opmi t) and not (exp->t) from the first rule exp : exp opmi t | t;
     * we check if exp and t have compatible types, we keep the type of the resulting type into exp (left member)
     *          else we give exp (left member) type 0 which will generate error for sure in method "exitAffect"
     * @param ctx
     */

    @Override public void exitExp(TinyLangageSIIParser.ExpContext ctx)
    {
        if(ctx.exp() == null)
            addCtxType(ctx,getCtxType(ctx.t()));
        else
        {
            showText(ctx.t().getText() + " type: " + getCtxType(ctx.t()) + " and " + ctx.exp().getText() + " type: " + getCtxType(ctx.exp()),TextDisplayer.RANDOMCOMMENTS);
            if(typesCompatible(getCtxType(ctx.t()),getCtxType(ctx.exp())))
                addCtxType(ctx,getResultingType(getCtxType(ctx.t()),getCtxType(ctx.exp())));
            else {
                addCtxType(ctx, 0); // type 0 will always generate error
                showText("incompatible type between " + ctx.t().getText() + " and " + ctx.exp().getText(),TextDisplayer.IMPORTANTCOMMENTS);
                showText(ctx.t().getText() + " type: " + getCtxType(ctx.t()) + " and " + ctx.exp().getText() + " type: " + getCtxType(ctx.exp()),TextDisplayer.MOREINFORMATIONS);
            }

        }
    }

    /**
     * exp : exp opmi t | t;
     * t : t opma endEx | endEx;
     * endEx : identifier | '(' exp ')' | val ;
     * opmi : PLUS | MINUS ; ====> + | -
     * opma : MUL | DIV ; ====> * | /
     *
     *
     * we check if ctx.t() == null
     * => we exited from rule (t->endEx) and not (t->t opma endEx) from the second rule t : t opma endEx | endEx;
     * so we keep track of type of t (left member) which is same as endEx
     * else
     * => we exited from rule (t->t opma endEx) and not (t->endEx) from the second rule t : t opma endEx | endEx;
     * we check if t and endEx have compatible types, we keep the type of the resulting type into t (left member)
     *          else we give t (left member) type 0 which will generate error for sure in method "exitAffect"
     * @param ctx
     */

    @Override public void exitT(TinyLangageSIIParser.TContext ctx)
    {
        if(ctx.t() == null)
            addCtxType(ctx,getCtxType(ctx.endEx()));
        else
        {
            showText(ctx.t().getText() + " type: " + getCtxType(ctx.t()) + " and " + ctx.endEx().getText() + " type: " + getCtxType(ctx.endEx()),TextDisplayer.MOREINFORMATIONS);
            if(typesCompatible(getCtxType(ctx.endEx()),getCtxType(ctx.t())))
                addCtxType(ctx,getResultingType(getCtxType(ctx.t()),getCtxType(ctx.endEx())));
            else {
                addCtxType(ctx, 0); // type 0 will always generate error
                showText("incompatible type between " + ctx.t().getText() + " and " + ctx.endEx().getText(),TextDisplayer.IMPORTANTCOMMENTS);
                showText(ctx.t().getText() + " type: " + getCtxType(ctx.t()) + " and " + ctx.endEx().getText() + " type: " + getCtxType(ctx.endEx()),TextDisplayer.MOREINFORMATIONS);
            }
        }
    }

    /**
     * endEx : identifier | '(' exp ')' | val ;
     *
     *
     * we keep track of type of endEx
     * if it's identifier we get the type from symbols table
     * if it's exp we get type from our map
     * if it's val we also get type from our map
     * @param ctx
     */

    @Override public void exitEndEx(TinyLangageSIIParser.EndExContext ctx)
    {
        if(ctx.identifier() != null)
            addCtxType(ctx,table.getElement(ctx.identifier().getText()).type);
        else if(ctx.exp() != null)
            addCtxType(ctx,getCtxType(ctx.exp()));
        else
            addCtxType(ctx,getCtxType(ctx.val()));
    }

    /**
     * val : INTEGERVAL | FLOATVAL;
     *
     *
     * we keep track of "Val" 's type by adding it to the map
     * @param ctx
     */

    @Override public void exitVal(TinyLangageSIIParser.ValContext ctx)
    {
        addCtxType(ctx,(ctx.INTEGERVAL()!=null)?INT:FLOAT);
    }

    /**
     * identifier : ID;
     *
     * identifier is a non terminal used to refer to any ID except in declaration
     * use of it is to check if it has been declared before or not
     * THAT IS ALL!
     * @param ctx
     */


    @Override public void exitIdentifier(TinyLangageSIIParser.IdentifierContext ctx)
    {
        // check if ID has been declared
        if(!table.containsElement(ctx.ID().getText()))
        {
            errors.add("variable " + ctx.ID().getText() + " has not been declared at line " + ctx.ID().getSymbol().getLine());
            table.addElement(new TableS.Element(ctx.ID().getText(),UNDECLARED,INT|FLOAT,1));
            // adding non declared variable in order to not generate same error again
        }
    }

    /**
     * comp : exp op exp ;
     * op : SUP | INF ;
     *
     *
     *
     * @param ctx
     */

    //TODO check types here!

    @Override public void exitComp(TinyLangageSIIParser.CompContext ctx)
    {
        clearMap();
    }


    /**
     *
     * errorNode is fired when there is an error I guess xD (lexer/parser) so .. yeah
     * @param node
     */

    boolean syntaxError = false;
    @Override public void visitErrorNode(ErrorNode node)
    {
//        if(!syntaxError)
//            errors.add("syntax error at line "+node.getSymbol().getLine() + " in ' " + node.getText() + " '");
//        syntaxError = true;
    }


    /***************************************** Helper methods ************************************************/
    public LinkedList<String> getErrors() {
        return errors;
    }

    private void addCtxType(ParserRuleContext ctx, int type)
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
        return (typesC[t1] & t2) != 0;
    }

    private static boolean affectTypesCompatible(int t1,int t2)
    {
        return (typesA[t1] & t2) != 0;
    }

    private static int getResultingType(int t1,int t2)
    {
        return ((t1 & t2 & INT) != 0)?INT:FLOAT;
    }

    private void showText(String text, int typeOfText)
    {
        TextDisplayer.getInstance().showText(text,typeOfText,TextDisplayer.SEMANTICERR);
    }

    public TableS getTable() {
        return table;
    }
}
