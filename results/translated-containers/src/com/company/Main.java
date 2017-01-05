package com.company;

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

public class Main {

    public static void main(String[] args) {
        Box box0 = new Box();
        Box box1 = new Box(1, 1, 1);
        Box box2 = new Box(2, 3, 4);
        BoxContainer boxContainer = new BoxContainer();
        boxContainer.addBox(box0);
        boxContainer.addBox(box1);
        boxContainer.addBox(box2);
        System.out.println("The total boxes volume is " + boxContainer.totalVolume());
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
