package com.ivanledakovich;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class ArgumentsParserTest {

    @Test
    public void verifyArgumentsParseCorrectly() {
        // given
        Parameters expectedResult = new Parameters();
        expectedResult.setImageFileType("png");
        expectedResult.setImageSaveLocation("D:\\Games");
        expectedResult.setTextFilePaths(Arrays.asList("D:\\test.txt", "D:\\test1.txt", "D:\\test2.txt"));

        // when
        Parameters actualResult = ArgumentsParser.parseArguments(new String[] {"--file-type", "png", "--file-path", "D:\\test.txt", "D:\\test1.txt", "D:\\test2.txt", "--save-location", "D:\\Games"});

        // then
        assertEquals(expectedResult.getImageFileType(), actualResult.getImageFileType());
        assertEquals(expectedResult.getImageSaveLocation(), actualResult.getImageSaveLocation());
        assertEquals(expectedResult.getAllTextFilePaths(), actualResult.getAllTextFilePaths());
    }

}
