package wizardmath;

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

public class MathWizard {

    public MathWizard() {
    }

    public int sum(int s1, int s2) {
        String awsAccessKeyId = "";
        String awsSecretAccessKey = "";
        String regionName = "";
        if (System.getenv("awsAccessKeyId") != null) {
            awsAccessKeyId = System.getenv("awsAccessKeyId");
            awsSecretAccessKey = System.getenv("awsSecretAccessKey");
            regionName = System.getenv("awsRegion");
        } else {
            try {
                awsAccessKeyId = Yaml.loadType(new File("podilizer-experiments/results/translated-maths/jyaml.yml"), AWSConfEntity.class).getAwsAccessKeyId();
                awsSecretAccessKey = Yaml.loadType(new File("podilizer-experiments/results/translated-maths/jyaml.yml"), AWSConfEntity.class).getAwsSecretAccessKey();
                regionName = Yaml.loadType(new File("podilizer-experiments/results/translated-maths/jyaml.yml"), AWSConfEntity.class).getAwsRegion();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ;
        }
        String functionName = "wizardmath_MathWizard_sum2";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.wizardmath.MathWizard.sum2.InputType inputType = new awsl.wizardmath.MathWizard.sum2.InputType(s1, s2);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        awsl.wizardmath.MathWizard.sum2.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
            outputType = objectMapper.readValue(byteBufferToString(lambdaClient.invoke(invokeRequest).getPayload(), Charset.forName("UTF-8")), awsl.wizardmath.MathWizard.sum2.OutputType.class);
        } catch (Exception e) {
        }
        ;
        return outputType.getSumResult();
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
