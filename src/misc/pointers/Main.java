package misc.pointers;

import java.util.HashMap;

/**
 * The concept of pointer is applicable for reference datatype only, not primitive data type.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2;

        map1.put("age", 15);
        map2 = map1;

        HashMap<String, Integer> map3 = new HashMap<>();

        map3.put("age", 27);
        map2 = map3;
//        map1 = map2;

        map2.put("age", 27);

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
    }
}
