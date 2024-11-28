package com.ivanledakovich;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.Rule;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertTrue;

public class MainTest {

    @Rule
    public TemporaryFolder testInputFolder = new TemporaryFolder();

    @Rule
    public TemporaryFolder testOutputFolder = new TemporaryFolder();

    private CountDownLatch lock = new CountDownLatch(1);

    @Test
    public void testInTempFolder() throws IOException, InterruptedException {
        File testInputFile = File.createTempFile("test", ".txt", new File(testInputFolder.getRoot().getPath()));
        FileUtils.write(testInputFile, "test", StandardCharsets.UTF_8);
        Main.main(new String[] {"--file-type", "png", "--file-path", testInputFile.getPath(), "--save-location", testOutputFolder.getRoot().getPath()});
        lock.await(2000, TimeUnit.MILLISECONDS);
        assertTrue(new File(testOutputFolder.getRoot().getPath() + "\\" + testInputFile.getName() + ".png").exists());
    }
}
