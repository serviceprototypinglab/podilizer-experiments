package awsl.unpackaged.Transport.parse;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.net.URL;
import unpackaged.*;

public class OutputType {

    public TransportStatistics stats;

    public OutputType() {
    }

    public void setStats(TransportStatistics stats) {
        this.stats = stats;
    }

    public TransportStatistics getStats() {
        return stats;
    }

    public OutputType(TransportStatistics stats) {
        this.stats = stats;
    }
}
