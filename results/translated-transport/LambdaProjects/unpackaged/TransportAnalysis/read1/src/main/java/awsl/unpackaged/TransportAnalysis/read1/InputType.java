package awsl.unpackaged.TransportAnalysis.read1;

import com.csvreader.CsvReader;
import java.nio.charset.Charset;
import unpackaged.*;

public class InputType {

    public String filename;

    public InputType() {
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public InputType(String filename) {
        this.filename = filename;
    }
}
