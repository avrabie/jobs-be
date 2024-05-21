package xyz.optimized.jobs.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
    public static void main(String[] args) {
        String[] split = "adrian".split("");
        String[] armata = "nairad".split("");
        ArrayList<String> strs1 = new ArrayList<>();
        ArrayList<String> strs2 = new ArrayList<>();
        strs1.addAll(Arrays.asList(split));
        strs2.addAll(Arrays.asList(armata));
        System.out.println(isAnagram(strs1, strs2));
    }

    public static boolean isAnagram(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        if (list1.size() == 0) {
            return true;
        }
        String s = list1.get(0);
        if (list2.contains(s)) {
            list1.remove(s);
            list2.remove(s);
            return isAnagram(list1, list2);
        } else {
            return false;
        }

    }


}
