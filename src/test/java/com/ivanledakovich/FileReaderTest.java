package com.ivanledakovich;

import org.junit.Test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void verifyExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> {
            FileReader.readFile("");
        });
    }

    @Test
    public void verifyTheFilesAreReadCorrectly() throws URISyntaxException {
    // given
    String data = "";
    String fileName = "test.txt";
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);
    assert resource != null;
    String path = resource.getPath();

    // when
    data = FileReader.readFile(path);

    // then
    assertEquals(data, "test .txt file");
    }
}
