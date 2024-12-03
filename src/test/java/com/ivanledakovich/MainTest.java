package com.ivanledakovich;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.Rule;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Rule
    public TemporaryFolder testInputFolder = new TemporaryFolder();

    @Rule
    public TemporaryFolder testOutputFolder = new TemporaryFolder();

    private CountDownLatch lock = new CountDownLatch(1);


    @Test
    public void testOutputFileExists() throws IOException, InterruptedException {
        // given
        File testInputFile = File.createTempFile("test", ".txt", new File(testInputFolder.getRoot().getPath()));
        FileUtils.write(testInputFile, "test", StandardCharsets.UTF_8);

        // when
        Main.main(new String[] {"--file-type", "png", "--file-path", testInputFile.getPath(), "--save-location", testOutputFolder.getRoot().getPath()});
        lock.await(2000, TimeUnit.MILLISECONDS);

        // then
        assertTrue(new File(testOutputFolder.getRoot().getPath() + "\\" + testInputFile.getName() + ".png").exists());
    }

    @Test
    public void testOutputResultIsCorrect() throws IOException, InterruptedException {
        // given
        File testInputFile = File.createTempFile("test", ".txt", new File(testInputFolder.getRoot().getPath()));
        FileUtils.write(testInputFile, "test", StandardCharsets.UTF_8);

        // when
        Main.main(new String[] {"--file-type", "png", "--file-path", testInputFile.getPath(), "--save-location", testOutputFolder.getRoot().getPath()});
        lock.await(2000, TimeUnit.MILLISECONDS);
        Path outputFilePath = Path.of(testOutputFolder.getRoot().getPath() + "\\" + testInputFile.getName() + ".png");
        Path controlSampleFilePath = Path.of("C:\\Battlefield\\control-sample.png");

        // then
        assertEquals(-1, Files.mismatch(outputFilePath, controlSampleFilePath));
    }
}
