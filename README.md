# Java CLI program converting text files into images, packaged with Gradle into a .jar

**The program accepts .txt files as arguments, processes each one in a separate thread,
reads .txt files, printing their contents in the terminal and saving them as images according 
to type and directory provided as arguments. The program uses log4j and commons-io as dependencies 
as well as junit for testing and is packaged into a .jar file using Gradle.**

## How to run the program:
1. Build a .jar file using the following terminal command:
   ```
   gradle build
   ```
2. Add the arguments and then run the .jar file with the following command:
   ```
   java -jar *.jar file* *arguments*
   ```
   The program accepts 3 arguments in any order:
   1. "--file-type" + Image type ("png", "jpg", etc.)
   2. "--save-location" + Image save destination (e.g. "D:\Games")
   3. "--file-path" + Initial .txt files separated by space (e.g. "D:\test.txt" "D:\test1.txt" etc.)

   The full command could look like this:
   ```
   java -jar build\libs\2-code-building-and-testing.jar "--file-type" "png" "--save-location" "D:\\Games" "--file-path" "D:\\test.txt" "D:\\test1.txt" "D:\\test2.txt"
   ```