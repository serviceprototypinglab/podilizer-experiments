package awsl.unpackaged.TransportTest.main1;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import unpackaged.*;

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
