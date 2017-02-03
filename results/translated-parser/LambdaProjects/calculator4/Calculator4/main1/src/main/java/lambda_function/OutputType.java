package lambda_function;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import calculator4.*;

public class OutputType {

    public Exception LambdaException;

    public String LambdaExceptionType;

    public OutputType() {
    }

    public void setLambdaException(Exception LambdaException) {
        this.LambdaException = LambdaException;
    }

    public Exception getLambdaException() {
        return LambdaException;
    }

    public void setLambdaExceptionType(String LambdaExceptionType) {
        this.LambdaExceptionType = LambdaExceptionType;
    }

    public String getLambdaExceptionType() {
        return LambdaExceptionType;
    }

    public OutputType(Exception LambdaException, String LambdaExceptionType) {
        this.LambdaException = LambdaException;
        this.LambdaExceptionType = LambdaExceptionType;
    }
}
