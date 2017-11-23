import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * Created by ressay on 23/11/17.
 */
public class LangSIIListener extends TinyLangageSIIBaseListener
{
    TableS table = new TableS();
    boolean error = false;
    @Override public void exitProg(TinyLangageSIIParser.ProgContext ctx)
    {
        System.out.println("table des symboles: ");
        for (int i = 0; i < table.getSize(); i++) {
            System.out.println(table.getElement(i));
        }
    }

    @Override public void exitDec(TinyLangageSIIParser.DecContext ctx)
    {
        int type = (ctx.type().getText().equals("intCompil"))?0:1;
        int declared = 1; // it got declared
        int size = 1; // one variable (not array)

        TinyLangageSIIParser.VarsContext vars = ctx.vars();

        for (;;vars = vars.vars()) // loop over vars
        {
            String varName = vars.getChild(0).getText();
            System.out.println("declaring variable name= " + varName);
            if(table.containsElement(varName)) {
                System.out.println("ERROR: Double declaration of variable: " + varName);
                error = true;
            }
            else
                table.addElement(new TableS.Element(varName,declared,type,size));
            if(vars.vars() == null)
                return;
        }

    }

    @Override public void exitVal(TinyLangageSIIParser.ValContext ctx) { }


    @Override public void exitInsts(TinyLangageSIIParser.InstsContext ctx) { }

    @Override public void exitInst(TinyLangageSIIParser.InstContext ctx) { }


    @Override public void exitAffect(TinyLangageSIIParser.AffectContext ctx)
    {

    }

    @Override public void exitIdentifier(TinyLangageSIIParser.IdentifierContext ctx)
    {
        // check if ID has been declared
        if(!table.containsElement(ctx.ID().getText()))
        {
            System.out.println("ERROR: variable " + ctx.ID().getText() + " has not been declared");
            table.addElement(new TableS.Element(ctx.ID().getText(),0,1,1));
            // adding non declared variable in order to not generate same error again
            error = true;
        }
    }


    @Override public void enterExp(TinyLangageSIIParser.ExpContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExp(TinyLangageSIIParser.ExpContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterT(TinyLangageSIIParser.TContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitT(TinyLangageSIIParser.TContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterOpmi(TinyLangageSIIParser.OpmiContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitOpmi(TinyLangageSIIParser.OpmiContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterOpma(TinyLangageSIIParser.OpmaContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitOpma(TinyLangageSIIParser.OpmaContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEndEx(TinyLangageSIIParser.EndExContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEndEx(TinyLangageSIIParser.EndExContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIfinst(TinyLangageSIIParser.IfinstContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIfinst(TinyLangageSIIParser.IfinstContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterComp(TinyLangageSIIParser.CompContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitComp(TinyLangageSIIParser.CompContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterOp(TinyLangageSIIParser.OpContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitOp(TinyLangageSIIParser.OpContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterRead(TinyLangageSIIParser.ReadContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitRead(TinyLangageSIIParser.ReadContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWrite(TinyLangageSIIParser.WriteContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWrite(TinyLangageSIIParser.WriteContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterListID(TinyLangageSIIParser.ListIDContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitListID(TinyLangageSIIParser.ListIDContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) { }
}
