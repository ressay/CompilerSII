// Generated from TinyLangageSII.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinyLangageSIIParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, INT=9, 
		FLOAT=10, SCAN=11, PRINT=12, START=13, IF=14, THEN=15, ELSE=16, ENDIF=17, 
		ID=18, PLUS=19, MINUS=20, MUL=21, DIV=22, SUP=23, INF=24, INTEGERVAL=25, 
		FLOATVAL=26, WHITESPACE=27, STR=28;
	public static final int
		RULE_prog = 0, RULE_declarations = 1, RULE_dec = 2, RULE_type = 3, RULE_vars = 4, 
		RULE_identifier = 5, RULE_val = 6, RULE_insts = 7, RULE_inst = 8, RULE_affect = 9, 
		RULE_exp = 10, RULE_t = 11, RULE_opmi = 12, RULE_opma = 13, RULE_endEx = 14, 
		RULE_ifinst = 15, RULE_comp = 16, RULE_op = 17, RULE_read = 18, RULE_write = 19, 
		RULE_listID = 20;
	public static final String[] ruleNames = {
		"prog", "declarations", "dec", "type", "vars", "identifier", "val", "insts", 
		"inst", "affect", "exp", "t", "opmi", "opma", "endEx", "ifinst", "comp", 
		"op", "read", "write", "listID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'compil'", "'('", "')'", "'{'", "'}'", "';'", "','", "'='", "'intCompil'", 
		"'floatCompil'", "'scancompil'", "'printcompil'", "'start'", "'if'", "'then'", 
		"'else'", "'endif'", null, "'+'", "'-'", "'*'", "'/'", "'>'", "'<'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "INT", "FLOAT", 
		"SCAN", "PRINT", "START", "IF", "THEN", "ELSE", "ENDIF", "ID", "PLUS", 
		"MINUS", "MUL", "DIV", "SUP", "INF", "INTEGERVAL", "FLOATVAL", "WHITESPACE", 
		"STR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TinyLangageSII.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TinyLangageSIIParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TinyLangageSIIParser.ID, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode START() { return getToken(TinyLangageSIIParser.START, 0); }
		public InstsContext insts() {
			return getRuleContext(InstsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(T__0);
				setState(43);
				match(ID);
				setState(44);
				match(T__1);
				setState(45);
				match(T__2);
				setState(46);
				match(T__3);
				setState(47);
				declarations();
				setState(48);
				match(START);
				setState(49);
				insts();
				setState(50);
				match(T__4);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(55);
				dec();
				setState(56);
				declarations();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				dec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitDec(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			type();
			setState(62);
			vars();
			setState(63);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TinyLangageSIIParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TinyLangageSIIParser.FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TinyLangageSIIParser.ID, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitVars(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_vars);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				{
				setState(67);
				match(ID);
				setState(68);
				match(T__6);
				setState(69);
				vars();
				}
				}
				break;
			case 2:
				{
				setState(70);
				match(ID);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TinyLangageSIIParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValContext extends ParserRuleContext {
		public TerminalNode INTEGERVAL() { return getToken(TinyLangageSIIParser.INTEGERVAL, 0); }
		public TerminalNode FLOATVAL() { return getToken(TinyLangageSIIParser.FLOATVAL, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitVal(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==INTEGERVAL || _la==FLOATVAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstsContext extends ParserRuleContext {
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public InstsContext insts() {
			return getRuleContext(InstsContext.class,0);
		}
		public InstsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterInsts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitInsts(this);
		}
	}

	public final InstsContext insts() throws RecognitionException {
		InstsContext _localctx = new InstsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_insts);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(77);
				inst();
				setState(78);
				match(T__5);
				setState(79);
				insts();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				inst();
				setState(82);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstContext extends ParserRuleContext {
		public AffectContext affect() {
			return getRuleContext(AffectContext.class,0);
		}
		public IfinstContext ifinst() {
			return getRuleContext(IfinstContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitInst(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_inst);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				affect();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				ifinst();
				}
				break;
			case SCAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				read();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				write();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AffectContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterAffect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitAffect(this);
		}
	}

	public final AffectContext affect() throws RecognitionException {
		AffectContext _localctx = new AffectContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_affect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			identifier();
			setState(93);
			match(T__7);
			setState(94);
			exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public OpmiContext opmi() {
			return getRuleContext(OpmiContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exp);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				t();
				setState(97);
				opmi();
				setState(98);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				t();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TContext extends ParserRuleContext {
		public EndExContext endEx() {
			return getRuleContext(EndExContext.class,0);
		}
		public OpmaContext opma() {
			return getRuleContext(OpmaContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitT(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_t);
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				endEx();
				setState(104);
				opma();
				setState(105);
				t();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				endEx();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpmiContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(TinyLangageSIIParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TinyLangageSIIParser.MINUS, 0); }
		public OpmiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opmi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterOpmi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitOpmi(this);
		}
	}

	public final OpmiContext opmi() throws RecognitionException {
		OpmiContext _localctx = new OpmiContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_opmi);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpmaContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(TinyLangageSIIParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(TinyLangageSIIParser.DIV, 0); }
		public OpmaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterOpma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitOpma(this);
		}
	}

	public final OpmaContext opma() throws RecognitionException {
		OpmaContext _localctx = new OpmaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_opma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndExContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public EndExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endEx; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterEndEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitEndEx(this);
		}
	}

	public final EndExContext endEx() throws RecognitionException {
		EndExContext _localctx = new EndExContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_endEx);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				identifier();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(T__1);
				setState(116);
				exp();
				setState(117);
				match(T__2);
				}
				break;
			case INTEGERVAL:
			case FLOATVAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				val();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfinstContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TinyLangageSIIParser.IF, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public TerminalNode THEN() { return getToken(TinyLangageSIIParser.THEN, 0); }
		public List<InstsContext> insts() {
			return getRuleContexts(InstsContext.class);
		}
		public InstsContext insts(int i) {
			return getRuleContext(InstsContext.class,i);
		}
		public TerminalNode ENDIF() { return getToken(TinyLangageSIIParser.ENDIF, 0); }
		public TerminalNode ELSE() { return getToken(TinyLangageSIIParser.ELSE, 0); }
		public IfinstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifinst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterIfinst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitIfinst(this);
		}
	}

	public final IfinstContext ifinst() throws RecognitionException {
		IfinstContext _localctx = new IfinstContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifinst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(IF);
			setState(123);
			match(T__1);
			setState(124);
			comp();
			setState(125);
			match(T__2);
			setState(126);
			match(THEN);
			setState(127);
			insts();
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENDIF:
				{
				}
				break;
			case ELSE:
				{
				setState(129);
				match(ELSE);
				setState(130);
				insts();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(133);
			match(ENDIF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitComp(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			exp();
			setState(136);
			op();
			setState(137);
			exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public TerminalNode SUP() { return getToken(TinyLangageSIIParser.SUP, 0); }
		public TerminalNode INF() { return getToken(TinyLangageSIIParser.INF, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !(_la==SUP || _la==INF) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(TinyLangageSIIParser.SCAN, 0); }
		public ListIDContext listID() {
			return getRuleContext(ListIDContext.class,0);
		}
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitRead(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(SCAN);
			setState(142);
			match(T__1);
			setState(143);
			listID();
			setState(144);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(TinyLangageSIIParser.PRINT, 0); }
		public TerminalNode STR() { return getToken(TinyLangageSIIParser.STR, 0); }
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitWrite(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(PRINT);
			setState(147);
			match(T__1);
			setState(148);
			match(STR);
			setState(149);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListIDContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ListIDContext listID() {
			return getRuleContext(ListIDContext.class,0);
		}
		public ListIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).enterListID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinyLangageSIIListener ) ((TinyLangageSIIListener)listener).exitListID(this);
		}
	}

	public final ListIDContext listID() throws RecognitionException {
		ListIDContext _localctx = new ListIDContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_listID);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				identifier();
				setState(152);
				match(T__6);
				setState(153);
				listID();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00a1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\28\n\2\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\5\6J\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\tW\n\t\3\n\3\n\3\n\3\n\5\n]\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\5\fh\n\f\3\r\3\r\3\r\3\r\3\r\5\ro\n\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20{\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0086\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u009f\n\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*\2\7\3\2\13\f\3\2\33\34\3\2\25\26\3\2\27\30\3\2\31\32\2\u0098\2\67"+
		"\3\2\2\2\4=\3\2\2\2\6?\3\2\2\2\bC\3\2\2\2\nI\3\2\2\2\fK\3\2\2\2\16M\3"+
		"\2\2\2\20V\3\2\2\2\22\\\3\2\2\2\24^\3\2\2\2\26g\3\2\2\2\30n\3\2\2\2\32"+
		"p\3\2\2\2\34r\3\2\2\2\36z\3\2\2\2 |\3\2\2\2\"\u0089\3\2\2\2$\u008d\3\2"+
		"\2\2&\u008f\3\2\2\2(\u0094\3\2\2\2*\u009e\3\2\2\2,-\7\3\2\2-.\7\24\2\2"+
		"./\7\4\2\2/\60\7\5\2\2\60\61\7\6\2\2\61\62\5\4\3\2\62\63\7\17\2\2\63\64"+
		"\5\20\t\2\64\65\7\7\2\2\658\3\2\2\2\668\3\2\2\2\67,\3\2\2\2\67\66\3\2"+
		"\2\28\3\3\2\2\29:\5\6\4\2:;\5\4\3\2;>\3\2\2\2<>\5\6\4\2=9\3\2\2\2=<\3"+
		"\2\2\2>\5\3\2\2\2?@\5\b\5\2@A\5\n\6\2AB\7\b\2\2B\7\3\2\2\2CD\t\2\2\2D"+
		"\t\3\2\2\2EF\7\24\2\2FG\7\t\2\2GJ\5\n\6\2HJ\7\24\2\2IE\3\2\2\2IH\3\2\2"+
		"\2J\13\3\2\2\2KL\7\24\2\2L\r\3\2\2\2MN\t\3\2\2N\17\3\2\2\2OP\5\22\n\2"+
		"PQ\7\b\2\2QR\5\20\t\2RW\3\2\2\2ST\5\22\n\2TU\7\b\2\2UW\3\2\2\2VO\3\2\2"+
		"\2VS\3\2\2\2W\21\3\2\2\2X]\5\24\13\2Y]\5 \21\2Z]\5&\24\2[]\5(\25\2\\X"+
		"\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\23\3\2\2\2^_\5\f\7\2_`\7\n"+
		"\2\2`a\5\26\f\2a\25\3\2\2\2bc\5\30\r\2cd\5\32\16\2de\5\26\f\2eh\3\2\2"+
		"\2fh\5\30\r\2gb\3\2\2\2gf\3\2\2\2h\27\3\2\2\2ij\5\36\20\2jk\5\34\17\2"+
		"kl\5\30\r\2lo\3\2\2\2mo\5\36\20\2ni\3\2\2\2nm\3\2\2\2o\31\3\2\2\2pq\t"+
		"\4\2\2q\33\3\2\2\2rs\t\5\2\2s\35\3\2\2\2t{\5\f\7\2uv\7\4\2\2vw\5\26\f"+
		"\2wx\7\5\2\2x{\3\2\2\2y{\5\16\b\2zt\3\2\2\2zu\3\2\2\2zy\3\2\2\2{\37\3"+
		"\2\2\2|}\7\20\2\2}~\7\4\2\2~\177\5\"\22\2\177\u0080\7\5\2\2\u0080\u0081"+
		"\7\21\2\2\u0081\u0085\5\20\t\2\u0082\u0086\3\2\2\2\u0083\u0084\7\22\2"+
		"\2\u0084\u0086\5\20\t\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\7\23\2\2\u0088!\3\2\2\2\u0089\u008a\5\26\f"+
		"\2\u008a\u008b\5$\23\2\u008b\u008c\5\26\f\2\u008c#\3\2\2\2\u008d\u008e"+
		"\t\6\2\2\u008e%\3\2\2\2\u008f\u0090\7\r\2\2\u0090\u0091\7\4\2\2\u0091"+
		"\u0092\5*\26\2\u0092\u0093\7\5\2\2\u0093\'\3\2\2\2\u0094\u0095\7\16\2"+
		"\2\u0095\u0096\7\4\2\2\u0096\u0097\7\36\2\2\u0097\u0098\7\5\2\2\u0098"+
		")\3\2\2\2\u0099\u009a\5\f\7\2\u009a\u009b\7\t\2\2\u009b\u009c\5*\26\2"+
		"\u009c\u009f\3\2\2\2\u009d\u009f\5\f\7\2\u009e\u0099\3\2\2\2\u009e\u009d"+
		"\3\2\2\2\u009f+\3\2\2\2\f\67=IV\\gnz\u0085\u009e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}