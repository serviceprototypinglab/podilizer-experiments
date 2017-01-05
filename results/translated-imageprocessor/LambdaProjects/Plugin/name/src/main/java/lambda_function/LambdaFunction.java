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
import java.util.Random;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class LambdaFunction implements RequestHandler<InputType, OutputType> {

    public OutputType handleRequest(InputType inputType, Context context) {
        String nameLambdaResult = name();
        {
            OutputType outputType = new OutputType(nameLambdaResult);
            return outputType;
        }
    }

    public String description();

    public String process(String image);

    public String name() {
        return "random";
    }
}
