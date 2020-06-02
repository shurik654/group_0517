        /*Google предлогает такое решение*/
        
        public class Main {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
            number = 546;
            int sum = 0;
            int currentDigit;
            currentDigit = number % 10;
            sum = sum + currentDigit;
            number = number / 10;
            currentDigit = number % 10;
            sum = sum + currentDigit;
            number = number / 10;
            currentDigit = number % 10;
            sum = sum + currentDigit;
            return sum;

    }
}
