package kr.hs.dgsw.java.dept23.d0616;

import java.util.*;

public class CollectionStudy {

    public void studyMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("임진왜란", 1592);
        map.put("조선건국", 1392);
        map.put("신대륙발견", 1492);
        map.put("프랑스대혁명", 1789);
        map.put("서로마멸망", 476);

        Integer year = map.get("임진왜란");
        System.out.println(year);

        year = map.get("공자탄생");
        System.out.println(year);

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
    }

    public void studyQueue() {
        Queue<String> queue = new LinkedList<String>();
        List<String> queue2 = new LinkedList<String>();

        queue.add("Korea");
        queue.add("Japan");
        queue.add("China");
        queue.add("USA");

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }

    public void studySet() {
        Set<String> set = new HashSet<String>();

        set.add("Korea");
        set.add("Japan");
        set.add("Korea");
        set.add("China");
        set.add("Korea");
        set.add("USA");

        for (String str : set) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        new CollectionStudy().studySet();
    }
}
