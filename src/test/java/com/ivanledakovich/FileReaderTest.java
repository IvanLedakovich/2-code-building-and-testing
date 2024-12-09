package com.ivanledakovich;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void verifyExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> {
            FileReader.readFile("");
        });
    }

    @Test
    public void verifyTheFilesAreReadCorrectly() {
    // given
    String data = "";

    // when
    data = FileReader.readFile("files/test.txt");

    // then
    assertEquals(data, "test .txt file");
    }
}
