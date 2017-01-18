package lambda_function;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.net.URL;
import unpackaged.*;

public class InputType {

    public TransportStatistics stats;

    public String fileurl;

    public String filename;

    public InputType() {
    }

    public void setStats(TransportStatistics stats) {
        this.stats = stats;
    }

    public TransportStatistics getStats() {
        return stats;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public InputType(TransportStatistics stats, String fileurl, String filename) {
        this.stats = stats;
        this.fileurl = fileurl;
        this.filename = filename;
    }
}
