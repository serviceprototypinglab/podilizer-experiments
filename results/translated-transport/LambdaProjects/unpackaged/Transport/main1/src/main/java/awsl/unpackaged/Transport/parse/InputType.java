package awsl.unpackaged.Transport.parse;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.net.URL;
import unpackaged.*;

public class InputType {

    public TransportStatistics stats;

    public InputType() {
    }

    public void setStats(TransportStatistics stats) {
        this.stats = stats;
    }

    public TransportStatistics getStats() {
        return stats;
    }

    public InputType(TransportStatistics stats) {
        this.stats = stats;
    }
}
