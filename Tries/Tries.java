package Tries;
public class Tries {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // End of word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Search key
    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i))
                    && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String words[] = { "the", "a", "there", "thier", "any", "thee" };
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }

        // System.out.println(search("an"));
        // System.out.println(search("any"));

        String words1[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < words1.length; i++) {
            insert(words1[i]);
        }
        String key = "ilikesamg";
        System.out.println(wordBreak(key));
    }
}