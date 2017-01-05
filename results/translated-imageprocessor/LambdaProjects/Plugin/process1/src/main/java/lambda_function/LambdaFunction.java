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
        String processLambdaResult = process(inputType.getImage());
        {
            OutputType outputType = new OutputType(processLambdaResult);
            return outputType;
        }
    }

    public String name();

    public String description();

    public String process(String image) {
        String ret = image;
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int pos = rand.nextInt(image.length()) + 1;
            ret = ret.substring(0, pos) + "X" + ret.substring(pos);
        }
        return ret;
    }
}
