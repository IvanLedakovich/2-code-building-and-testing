package com.ivanledakovich;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class ArgumentsParserTest {

    @Test
    public void verifyArgumentsParseCorrectly () {
        Parameters expectedResult = new Parameters();
        expectedResult.setImageFileType("png");
        expectedResult.setImageSaveLocation("D:\\Games");
        expectedResult.setTextFilePaths(Arrays.asList("D:\\test.txt", "D:\\test1.txt", "D:\\test2.txt"));
        assertEquals(expectedResult.getImageFileType(), ArgumentsParser.parseArguments(new String[] {"--file-type", "png", "--file-path", "D:\\test.txt", "D:\\test1.txt", "D:\\test2.txt", "--save-location", "D:\\Games"}).getImageFileType());
        assertEquals(expectedResult.getImageSaveLocation(), ArgumentsParser.parseArguments(new String[] {"--file-type", "png", "--file-path", "D:\\test.txt", "D:\\test1.txt", "D:\\test2.txt", "--save-location", "D:\\Games"}).getImageSaveLocation());
        assertEquals(expectedResult.getAllTextFilePaths(), ArgumentsParser.parseArguments(new String[] {"--file-type", "png", "--file-path", "D:\\test.txt", "D:\\test1.txt", "D:\\test2.txt", "--save-location", "D:\\Games"}).getAllTextFilePaths());
    }

}
