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
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.io.*;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.util.IOUtils;
import com.fasterxml.jackson.databind.*;
import com.company.*;

public class LambdaFunction implements RequestStreamHandler {

    private int h;

    private int w;

    private int l;

    private String overview;

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String theString = IOUtils.toString(inputStream);
        InputType inputType = objectMapper.readValue(theString, InputType.class);
        this.h = inputType.getH();
        this.w = inputType.getW();
        this.l = inputType.getL();
        this.overview = inputType.getOverview();
        int volumeLambdaResult = volume();
        {
            OutputType outputType = new OutputType(this.h, this.w, this.l, this.overview, volumeLambdaResult);
            objectMapper.writeValue(outputStream, outputType);;
        }
    }

    void oneLineMethod() {
        System.out.println("line");
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public int getL() {
        return l;
    }

    public String getOverview() {
        return overview;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setL(int l) {
        this.l = l;
    }

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

    int volume() {
        int volume = h * w * l;
        overview = overview + " P.S.: Someone already counted the volume.";
        System.out.println(volume);
        return volume;
    }
}
