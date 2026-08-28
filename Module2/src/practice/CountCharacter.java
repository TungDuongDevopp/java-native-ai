package practice;

import java.util.TreeMap;

public class CountCharacter {
    private final TreeMap<Character, Integer> map = new TreeMap<>();

    public TreeMap<Character, Integer> countCharacter(String str) {
        str = str.toLowerCase().trim();
        for(char c : str.toCharArray()) {
            if(Character.isLowerCase(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        CountCharacter countCharacter = new CountCharacter();
        String str = "Hello World By Duong Dep Trai";
        TreeMap<Character, Integer> map = countCharacter.countCharacter(str);
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
