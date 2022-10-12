package com.personal.mq.mq;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class TestStreams {

    public static void main(String args[]) throws IOException {
        File initialFile = new File("./car.pdf");
        InputStream targetStream = new FileInputStream(initialFile);


        System.out.println("Stream is created");
        File finalFile = new File("./car1.pdf");
        FileUtils.copyInputStreamToFile(targetStream,finalFile);
        System.out.println("File got created");



    }
}
