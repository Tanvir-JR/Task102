import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountWordFile {
    public static void main(String[] args) {
        String filename = "input.txt"; // Change this to your input file name
        Map<String, Integer> wordCountMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words by whitespace
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Remove non-alphabetic characters and
                                                                           // convert to lowercase
                    if (!word.isEmpty()) { // Skip empty strings
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1); // Update word count
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display word count for each unique word in alphabetical order
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
