package com.ivanledakovich;

public class Main {

    public static void main(String[] args) {
        Parameters parameters = ArgumentsParser.parseArguments(args);
        for (int i = 0; i < parameters.getAllTextFilePaths().size(); i++) {
            Thread.startANewThread(parameters.getImageFileType(), parameters.getImageSaveLocation(), parameters.getSingleTextFilePath(i));
        }
    }
}

