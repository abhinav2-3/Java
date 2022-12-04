package Hashing;
import java.util.*;

public class HashSet1 {
    public static void operations() {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(2);
        hs.add(2);
        hs.add(5);
        hs.add(1);
        hs.add(6);
        hs.add(1);

        // System.out.println(hs);
        // hs.remove(6);
        // System.out.println(hs.contains(1));
        // System.out.println(hs);

        // Iteration using inbuilt Iterator

        // Iterator it = hs.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }

        for (Integer n : hs) {
            System.out.println(n);
        }
    }

    public static void linkedHashSet() {
        LinkedHashSet<String> nm = new LinkedHashSet<>();
        nm.add("Delhi");
        nm.add("Pune");
        nm.add("Hydrabad");
        nm.add("Mumbai");
        nm.add("Noida");

        System.out.println(nm);
        // nm.remove("Noida");
        // System.out.println(nm.contains("Noida"));

        //Tree HashSet
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Pune");
        ts.add("Hydrabad");
        ts.add("Mumbai");
        ts.add("Noida");
        System.out.println(ts);
    }

    public static void main(String[] args) {
        // operations();
        linkedHashSet();
    }
}
