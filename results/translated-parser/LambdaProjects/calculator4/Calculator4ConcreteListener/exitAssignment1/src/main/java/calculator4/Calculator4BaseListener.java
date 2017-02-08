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
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.fasterxml.jackson.annotation.*;

/**
 * This class provides an empty implementation of {@link Calculator4Listener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class Calculator4BaseListener implements Calculator4Listener {

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterProgram(Calculator4Parser.ProgramContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitProgram(Calculator4Parser.ProgramContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterAssignment(Calculator4Parser.AssignmentContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitAssignment(Calculator4Parser.AssignmentContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterMultOrDiv(Calculator4Parser.MultOrDivContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitMultOrDiv(Calculator4Parser.MultOrDivContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterIdentifier(Calculator4Parser.IdentifierContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitIdentifier(Calculator4Parser.IdentifierContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterPrint(Calculator4Parser.PrintContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitPrint(Calculator4Parser.PrintContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterString(Calculator4Parser.StringContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitString(Calculator4Parser.StringContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterAddOrSubtract(Calculator4Parser.AddOrSubtractContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitAddOrSubtract(Calculator4Parser.AddOrSubtractContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterParenExpression(Calculator4Parser.ParenExpressionContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitParenExpression(Calculator4Parser.ParenExpressionContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterInteger(Calculator4Parser.IntegerContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitInteger(Calculator4Parser.IntegerContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterArg(Calculator4Parser.ArgContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitArg(Calculator4Parser.ArgContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void visitTerminal(TerminalNode node) {
    }

    /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
    @Override
    public void visitErrorNode(ErrorNode node) {
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
