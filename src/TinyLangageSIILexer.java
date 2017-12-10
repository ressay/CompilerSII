// Generated from TinyLangageSII.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinyLangageSIILexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, INT=9, 
		FLOAT=10, SCAN=11, PRINT=12, START=13, IF=14, THEN=15, ELSE=16, ENDIF=17, 
		ID=18, PLUS=19, MINUS=20, MUL=21, DIV=22, SUP=23, INF=24, INTEGERVAL=25, 
		FLOATVAL=26, WHITESPACE=27, COMMENTS=28, STR=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "INT", 
		"FLOAT", "SCAN", "PRINT", "START", "IF", "THEN", "ELSE", "ENDIF", "ID", 
		"PLUS", "MINUS", "MUL", "DIV", "SUP", "INF", "INTEGERVAL", "FLOATVAL", 
		"WHITESPACE", "COMMENTS", "STR"
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
		"COMMENTS", "STR"
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


	public TinyLangageSIILexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TinyLangageSII.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00e5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\7\23\u009b\n\23\f\23"+
		"\16\23\u009e\13\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\5\32\u00ae\n\32\3\32\3\32\7\32\u00b2\n\32\f\32\16\32"+
		"\u00b5\13\32\5\32\u00b7\n\32\3\33\3\33\5\33\u00bb\n\33\3\33\3\33\7\33"+
		"\u00bf\n\33\f\33\16\33\u00c2\13\33\3\33\3\33\7\33\u00c6\n\33\f\33\16\33"+
		"\u00c9\13\33\5\33\u00cb\n\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\7\35\u00d4"+
		"\n\35\f\35\16\35\u00d7\13\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00df"+
		"\n\36\f\36\16\36\u00e2\13\36\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\n\4\2C\\c|\5\2\62;C\\"+
		"c|\4\2--//\3\2\63;\3\2\62;\4\2\13\f\"\"\3\2\f\f\3\2$$\2\u00ef\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3"+
		"=\3\2\2\2\5D\3\2\2\2\7F\3\2\2\2\tH\3\2\2\2\13J\3\2\2\2\rL\3\2\2\2\17N"+
		"\3\2\2\2\21P\3\2\2\2\23R\3\2\2\2\25\\\3\2\2\2\27h\3\2\2\2\31s\3\2\2\2"+
		"\33\177\3\2\2\2\35\u0085\3\2\2\2\37\u0088\3\2\2\2!\u008d\3\2\2\2#\u0092"+
		"\3\2\2\2%\u0098\3\2\2\2\'\u009f\3\2\2\2)\u00a1\3\2\2\2+\u00a3\3\2\2\2"+
		"-\u00a5\3\2\2\2/\u00a7\3\2\2\2\61\u00a9\3\2\2\2\63\u00b6\3\2\2\2\65\u00ca"+
		"\3\2\2\2\67\u00cc\3\2\2\29\u00d0\3\2\2\2;\u00da\3\2\2\2=>\7e\2\2>?\7q"+
		"\2\2?@\7o\2\2@A\7r\2\2AB\7k\2\2BC\7n\2\2C\4\3\2\2\2DE\7*\2\2E\6\3\2\2"+
		"\2FG\7+\2\2G\b\3\2\2\2HI\7}\2\2I\n\3\2\2\2JK\7\177\2\2K\f\3\2\2\2LM\7"+
		"=\2\2M\16\3\2\2\2NO\7.\2\2O\20\3\2\2\2PQ\7?\2\2Q\22\3\2\2\2RS\7k\2\2S"+
		"T\7p\2\2TU\7v\2\2UV\7E\2\2VW\7q\2\2WX\7o\2\2XY\7r\2\2YZ\7k\2\2Z[\7n\2"+
		"\2[\24\3\2\2\2\\]\7h\2\2]^\7n\2\2^_\7q\2\2_`\7c\2\2`a\7v\2\2ab\7E\2\2"+
		"bc\7q\2\2cd\7o\2\2de\7r\2\2ef\7k\2\2fg\7n\2\2g\26\3\2\2\2hi\7u\2\2ij\7"+
		"e\2\2jk\7c\2\2kl\7p\2\2lm\7e\2\2mn\7q\2\2no\7o\2\2op\7r\2\2pq\7k\2\2q"+
		"r\7n\2\2r\30\3\2\2\2st\7r\2\2tu\7t\2\2uv\7k\2\2vw\7p\2\2wx\7v\2\2xy\7"+
		"e\2\2yz\7q\2\2z{\7o\2\2{|\7r\2\2|}\7k\2\2}~\7n\2\2~\32\3\2\2\2\177\u0080"+
		"\7u\2\2\u0080\u0081\7v\2\2\u0081\u0082\7c\2\2\u0082\u0083\7t\2\2\u0083"+
		"\u0084\7v\2\2\u0084\34\3\2\2\2\u0085\u0086\7k\2\2\u0086\u0087\7h\2\2\u0087"+
		"\36\3\2\2\2\u0088\u0089\7v\2\2\u0089\u008a\7j\2\2\u008a\u008b\7g\2\2\u008b"+
		"\u008c\7p\2\2\u008c \3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f\7n\2\2\u008f"+
		"\u0090\7u\2\2\u0090\u0091\7g\2\2\u0091\"\3\2\2\2\u0092\u0093\7g\2\2\u0093"+
		"\u0094\7p\2\2\u0094\u0095\7f\2\2\u0095\u0096\7k\2\2\u0096\u0097\7h\2\2"+
		"\u0097$\3\2\2\2\u0098\u009c\t\2\2\2\u0099\u009b\t\3\2\2\u009a\u0099\3"+
		"\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"&\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7-\2\2\u00a0(\3\2\2\2\u00a1"+
		"\u00a2\7/\2\2\u00a2*\3\2\2\2\u00a3\u00a4\7,\2\2\u00a4,\3\2\2\2\u00a5\u00a6"+
		"\7\61\2\2\u00a6.\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\60\3\2\2\2\u00a9\u00aa"+
		"\7>\2\2\u00aa\62\3\2\2\2\u00ab\u00b7\7\62\2\2\u00ac\u00ae\t\4\2\2\u00ad"+
		"\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b3\t\5"+
		"\2\2\u00b0\u00b2\t\6\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b6\u00ab\3\2\2\2\u00b6\u00ad\3\2\2\2\u00b7\64\3\2\2\2\u00b8\u00cb"+
		"\7\62\2\2\u00b9\u00bb\t\4\2\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2"+
		"\u00bb\u00bc\3\2\2\2\u00bc\u00c0\t\5\2\2\u00bd\u00bf\t\6\2\2\u00be\u00bd"+
		"\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c7\7\60\2\2\u00c4\u00c6\t"+
		"\6\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00b8\3\2"+
		"\2\2\u00ca\u00ba\3\2\2\2\u00cb\66\3\2\2\2\u00cc\u00cd\t\7\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00cf\b\34\2\2\u00cf8\3\2\2\2\u00d0\u00d1\7\61\2\2\u00d1"+
		"\u00d5\7\61\2\2\u00d2\u00d4\n\b\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00d9\b\35\2\2\u00d9:\3\2\2\2\u00da\u00e0\7$\2\2"+
		"\u00db\u00df\n\t\2\2\u00dc\u00dd\7^\2\2\u00dd\u00df\7$\2\2\u00de\u00db"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7$"+
		"\2\2\u00e4<\3\2\2\2\16\2\u009c\u00ad\u00b3\u00b6\u00ba\u00c0\u00c7\u00ca"+
		"\u00d5\u00de\u00e0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}