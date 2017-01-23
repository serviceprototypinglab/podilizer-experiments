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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TransportTest {

    @Test
    public void testStatistics() {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
                awsAccessKeyId = Yaml.loadType(new File("podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
                awsSecretAccessKey = Yaml.loadType(new File("podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
                regionName = Yaml.loadType(new File("podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ;
        }
        String functionName = "unpackaged_TransportTest_testStatistics";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.unpackaged.TransportTest.testStatistics.InputType inputType = new awsl.unpackaged.TransportTest.testStatistics.InputType();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        awsl.unpackaged.TransportTest.testStatistics.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
            outputType = objectMapper.readValue(byteBufferToString(lambdaClient.invoke(invokeRequest).getPayload(), Charset.forName("UTF-8")), awsl.unpackaged.TransportTest.testStatistics.OutputType.class);
        } catch (Exception e) {
        }
        ;
    }

    @Test
    public void testAnalysis() {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
                awsAccessKeyId = Yaml.loadType(new File("podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
                awsSecretAccessKey = Yaml.loadType(new File("podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
                regionName = Yaml.loadType(new File("podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ;
        }
        String functionName = "unpackaged_TransportTest_testAnalysis";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.unpackaged.TransportTest.testAnalysis.InputType inputType = new awsl.unpackaged.TransportTest.testAnalysis.InputType();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        awsl.unpackaged.TransportTest.testAnalysis.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
            outputType = objectMapper.readValue(byteBufferToString(lambdaClient.invoke(invokeRequest).getPayload(), Charset.forName("UTF-8")), awsl.unpackaged.TransportTest.testAnalysis.OutputType.class);
        } catch (Exception e) {
        }
        ;
    }

    public static final void main(String[] args) {
        Result result = JUnitCore.runClasses(TransportTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println("FAIL: " + failure.toString());
        }
        System.out.println("SUCCESS: " + result.wasSuccessful());
    }

    public TransportTest() {
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
