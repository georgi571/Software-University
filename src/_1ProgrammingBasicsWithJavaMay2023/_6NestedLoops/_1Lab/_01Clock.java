package _1ProgrammingBasicsWithJavaMay2023._6NestedLoops._1Lab;

public class _01Clock {
    public static void main(String[] args) {
        for (int h = 0; h <= 23 ; h++) {
            for (int m = 0; m <=59 ; m++) {
                System.out.printf("%d:%d%n",h, m);
            }
        }
    }
}
