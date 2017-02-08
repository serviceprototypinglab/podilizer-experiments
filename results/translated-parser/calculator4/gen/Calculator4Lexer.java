// Generated from Calculator4.antlr by ANTLR 4.5.3
package calculator4;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.ho.yaml.Yaml;
import java.io.*;
import awsl.*;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import com.fasterxml.jackson.annotation.*;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class Calculator4Lexer extends Lexer {

    static {
        RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION);
    }

    @JsonProperty
    protected static final DFA[] _decisionToDFA;

    @JsonProperty
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();

    @JsonProperty
    public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9, T__9 = 10, STRING = 11, ID = 12, INT = 13, WS = 14;

    @JsonProperty
    public static String[] modeNames = { "DEFAULT_MODE" };

    @JsonProperty
    public static final String[] ruleNames = { "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", "T__9", "STRING", "ID", "INT", "WS" };

    @JsonProperty
    private static final String[] _LITERAL_NAMES = { null, "';'", "'='", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'print'", "','" };

    @JsonProperty
    private static final String[] _SYMBOLIC_NAMES = { null, null, null, null, null, null, null, null, null, null, null, "STRING", "ID", "INT", "WS" };

    @JsonProperty
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
    @Deprecated
    @JsonProperty
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
    @JsonIgnore
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    @JsonIgnore
    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    public Calculator4Lexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    @JsonIgnore
    public String getGrammarFileName() {
        return "Calculator4.antlr";
    }

    @Override
    @JsonIgnore
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    @JsonIgnore
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    @JsonIgnore
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    @JsonIgnore
    public ATN getATN() {
        return _ATN;
    }

    @JsonProperty
    public static final String _serializedATN = "\3а훑舆괭䐗껱趀ꫝ\2\20Q\b\1\4\2\t\2\4" + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3" + "\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3" + "\f\3\f\7\f:\n\f\f\f\16\f=\13\f\3\f\3\f\3\r\6\rB\n\r\r\r\16\rC\3\16\6\16" + "G\n\16\r\16\16\16H\3\17\6\17L\n\17\r\17\16\17M\3\17\3\17\2\2\20\3\3\5" + "\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\4" + "\4\2C\\c|\5\2\13\f\17\17\"\"T\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t" + "\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2" + "\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3" + "\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17" + "+\3\2\2\2\21-\3\2\2\2\23/\3\2\2\2\25\65\3\2\2\2\27\67\3\2\2\2\31A\3\2" + "\2\2\33F\3\2\2\2\35K\3\2\2\2\37 \7=\2\2 \4\3\2\2\2!\"\7?\2\2\"\6\3\2\2" + "\2#$\7*\2\2$\b\3\2\2\2%&\7+\2\2&\n\3\2\2\2\'(\7,\2\2(\f\3\2\2\2)*\7\61" + "\2\2*\16\3\2\2\2+,\7-\2\2,\20\3\2\2\2-.\7/\2\2.\22\3\2\2\2/\60\7r\2\2" + "\60\61\7t\2\2\61\62\7k\2\2\62\63\7p\2\2\63\64\7v\2\2\64\24\3\2\2\2\65" + "\66\7.\2\2\66\26\3\2\2\2\67;\7$\2\28:\4\"\298\3\2\2\2:=\3\2\2\2" + ";9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7$\2\2?\30\3\2\2\2@B\t\2\2" + "\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\32\3\2\2\2EG\4\62;\2FE\3\2" + "\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\34\3\2\2\2JL\t\3\2\2KJ\3\2\2\2LM\3" + "\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\b\17\2\2P\36\3\2\2\2\7\2;CHM\3" + "\b\2\2";

    @JsonProperty
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public static String byteBufferToString(ByteBuffer buffer, Charset charset) {
        byte[] bytes;
        if (buffer.hasArray()) {
            bytes = buffer.array();
        } else {
            bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
        }
        return new String(bytes, charset);
    }
}
