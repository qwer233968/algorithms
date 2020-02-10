package map;

import java.io.File;

public class MapTest {

    public static void main(String[] args) {
        HashMapDemo map = new HashMapDemo(133, 0.75f);
        String s = "test";
        map.put(s,"123");
        map.put(s,"456");
        System.out.println("test");
    }
}
