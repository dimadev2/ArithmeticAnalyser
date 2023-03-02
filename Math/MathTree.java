package Math;

import java.util.Scanner;

public class MathTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        Parser p = new Parser();
        Term t = p.Parse(expression);
        System.out.println(t);
    }
}
