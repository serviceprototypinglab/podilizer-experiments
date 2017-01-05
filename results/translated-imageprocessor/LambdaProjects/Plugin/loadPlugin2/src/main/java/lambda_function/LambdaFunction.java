package lambda_function;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class LambdaFunction implements RequestHandler<InputType, OutputType> {

    private String plugindirconf = ".";

    private ArrayList<Plugin> plugins;

    private String currentimage;

    private ArrayList<Plugin> plugins;

    public OutputType handleRequest(InputType inputType, Context context) {
        this.plugindirconf = inputType.getPlugindirconf();
        this.plugins = inputType.getPlugins();
        this.currentimage = inputType.getCurrentimage();
        this.plugins = inputType.getPlugins();
        Plugin loadPluginLambdaResult = loadPlugin(inputType.getPluginfile(), inputType.getClassname());
        {
            OutputType outputType = new OutputType(this.plugindirconf, this.plugins, this.currentimage, this.plugins, loadPluginLambdaResult);
            return outputType;
        }
    }

    public String name();

    public String description();

    public String process(String image);

    private Plugin loadPlugin(String pluginfile, String classname) {
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
