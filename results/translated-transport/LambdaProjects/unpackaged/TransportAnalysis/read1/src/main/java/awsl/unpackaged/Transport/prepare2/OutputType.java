package awsl.unpackaged.Transport.prepare2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.net.URL;
import unpackaged.*;

public class OutputType {

    public TransportStatistics stats;

    public Exception LambdaException;

    public String LambdaExceptionType;

    public OutputType() {
    }

    public void setStats(TransportStatistics stats) {
        this.stats = stats;
    }

    public TransportStatistics getStats() {
        return stats;
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

    public OutputType(TransportStatistics stats, Exception LambdaException, String LambdaExceptionType) {
        this.stats = stats;
        this.LambdaException = LambdaException;
        this.LambdaExceptionType = LambdaExceptionType;
    }
}
