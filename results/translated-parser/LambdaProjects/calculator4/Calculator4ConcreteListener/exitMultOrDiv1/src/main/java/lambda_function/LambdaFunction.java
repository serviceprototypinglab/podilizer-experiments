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
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import calculator4.Calculator4Parser.AddOrSubtractContext;
import calculator4.Calculator4Parser.ArgContext;
import calculator4.Calculator4Parser.AssignmentContext;
import calculator4.Calculator4Parser.IntegerContext;
import calculator4.Calculator4Parser.MultOrDivContext;
import calculator4.Calculator4Parser.PrintContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.io.*;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.util.IOUtils;
import com.fasterxml.jackson.databind.*;
import calculator4.*;

public class LambdaFunction extends Calculator4BaseListener implements RequestStreamHandler {

    public Stack<Integer> stack = new Stack<Integer>();

    public Map<String, Integer> sym = new HashMap<String, Integer>();

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String theString = IOUtils.toString(inputStream);
        InputType inputType = objectMapper.readValue(theString, InputType.class);
        this.stack = inputType.getStack();
        this.sym = inputType.getSym();
        exitMultOrDiv(inputType.getCtx());
        {
            OutputType outputType = new OutputType(this.stack, this.sym);
            objectMapper.writeValue(outputStream, outputType);;
        }
    }

    public void exitPrint(PrintContext ctx) {
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
        String functionName = "calculator4_Calculator4ConcreteListener_exitPrint1";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.calculator4.Calculator4ConcreteListener.exitPrint1.InputType inputType = new awsl.calculator4.Calculator4ConcreteListener.exitPrint1.InputType(this.stack, this.sym, ctx);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.calculator4.Calculator4ConcreteListener.exitPrint1.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.calculator4.Calculator4ConcreteListener.exitPrint1.OutputType.class);
        } catch(Exception e) {
          
            };
        this.stack = outputType.getStack();
        this.sym = outputType.getSym();
    }

    public void exitAssignment(AssignmentContext ctx) {
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
        String functionName = "calculator4_Calculator4ConcreteListener_exitAssignment1";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.calculator4.Calculator4ConcreteListener.exitAssignment1.InputType inputType = new awsl.calculator4.Calculator4ConcreteListener.exitAssignment1.InputType(this.stack, this.sym, ctx);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.calculator4.Calculator4ConcreteListener.exitAssignment1.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.calculator4.Calculator4ConcreteListener.exitAssignment1.OutputType.class);
        } catch(Exception e) {
          
            };
        this.stack = outputType.getStack();
        this.sym = outputType.getSym();
    }

    public void exitInteger(IntegerContext ctx) {
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
        String functionName = "calculator4_Calculator4ConcreteListener_exitInteger1";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.calculator4.Calculator4ConcreteListener.exitInteger1.InputType inputType = new awsl.calculator4.Calculator4ConcreteListener.exitInteger1.InputType(this.stack, this.sym, ctx);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.calculator4.Calculator4ConcreteListener.exitInteger1.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.calculator4.Calculator4ConcreteListener.exitInteger1.OutputType.class);
        } catch(Exception e) {
          
            };
        this.stack = outputType.getStack();
        this.sym = outputType.getSym();
    }

    public void exitAddOrSubtract(AddOrSubtractContext ctx) {
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
        String functionName = "calculator4_Calculator4ConcreteListener_exitAddOrSubtract1";
        Region region;
        AWSCredentials credentials;
        AWSLambdaClient lambdaClient;
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        lambdaClient = (credentials == null) ? new AWSLambdaClient() : new AWSLambdaClient(credentials);
        region = Region.getRegion(Regions.fromName(regionName));
        lambdaClient.setRegion(region);
        awsl.calculator4.Calculator4ConcreteListener.exitAddOrSubtract1.InputType inputType = new awsl.calculator4.Calculator4ConcreteListener.exitAddOrSubtract1.InputType(this.stack, this.sym, ctx);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(inputType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       awsl.calculator4.Calculator4ConcreteListener.exitAddOrSubtract1.OutputType outputType = null;
        try {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.setFunctionName(functionName);
            invokeRequest.setPayload(json);
        outputType = objectMapper.readValue(byteBufferToString(
                    lambdaClient.invoke(invokeRequest).getPayload(),
                    Charset.forName("UTF-8")),awsl.calculator4.Calculator4ConcreteListener.exitAddOrSubtract1.OutputType.class);
        } catch(Exception e) {
          
            };
        this.stack = outputType.getStack();
        this.sym = outputType.getSym();
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

    public void exitMultOrDiv(MultOrDivContext ctx) {
        Integer op1 = stack.pop();
        Integer op2 = stack.pop();
        if (ctx.getChild(1).getText().equals("/")) {
            stack.push(op2 / op1);
        } else {
            stack.push(op2 * op1);
        }
    }
}
