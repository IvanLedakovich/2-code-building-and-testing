package com.ivanledakovich;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImageWriter {

    protected static final Logger logger = LogManager.getLogger();

    public static void writeImage(BufferedImage image, String imageFileType, String imageSaveLocation, String textFilePath){
        try {
            ImageIO.write(image, imageFileType, new File(imageSaveLocation + "\\" + textFilePath.substring(textFilePath.lastIndexOf("\\")+1) + "." + imageFileType));
            throw new IOException("Artificial exception");
        } catch (IOException e) {
            logger.info("Hello World!");
        }
    }
}
