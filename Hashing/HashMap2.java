package Hashing;
import java.util.*;
import java.util.LinkedList;

@SuppressWarnings("unchecked")

public class HashMap2 {
    static class HashMap<k, v> {
        private class Node {
            k key;
            v value;

            public Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> bucket[];

        public HashMap() {
            this.N = 4;
            this.bucket = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        private int hashFunction(k key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(k key, int bi) {
            LinkedList<Node> ll = bucket[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }
            // Node -> add in buckets;
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(k key, v value) { // O(lamda) == O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bucket[bi].get(di);
                node.value = value;
            } else {
                bucket[bi].add(new Node(key, value));
                n++;
            }
            double lamda = (double) n / N;
            if (lamda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(k key) { // O(lamda) == O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public v remove(k key) { // O(lamda) == O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;

            } else {
                return null;
            }
        }

        public v get(k key) { // O(lamda) == O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bucket[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<k> keySet() {
            ArrayList<k> keys = new ArrayList<>();
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
                return keys;
            }
            return null;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 120);
        // hm.put("Nepal", 20);
        // hm.put("US", 50);
        ArrayList<String> keys = hm.keySet();

        for (String keyd : keys) {
            System.out.println(keyd);
        }
        // System.out.println(hm.get("India"));
        // System.out.println(hm.containsKey("Nepal"));
        // System.out.println(hm.isEmpty() );    
    }
}
