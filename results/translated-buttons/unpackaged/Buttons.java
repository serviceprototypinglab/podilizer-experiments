package unpackaged;

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
import java.awt.*;
import java.awt.event.*;

public class Buttons extends Frame implements ActionListener {

    public Buttons() {
    }

    public void showwindow() {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
            awsAccessKeyId = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-buttons/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
            awsSecretAccessKey = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-buttons/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
            regionName = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-buttons/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
        }
        String functionName = "unpackaged_Buttons_showwindow";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.unpackaged.Buttons.showwindow.InputType inputType = new awsl.unpackaged.Buttons.showwindow.InputType();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.unpackaged.Buttons.showwindow.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.unpackaged.Buttons.showwindow.OutputType.class);
        } catch(Exception e) {
          
            };
    }

    public void actionPerformed(ActionEvent event) {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
            awsAccessKeyId = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-buttons/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
            awsSecretAccessKey = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-buttons/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
            regionName = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-buttons/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
        }
        String functionName = "unpackaged_Buttons_actionPerformed1";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.unpackaged.Buttons.actionPerformed1.InputType inputType = new awsl.unpackaged.Buttons.actionPerformed1.InputType(event);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.unpackaged.Buttons.actionPerformed1.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.unpackaged.Buttons.actionPerformed1.OutputType.class);
        } catch(Exception e) {
          
            };
    }

    public static void main(String args[]) {
        Buttons b = new Buttons();
        b.showwindow();
    }

    public static String byteBufferToString(ByteBuffer buffer, Charset charset) {
        byte[] bytes;
        if (buffer.hasArray()) {
            bytes = buffer.array();
        } else {
            bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
        }
        return new String(bytes, charset);
    }
}
