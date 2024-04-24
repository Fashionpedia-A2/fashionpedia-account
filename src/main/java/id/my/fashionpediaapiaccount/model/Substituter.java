package id.my.fashionpediaapiaccount.model;

import java.util.HashMap;
import java.util.Map;

public class Substituter implements ITransformer {
    private final Map<Character, Character> mapping = new HashMap<>();

    public Substituter(int seed) {
        initMapping(seed);
    }

    private void initMapping(int seed) {
        if (this.mapping.size() != 0) return;

        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            this.mapping.put(chars[i], chars[(i + seed) % 52]);
        }
    }

    public String transform(String str) {
        String newStr = "";
        for (Character c : str.toCharArray()) {
            Character mappedChar = mapping.get(c);
            newStr += mappedChar;
        }
        return newStr;
    }

}
