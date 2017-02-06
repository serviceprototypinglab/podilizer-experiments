package unpackaged;

import com.fasterxml.jackson.annotation.*;

public interface Plugin {

    public String name();

    public String description();

    public String process(String image);

    public Plugin() {
    }
}

class Test implements Plugin {

    public Test() {
    }

    public String name() {
        return "test";
    }

    public String description() {
        return "Only for testing. Returns the input unmodified.";
    }

    public String process(String image) {
        return image;
    }
}
