package Hashing;
import java.util.HashMap;
import java.util.Set;

@SuppressWarnings("unchecked")

public class HashMap1 {

    public static void operations(HashMap<String, Integer> hm) { //O(1)
        System.out.println(hm);

        // Get ->(1)
        System.out.println(hm.get("Pizza"));

        // Contains Key - O(1)
        System.out.println(hm.containsKey("Coffee"));
        System.out.println(hm.containsKey("chai "));

        // Remove
        hm.remove("Tea");
        System.out.println(hm);

        // Size
        System.out.println(hm.size());

        // isEmpety
        System.out.println(hm.isEmpty());

        // Clear
        // hm.clear();
        System.out.println(hm.isEmpty());

        // Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " + k + " , Value = " + hm.get(k));
        }
    }

    // Largest Subarray with 0
    public static void subArrW0(int arr[]) {        //(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        System.out.println("Largest subarray with sum is 0 : " + len);
    }

    // Subarray sum equal to K
    public static void subarrWthSumEqK(int arr[], int K) { // O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum - K)) {
                count += map.get(sum - K);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("Largest subarray sum equal to k : " + count);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap();
        // Insert
        hm.put("Tea", 10);
        hm.put("Coffee", 50);
        hm.put("Pizza", 199);
        hm.put("Burgur", 99);

        // operations(hm);

        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        // subArrW0(arr);

        int arr1[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        subarrWthSumEqK(arr1, k);
    }
}