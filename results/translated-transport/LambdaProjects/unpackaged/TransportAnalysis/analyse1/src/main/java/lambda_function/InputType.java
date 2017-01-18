package lambda_function;

import com.csvreader.CsvReader;
import java.nio.charset.Charset;
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
