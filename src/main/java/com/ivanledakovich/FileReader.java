package com.ivanledakovich;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReader {

    public static String readFile(String filePath){
        String data = "";
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            data = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(data);
        return data;
    }
}
