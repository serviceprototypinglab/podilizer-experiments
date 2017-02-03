package com.company;

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

public class Box {

    @JsonProperty
    private int h;

    @JsonProperty
    private int w;

    @JsonProperty
    private int l;

    @JsonProperty
    private String overview;

    public Box() {
        this.h = 0;
        this.w = 0;
        this.l = 0;
        this.overview = "This is 'zero' box.";
    }

    public Box(int h, int w, int l) {
        this.h = h;
        this.w = w;
        this.l = l;
        this.overview = "This is " + h + "x" + w + "x" + l + " box.";
    }

    public int volume() {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
                awsAccessKeyId = Yaml.loadType(new File("podilizer-experiments/results/translated-containers/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
                awsSecretAccessKey = Yaml.loadType(new File("podilizer-experiments/results/translated-containers/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
                regionName = Yaml.loadType(new File("podilizer-experiments/results/translated-containers/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ;
        }
        String functionName = "com_company_Box_volume";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.com.company.Box.volume.InputType inputType = new awsl.com.company.Box.volume.InputType(this.h, this.w, this.l, this.overview);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        awsl.com.company.Box.volume.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
            outputType = objectMapper.readValue(byteBufferToString(lambdaClient.invoke(invokeRequest).getPayload(), Charset.forName("UTF-8")), awsl.com.company.Box.volume.OutputType.class);
        } catch (Exception e) {
        }
        ;
        this.h = outputType.getH();
        this.w = outputType.getW();
        this.l = outputType.getL();
        this.overview = outputType.getOverview();
        return outputType.getVolumeResult();
    }

    public void oneLineMethod() {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
                awsAccessKeyId = Yaml.loadType(new File("podilizer-experiments/results/translated-containers/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
                awsSecretAccessKey = Yaml.loadType(new File("podilizer-experiments/results/translated-containers/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
                regionName = Yaml.loadType(new File("podilizer-experiments/results/translated-containers/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ;
        }
        String functionName = "com_company_Box_oneLineMethod";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.com.company.Box.oneLineMethod.InputType inputType = new awsl.com.company.Box.oneLineMethod.InputType(this.h, this.w, this.l, this.overview);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        awsl.com.company.Box.oneLineMethod.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
            outputType = objectMapper.readValue(byteBufferToString(lambdaClient.invoke(invokeRequest).getPayload(), Charset.forName("UTF-8")), awsl.com.company.Box.oneLineMethod.OutputType.class);
        } catch (Exception e) {
        }
        ;
        this.h = outputType.getH();
        this.w = outputType.getW();
        this.l = outputType.getL();
        this.overview = outputType.getOverview();
    }

    @JsonIgnore
    public int getH() {
        return h;
    }

    @JsonIgnore
    public int getW() {
        return w;
    }

    @JsonIgnore
    public int getL() {
        return l;
    }

    @JsonIgnore
    public String getOverview() {
        return overview;
    }

    @JsonIgnore
    public void setH(int h) {
        this.h = h;
    }

    @JsonIgnore
    public void setW(int w) {
        this.w = w;
    }

    @JsonIgnore
    public void setL(int l) {
        this.l = l;
    }

    @JsonIgnore
    public void setOverview(String overview) {
        this.overview = overview;
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
