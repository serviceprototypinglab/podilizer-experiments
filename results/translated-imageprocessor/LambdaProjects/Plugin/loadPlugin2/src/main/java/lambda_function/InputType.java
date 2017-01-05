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

public class InputType {

    public String plugindirconf = ".";

    public ArrayList<Plugin> plugins;

    public String currentimage;

    public ArrayList<Plugin> plugins;

    public String pluginfile;

    public String classname;

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

    public void setPluginfile(String pluginfile) {
        this.pluginfile = pluginfile;
    }

    public String getPluginfile() {
        return pluginfile;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassname() {
        return classname;
    }

    public InputType(String plugindirconf, ArrayList<Plugin> plugins, String currentimage, ArrayList<Plugin> plugins, String pluginfile, String classname) {
        this.plugindirconf = plugindirconf;
        this.plugins = plugins;
        this.currentimage = currentimage;
        this.plugins = plugins;
        this.pluginfile = pluginfile;
        this.classname = classname;
    }
}
