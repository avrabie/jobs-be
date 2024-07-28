package xyz.optimized.jobs.temp;

public class EscapingChars {

    public static void main(String[] args) {
        String s = "Hello, \"World\"!";
        System.out.println(s);
    }

    //write a method that takes a string and returns an integer that finds all the characters escaped by #

    public static int countEscapedChars(String s) {
        int count = 0;
        int start = s.indexOf("#");
        int end = start;
        for (int i = start+1; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                end = i;
            }
        }
        if(start == end) {
            return 0;
        }

        for (int i = start; i < s.length()-1; i++) {
            if ((s.charAt(i) == '!') && Character.isAlphabetic(s.charAt(i-1))) {
                count++;
            }
        }
        return count;
    }

    public static int count2(String expression) {
        return countRec(expression, 0, expression.length());
    }

    private static int countRec(String expression, int start, int end) {
        int begin = expression.indexOf(35, start);
        if (begin == -1 || begin >= end) {
            return 0;
        }

        for (int j = begin; j < end; j++) {
            if(Character.isAlphabetic(expression.charAt(j-1)) && expression.charAt(j) == 33) {
                int closing = expression.indexOf(35, j);
                if( closing > -1) {
                    return 1 + countRec(expression, closing, end);
                }
                return 0;
            }
        }

        return begin;
    }
}
