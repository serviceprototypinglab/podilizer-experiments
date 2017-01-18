package unpackaged;

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

public interface Plugin {

    public String name();

    public String description();

    public String process(String image);

    public Plugin() {
    }
}

class PluginLoader {

    @JsonProperty
    private String plugindirconf = ".";

    @JsonProperty
    private ArrayList<Plugin> plugins;

    public PluginLoader() {
        this.plugins = new ArrayList<Plugin>();
    }

    public void logfail(String context, String s) {
        System.err.println("ERROR: [" + String.format("%12s", context) + "] " + s);
    }

    public ArrayList<Plugin> plugins() {
        return this.plugins;
    }

    public void load() {
        File plugindir = new File(this.plugindirconf);
        File[] files = plugindir.listFiles();
        for (File file : files) {
            if (!file.isFile())
                continue;
            String pluginfile = file.getName();
            if (pluginfile.endsWith(".jar")) {
                System.out.println("plugin: " + pluginfile);
                JarFile jar = null;
                try {
                    jar = new JarFile(file);
                } catch (IOException e) {
                    this.logfail(pluginfile, "Not a plugin: " + e.toString());
                    continue;
                }
                Enumeration<JarEntry> entries = jar.entries();
                for (Enumeration<JarEntry> e = entries; e.hasMoreElements(); ) {
                    JarEntry entry = e.nextElement();
                    System.out.println(" entry: " + entry.getName());
                }
                String classname = pluginfile.split("\\.")[0];
                Plugin p = this.loadPlugin(pluginfile, classname);
                if (p != null) {
                    System.out.println(" name: " + p.name());
                    plugins.add(p);
                }
            }
        }
    }

    public Plugin loadPlugin(String pluginfile, String classname) {
        URL url = null;
        try {
            url = new //" + this.plugindirconf + "/" + pluginfile);
            URL("file://" + this.plugindirconf + "/" + pluginfile);
        } catch (MalformedURLException e) {
            this.logfail(classname, "Inaccessible plugin: " + e.toString());
            return null;
        }
        URL[] urls = { url };
        URLClassLoader loader = new URLClassLoader(urls);
        Class plc = null;
        try {
            plc = Class.forName(classname, true, loader);
        } catch (ClassNotFoundException e) {
            this.logfail(classname, "Invalid plugin: " + e.toString());
            return null;
        }
        Object plo = null;
        try {
            plo = plc.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            this.logfail(classname, "Plugin initialisation failure: " + e.toString());
            return null;
        }
        return (Plugin) plo;
    }
}

public class ImageProcessingApplication {

    @JsonProperty
    private String currentimage;

    @JsonProperty
    private ArrayList<Plugin> plugins;

    public ImageProcessingApplication() {
        this.currentimage = null;
    }

    public void init() {
        PluginLoader pl = new PluginLoader();
        pl.load();
        this.plugins = pl.plugins();
        loop();
    }

    public void loop() {
        while (true) menu();
    }

    public void menu() {
        System.out.println("IPApp >>");
        System.out.println("0 show");
        System.out.println("1 generate");
        System.out.println("2 process");
        System.out.println("3 quit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equals("0")) {
            System.out.println("Image: " + this.currentimage);
        } else if (choice.equals("1")) {
            this.currentimage = "+++++ Fence +++++ || House ||";
        } else if (choice.equals("2")) {
            System.out.println("Which plugin?");
            for (Plugin plugin : plugins) {
                System.out.println(plugin.name());
            }
            choice = scanner.next();
            for (Plugin plugin : plugins) {
                System.out.println("#" + plugin.name() + "#" + choice + "#");
                if (plugin.name().equals(choice)) {
                    System.out.println("Processing...");
                    this.currentimage = plugin.process(this.currentimage);
                }
            }
        } else if (choice.equals("3")) {
            System.exit(0);
        }
    }

    public static final void main(String[] args) {
        ImageProcessingApplication ipapp = new ImageProcessingApplication();
        ipapp.init();
    }
}
