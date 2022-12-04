package Hashing;
import java.util.*;

public class LinkedHashMap1 {
    // Basics
    public static void operations() {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("Veg", 300);
        lhm.put("Taxi", 100);
        lhm.put("Gas", 330);
        lhm.put("Rent", 2000);
        lhm.put("Eat", 100);

        System.out.println(lhm);
        System.out.println(lhm.get("Gas"));
        System.out.println(lhm.containsKey("Veg"));
        lhm.remove("Eat");
        System.out.println(lhm);
        System.out.println(lhm.isEmpty());
    }

    // #1 Majority Element     //O(n)
    public static void majorityElm(int arr[], HashMap<Integer, Integer> map) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }

    // #2 Valid Anagram - O(n)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        // operations();

        // HashMap<Integer, Integer> map = new HashMap<>();
        // int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // majorityElm(arr, map);

        String s = "race", t = "ctare";
        System.out.println(isAnagram(s, t));
    }
}
