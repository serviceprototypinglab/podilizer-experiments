package awsl.unpackaged.Transport.main1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.net.URL;
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
