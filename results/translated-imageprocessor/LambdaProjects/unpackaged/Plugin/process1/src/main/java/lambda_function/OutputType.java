package lambda_function;

import java.util.Random;
import unpackaged.*;

public class OutputType {

    public String processResult;

    public OutputType() {
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult;
    }

    public String getProcessResult() {
        return processResult;
    }

    public OutputType(String processResult) {
        this.processResult = processResult;
    }
}
