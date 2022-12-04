package Hashing;
import java.util.*;

public class TreeMap2 {

    // Distinct Element
    public static void distinctElemnt(int num[]) {
        HashSet<Integer> n = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            n.add(num[i]);
        }
        System.out.println(n.size());
    }

    // Union & Intersection of array
    public static void printunion(int arr1[], int arr2[]) { // O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            set.add(arr2[j]);
        }
        System.out.println(set);
        System.out.println(set.size());
    }

    public static void printIntersection(int arr1[], int arr2[]) { // O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        int count = 0;
        for (int j = 0; j < arr2.length; j++) {
            if (set.contains(arr2[j])) {
                count++;
                System.out.print(arr2[j]);
                set.remove(arr2[j]);
            }
        }
        System.out.println();

        System.out.println("Intersection is " + count);
    }

    // Find Itinerary / Journey from tickets

    public static String getStart(HashMap<String, String> tickets) { // O(n)
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        // distinctElemnt(num);

        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        // printunion(arr1, arr2);
        // printIntersection(arr1, arr2);

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print(" --> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
