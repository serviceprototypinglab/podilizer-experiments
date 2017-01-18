package lambda_function;

import com.company.*;

public class OutputType {

    public int h;

    public int w;

    public int l;

    public String overview;

    public OutputType() {
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getH() {
        return h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getW() {
        return w;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getL() {
        return l;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public OutputType(int h, int w, int l, String overview) {
        this.h = h;
        this.w = w;
        this.l = l;
        this.overview = overview;
    }
}
