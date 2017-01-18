package lambda_function;

import java.util.ArrayList;
import unpackaged.*;

public class InputType {

    public ArrayList<String> companies;

    public int entries;

    public int entries1;

    public InputType() {
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

    public void setEntries1(int entries1) {
        this.entries1 = entries1;
    }

    public int getEntries1() {
        return entries1;
    }

    public InputType(ArrayList<String> companies, int entries, int entries1) {
        this.companies = companies;
        this.entries = entries;
        this.entries1 = entries1;
    }
}
