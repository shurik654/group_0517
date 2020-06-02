public class Main {
    public static int min(int a, int b, int c, int d) {
        if (a < b && a < c && a < d)  return a;
        else if (b < a && b < c && b < d) return b;
        else if (c < a && c < b && c < d) return c;
        else return d;

    }

    public static int min(int a, int b) {
        if (a < b)  return a;
        else return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}
