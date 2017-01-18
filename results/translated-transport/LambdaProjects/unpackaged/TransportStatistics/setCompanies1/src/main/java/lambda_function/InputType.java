package lambda_function;

import java.util.ArrayList;
import unpackaged.*;

public class InputType {

    public ArrayList<String> companies;

    public int entries;

    public ArrayList<String> companies1;

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

    public void setCompanies1(ArrayList<String> companies1) {
        this.companies1 = companies1;
    }

    public ArrayList<String> getCompanies1() {
        return companies1;
    }

    public InputType(ArrayList<String> companies, int entries, ArrayList<String> companies1) {
        this.companies = companies;
        this.entries = entries;
        this.companies1 = companies1;
    }
}
