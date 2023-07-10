import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String inputText = "A white cat fell asleep on a table. Another cat envied that spot, for it was the perfect spot.";

        String[] words = inputText.split(" ");

        HashSet<String> uniqWords = new HashSet<>();
        for (String word: words) {
            String normalizedWord = word.toLowerCase().replaceAll("[.,]", "");
            uniqWords.add(normalizedWord);
        }

        HashMap<String, Integer> wordOccuranceCount = new HashMap<>();
        for (String word: words) {
            String normalizedWord = word.replaceAll("[.,]", "");
            Integer oldCount = wordOccuranceCount.getOrDefault(normalizedWord, 0);
            wordOccuranceCount.put(normalizedWord, oldCount + 1);
        }

        System.out.println("All the words in the sentence: " + uniqWords);
        System.out.println("Word counts: " + wordOccuranceCount);
    }
}