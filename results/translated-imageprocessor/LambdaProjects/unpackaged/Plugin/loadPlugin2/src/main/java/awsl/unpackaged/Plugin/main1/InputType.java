package awsl.unpackaged.Plugin.main1;

import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.MalformedURLException;
import unpackaged.*;

public class InputType {

    public String[] args;

    public InputType() {
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public InputType(String[] args) {
        this.args = args;
    }
}
