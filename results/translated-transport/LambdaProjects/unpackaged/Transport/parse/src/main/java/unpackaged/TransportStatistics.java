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
import java.util.ArrayList;

public class TransportStatistics {

    @JsonProperty
    private ArrayList<String> companies;

    @JsonProperty
    private int entries;

    public TransportStatistics() {
        this.companies = new ArrayList<String>();
    }

    @JsonIgnore
    public boolean setCompanies(ArrayList<String> companies) {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
            awsAccessKeyId = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
            awsSecretAccessKey = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
            regionName = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
        }
        String functionName = "unpackaged_TransportStatistics_setCompanies1";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.unpackaged.TransportStatistics.setCompanies1.InputType inputType = new awsl.unpackaged.TransportStatistics.setCompanies1.InputType(this.companies, this.entries, companies);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.unpackaged.TransportStatistics.setCompanies1.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.unpackaged.TransportStatistics.setCompanies1.OutputType.class);
        } catch(Exception e) {
          
            };
        this.companies = outputType.getCompanies();
        this.entries = outputType.getEntries();
        return outputType.getSetCompaniesResult();
    }

    @JsonIgnore
    public boolean setEntries(int entries) {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
            awsAccessKeyId = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
            awsSecretAccessKey = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
            regionName = Yaml.loadType(new File("/home/dord/SPLab/testsPodilizer/podilizer-experiments/results/translated-transport/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
        }
        String functionName = "unpackaged_TransportStatistics_setEntries1";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.unpackaged.TransportStatistics.setEntries1.InputType inputType = new awsl.unpackaged.TransportStatistics.setEntries1.InputType(this.companies, this.entries, entries);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.unpackaged.TransportStatistics.setEntries1.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.unpackaged.TransportStatistics.setEntries1.OutputType.class);
        } catch(Exception e) {
          
            };
        this.companies = outputType.getCompanies();
        this.entries = outputType.getEntries();
        return outputType.getSetEntriesResult();
    }

    @JsonIgnore
    public ArrayList<String> getCompanies() {
        return this.companies;
    }

    @JsonIgnore
    public int getEntries() {
        return this.entries;
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
