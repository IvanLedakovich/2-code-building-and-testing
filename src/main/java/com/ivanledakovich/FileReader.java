package com.ivanledakovich;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * This class contains methods for reading files
 *
 * @author Ivan Ledakovich
 *
 */

public class FileReader {

    /**
     * This method receives file path and returns the file in form of a String
     *
     * @param filePath String, containing path to base file
     * @return file data in form of a String
     *
     * @author Ivan Ledakovich
     *
     */

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
