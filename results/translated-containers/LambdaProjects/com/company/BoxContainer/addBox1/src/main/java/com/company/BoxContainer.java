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
import java.util.ArrayList;

public class BoxContainer {

    @JsonProperty
    private ArrayList<Box> boxes = new ArrayList<>();

    public int totalVolume() {
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
        String functionName = "com_company_BoxContainer_totalVolume";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.com.company.BoxContainer.totalVolume.InputType inputType = new awsl.com.company.BoxContainer.totalVolume.InputType(this.boxes);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        awsl.com.company.BoxContainer.totalVolume.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
            outputType = objectMapper.readValue(byteBufferToString(lambdaClient.invoke(invokeRequest).getPayload(), Charset.forName("UTF-8")), awsl.com.company.BoxContainer.totalVolume.OutputType.class);
        } catch (Exception e) {
        }
        ;
        this.boxes = outputType.getBoxes();
        return outputType.getTotalVolumeResult();
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public BoxContainer() {
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
