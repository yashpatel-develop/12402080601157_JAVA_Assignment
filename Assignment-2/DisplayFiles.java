//Problem Statement:
//6 Display all files of a given directory using File class
import java.io.File;

public class DisplayFiles {

    public static void main(String[] args) {

        // Path of directory
        File directory = new File(".");

        // Get list of files
        File[] files = directory.listFiles();

        System.out.println("Files in the directory:");

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}