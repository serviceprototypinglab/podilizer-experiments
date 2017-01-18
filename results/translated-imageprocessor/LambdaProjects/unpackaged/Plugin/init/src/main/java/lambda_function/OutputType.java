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

public class OutputType {

    public String plugindirconf = ".";

    public ArrayList<Plugin> plugins;

    public String currentimage;

    public ArrayList<Plugin> plugins;

    public OutputType() {
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

    public OutputType(String plugindirconf, ArrayList<Plugin> plugins, String currentimage, ArrayList<Plugin> plugins) {
        this.plugindirconf = plugindirconf;
        this.plugins = plugins;
        this.currentimage = currentimage;
        this.plugins = plugins;
    }
}
