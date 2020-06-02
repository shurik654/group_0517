import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter TC: ");
        float a = scanner.nextInt();
        float b = 9;
        float c = 5;
        float e = 32;
                System.out.println("TF = " +((b / c) * a + e));
    }
}
