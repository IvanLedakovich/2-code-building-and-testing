package com.ivanledakovich;

import org.junit.Test;

public class MainTest {

    @Test
    public void verifyNoExceptionThrown () {
        Main.main(new String[] {"--file-type", "png", "--file-path", "D:\\test.txt", "D:\\test1.txt", "D:\\test2.txt", "--save-location", "D:\\Games"});
    }

}
