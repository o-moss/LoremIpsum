import java.util.*;

public class Main {
    static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
            "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum " +
            "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia " +
            "deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> minListOfCharacters = new LinkedList<>();
        List<Character> maxListOfCharacters = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = -1;

        for (int i = 0; i < loremIpsum.length(); i++) {
            char ch = loremIpsum.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, (map.get(ch) + 1));
            }
        }

        for (Character key : map.keySet()) {
            int value = map.get(key);
            if (value < min) {
                min = value;
                minListOfCharacters.clear();
                minListOfCharacters.add(key);
            } else if (value > max) {
                max = value;
                maxListOfCharacters.clear();
                maxListOfCharacters.add(key);
            } else if (value == min) {
                minListOfCharacters.add(key);
            } else if (value == max) {
                minListOfCharacters.add(key);
            }
        }
        //System.out.println(map.entrySet());
        System.out.println("Наиболее редко используемые в тексте символы: " + minListOfCharacters + ", каждый встречается " + min + " раз. " +
                "\nНаиболее часто используемые символы в тексте: " + maxListOfCharacters + ", каждый встречается  " + max + " раз.");
    }
}
