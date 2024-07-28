package xyz.optimized.jobs.temp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList();
        Optional<String> any = list.stream().findAny();
        System.out.println(any);
    }
}
