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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.net.URL;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.io.*;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.util.IOUtils;
import com.fasterxml.jackson.databind.*;
import unpackaged.*;

public class LambdaFunction implements RequestStreamHandler {

    private TransportStatistics stats;

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String theString = IOUtils.toString(inputStream);
        InputType inputType = objectMapper.readValue(theString, InputType.class);
        this.stats = inputType.getStats();
        parse();
        {
            OutputType outputType = new OutputType(this.stats);
            objectMapper.writeValue(outputStream, outputType);;
        }
    }

    private void prepare(String fileurl, String filename) throws Exception {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
            awsAccessKeyId = Yaml.loadType(new File("/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
            awsSecretAccessKey = Yaml.loadType(new File("/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
            regionName = Yaml.loadType(new File("/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
        }
        String functionName = "unpackaged_Transport_prepare2";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.unpackaged.Transport.prepare2.InputType inputType = new awsl.unpackaged.Transport.prepare2.InputType(this.stats, fileurl, filename);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.unpackaged.Transport.prepare2.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.unpackaged.Transport.prepare2.OutputType.class);
        } catch(Exception e) {
          
            };
        this.stats = outputType.getStats();
        if(outputType.getLambdaException() != null){
           if (outputType.getLambdaException().getClass().getSimpleName().equals("Exception")){
               throw (Exception)outputType.getLambdaException();
           }
                    };
    }

    public static final void main(String[] args) {
        Transport t = new Transport();
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

    private void parse() {
        String filename = "2016-12-30istdaten.csv";
        String fileurl = //opentransportdata.swiss/dataset/0edc74a3-ad4d-486e-8657-f8f3b34a0979/resource/3724e714-5480-46e2-be49-4892078b71b5/download/2016-12-30istdaten.csv";
        "https://opentransportdata.swiss/dataset/0edc74a3-ad4d-486e-8657-f8f3b34a0979/resource/3724e714-5480-46e2-be49-4892078b71b5/download/2016-12-30istdaten.csv";
        //opentransportdata.swiss/dataset/0edc74a3-ad4d-486e-8657-f8f3b34a0979/resource/3724e714-5480-46e2-be49-4892078b71b5/download/2016-12-30istdaten.csv";
        System.out.println("Preparing data...");
        try {
            this.prepare(fileurl, filename);
        } catch (Exception e) {
            System.err.println("Could not download'" + fileurl + "': " + e.toString());
        }
        System.out.println("Parsing data...");
        try {
            this.stats = new TransportAnalysis().read(filename);
        } catch (Exception e) {
            System.err.println("Could not open '" + filename + "': " + e.toString());
        }
    }
}
