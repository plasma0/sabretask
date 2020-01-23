import java.util.*;

// minimum jdk required: 1.8+
// 
// How to run:
// 1. compile: javac ZadanieSabre.java
// 2. run:     java  ZadanieSabre
// 3. Have fun!
//
// Remember to have BOTH java and javac in PATH

public class ZadanieSabre {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        System.out.println("Podaj zdanie");
        String text = cin.nextLine();
        String[] words = text.split("[, ]{1,2}");
        Set<String> uniqueWords = new HashSet(Arrays.asList(words));
        Map<Character, List<String>> wordsAssignedToLetters = new HashMap<>();
        for (char c = 'a'; c < 'z'; ++c) {
            wordsAssignedToLetters.put(Character.toUpperCase(c), new LinkedList<>());
            for (String word : uniqueWords) {
                if (word.contains(Character.toString(c)) || word.contains(Character.toString(Character.toUpperCase(c))))
                    wordsAssignedToLetters.get(Character.toUpperCase(c)).add(word);
            }
        }
        wordsAssignedToLetters.forEach((key, value) -> {
            if (value.size() != 0) {
                System.out.print(key);
                System.out.print(": ");
                value.forEach(v -> System.out.print(v + " "));
                System.out.println();
            }
        });
    }
}
