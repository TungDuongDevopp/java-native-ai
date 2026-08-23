package treemap;

import java.util.HashMap;
import java.util.Map;

public class Bai1 {

    public static Map<String, Integer> countFrequentWords(String words) {
        words = words.toLowerCase();
       String[] wordArray = words.split(" ");
       Map<String, Integer> map = new HashMap<>();
       for (String word : wordArray) {
           map.put(word, map.getOrDefault(word, 0) + 1);
       }
       return map;
    }

    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";

       Map<String,Integer> pre =  Bai1.countFrequentWords(s);
       for(Map.Entry<String, Integer> entry : pre.entrySet()) {
           System.out.println(entry.getKey() + " " + entry.getValue());
       }
    }
}
