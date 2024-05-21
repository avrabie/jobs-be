package xyz.optimized.jobs.temp;

public class Generare {
    public static void main(String[] args) {
        generate("", 2);
    }

    public static void generate(String s, int size) {
        if (s.length() == size) {
            System.out.println(s);
            return;
        }
        generate(s + ".", size);
        generate(s + "-", size);
        generate(s + "+", size);

    }
}
