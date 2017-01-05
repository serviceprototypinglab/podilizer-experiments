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
        menu();
        {
            OutputType outputType = new OutputType(this.plugindirconf, this.plugins, this.currentimage, this.plugins);
            return outputType;
        }
    }

    public String name();

    public String description();

    public String process(String image);

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
}
