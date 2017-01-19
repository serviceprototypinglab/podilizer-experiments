package lambda_function;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import com.fasterxml.jackson.annotation.*;
import org.ho.yaml.Yaml;
import java.io.*;
import awsl.*;
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
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.io.*;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.util.IOUtils;
import com.fasterxml.jackson.databind.*;
import unpackaged.*;

public class LambdaFunction implements RequestStreamHandler {

    private String plugindirconf = ".";

    private ArrayList<Plugin> plugins;

    private String currentimage;

    private ArrayList<Plugin> plugins;

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String theString = IOUtils.toString(inputStream);
        InputType inputType = objectMapper.readValue(theString, InputType.class);
        this.plugindirconf = inputType.getPlugindirconf();
        this.plugins = inputType.getPlugins();
        this.currentimage = inputType.getCurrentimage();
        this.plugins = inputType.getPlugins();
        load();
        {
            OutputType outputType = new OutputType(this.plugindirconf, this.plugins, this.currentimage, this.plugins);
            objectMapper.writeValue(outputStream, outputType);;
        }
    }

    public String name();

    public String description();

    public String process(String image);

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
}