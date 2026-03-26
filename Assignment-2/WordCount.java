//Problem Statement:
//5 Count word occurrences from a file using File Handling APIs
import java.io.*;
import java.util.*;

public class WordCount {

    public static void main(String[] args) {

        HashMap<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                String words[] = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        if (wordCount.containsKey(word)) {
                            wordCount.put(word, wordCount.get(word) + 1);
                        } else {
                            wordCount.put(word, 1);
                        }
                    }
                }
            }

            System.out.println("Word Occurrences:");

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File 'sample.txt' not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}