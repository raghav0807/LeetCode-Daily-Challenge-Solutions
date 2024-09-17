import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String combined = s1 + " " + s2;
        
        String[] words = combined.split(" ");
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        List<String> uncommonWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }
        
        return uncommonWords.toArray(new String[0]);
    }
}