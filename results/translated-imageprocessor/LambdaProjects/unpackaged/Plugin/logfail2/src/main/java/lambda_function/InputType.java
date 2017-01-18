package lambda_function;

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

    public String plugindirconf = ".";

    public ArrayList<Plugin> plugins;

    public String currentimage;

    public ArrayList<Plugin> plugins;

    public String context;

    public String s;

    public InputType() {
    }

    public void setPlugindirconf(String plugindirconf) {
        this.plugindirconf = plugindirconf;
    }

    public String getPlugindirconf() {
        return plugindirconf;
    }

    public void setPlugins(ArrayList<Plugin> plugins) {
        this.plugins = plugins;
    }

    public ArrayList<Plugin> getPlugins() {
        return plugins;
    }

    public void setCurrentimage(String currentimage) {
        this.currentimage = currentimage;
    }

    public String getCurrentimage() {
        return currentimage;
    }

    public void setPlugins(ArrayList<Plugin> plugins) {
        this.plugins = plugins;
    }

    public ArrayList<Plugin> getPlugins() {
        return plugins;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public InputType(String plugindirconf, ArrayList<Plugin> plugins, String currentimage, ArrayList<Plugin> plugins, String context, String s) {
        this.plugindirconf = plugindirconf;
        this.plugins = plugins;
        this.currentimage = currentimage;
        this.plugins = plugins;
        this.context = context;
        this.s = s;
    }
}
