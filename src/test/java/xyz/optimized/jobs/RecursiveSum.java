package xyz.optimized.jobs;

import org.junit.jupiter.api.Test;

public class RecursiveSum {
    @Test
    public void contextLoads() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(rsum(0));
    }

    public int rsum(int n) {
        if (n >= 10) {
            return 0;
        }
        return n + rsum(n + 1);
    }
}
