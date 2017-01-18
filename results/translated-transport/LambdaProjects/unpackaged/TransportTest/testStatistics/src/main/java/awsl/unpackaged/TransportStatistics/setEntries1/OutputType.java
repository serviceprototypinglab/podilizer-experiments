package awsl.unpackaged.TransportStatistics.setEntries1;

import java.util.ArrayList;
import unpackaged.*;

public class OutputType {

    public ArrayList<String> companies;

    public int entries;

    public boolean setEntriesResult;

    public OutputType() {
    }

    public void setCompanies(ArrayList<String> companies) {
        this.companies = companies;
    }

    public ArrayList<String> getCompanies() {
        return companies;
    }

    public void setEntries(int entries) {
        this.entries = entries;
    }

    public int getEntries() {
        return entries;
    }

    public void setSetEntriesResult(boolean setEntriesResult) {
        this.setEntriesResult = setEntriesResult;
    }

    public boolean getSetEntriesResult() {
        return setEntriesResult;
    }

    public OutputType(ArrayList<String> companies, int entries, boolean setEntriesResult) {
        this.companies = companies;
        this.entries = entries;
        this.setEntriesResult = setEntriesResult;
    }
}
