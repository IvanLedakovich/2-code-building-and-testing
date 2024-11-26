package com.ivanledakovich;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void verifyNoExceptionThrown () {
        assertThrows(RuntimeException.class, () -> {
            FileReader.readFile("");
        });
    }

}
