package awsl.calculator4.Calculator4.main1;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import calculator4.*;

public class InputType {

    public String[] args;

    public InputType() {
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public InputType(String[] args) {
        this.args = args;
    }
}
