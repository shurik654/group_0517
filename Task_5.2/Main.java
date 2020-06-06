import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader a = new BufferedReader(new FileReader("C:/Users/Компик/Desktop/Обучение/test.txt"));
        String b;
        ArrayList<Integer> numbers = new ArrayList();
        while ((b = a.readLine()) != null) {
            int c = Integer.parseInt(b);
            numbers.add(c);
        }
        a.close();

        ArrayList<Integer> even = new ArrayList();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                even.add(numbers.get(i)); }
        }
        Collections.sort(even);
        for (Integer i : even) {
            System.out.println(i);
        }
    }
}
