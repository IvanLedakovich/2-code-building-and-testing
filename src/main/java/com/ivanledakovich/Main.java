package com.ivanledakovich;

public class Main {

    public static void main(String[] args) {
        Help.help(args[0]);
        ArgumentsParser.parseArguments(args);
    }
}

