package awsl.unpackaged.TransportAnalysis.read1;

import com.csvreader.CsvReader;
import java.nio.charset.Charset;
import unpackaged.*;

public class OutputType {

    public TransportStatistics readResult;

    public Exception LambdaException;

    public String LambdaExceptionType;

    public OutputType() {
    }

    public void setReadResult(TransportStatistics readResult) {
        this.readResult = readResult;
    }

    public TransportStatistics getReadResult() {
        return readResult;
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

    public OutputType(TransportStatistics readResult, Exception LambdaException, String LambdaExceptionType) {
        this.readResult = readResult;
        this.LambdaException = LambdaException;
        this.LambdaExceptionType = LambdaExceptionType;
    }
}
