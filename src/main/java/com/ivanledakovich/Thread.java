package com.ivanledakovich;

import java.awt.image.BufferedImage;
import java.util.List;

public class Thread extends java.lang.Thread {

    private String imageFileType;
    private String imageSaveLocation;
    private String textFilePath;

    public Thread(String imageFileType, String imageSaveLocation, String textFilePath) {
        this.imageFileType = imageFileType;
        this.imageSaveLocation = imageSaveLocation;
        this.textFilePath = textFilePath;
    }

    @Override
    public void run() {
        String data = FileReader.readFile(textFilePath);
        BufferedImage image = ImageCreator.createImage(data);
        ImageWriter.writeImage(image, imageFileType, imageSaveLocation, textFilePath);
    }

    public static void startANewThread(String imageFileType, String imageSaveLocation, String textFilePath) {

            Thread thread = new Thread(imageFileType, imageSaveLocation, textFilePath);
            thread.start();
    }
}