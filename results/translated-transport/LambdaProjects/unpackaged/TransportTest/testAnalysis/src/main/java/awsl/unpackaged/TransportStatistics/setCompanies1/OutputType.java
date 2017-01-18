package awsl.unpackaged.TransportStatistics.setCompanies1;

import java.util.ArrayList;
import unpackaged.*;

public class OutputType {

    public ArrayList<String> companies;

    public int entries;

    public boolean setCompaniesResult;

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

    public void setSetCompaniesResult(boolean setCompaniesResult) {
        this.setCompaniesResult = setCompaniesResult;
    }

    public boolean getSetCompaniesResult() {
        return setCompaniesResult;
    }

    public OutputType(ArrayList<String> companies, int entries, boolean setCompaniesResult) {
        this.companies = companies;
        this.entries = entries;
        this.setCompaniesResult = setCompaniesResult;
    }
}
