import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final String User = "X";
    public static final String Comp = "O";
    public static final String Empty_field = "*";
    public static int aiLevel = 0;
    public static final int Field_size = 3;
    public static String[][] field = new String[Field_size][Field_size];

    public static void main(String[] args) {
        mainMenu();
    }

    public static void game_with_comp() {
        initField();
        while (true) {
            printField();
            userShot(User,0);
            if (checkWin(User)) {
                printField();
                System.out.println("Игрок выиграл!!!");
                break;
            }
            if (isMapFull()) {
                printField();
                System.out.println("Ничья!!!");
                break;
            }
            aiShot();
            if (checkWin(Comp)) {
                printField();
                System.out.println("Компютер выиграл!!!");
                break;
            }

        }
    }
    public static void game_with_comp2(){



    }

    public static void game_with_comp_random() {
        int count = 0;
        initField();
        while (true) {
            printField();
            userShot(User, 0);
            count++;
            if (checkWin(User)) {
                System.out.println("Игрок выиграл!!!");
                printField();
                break;
            }
            if (isMapFull()) {
                printField();
                System.out.println("Ничья!!!");
                break;
            }
            aiShot_random();
            count++;
            if (checkWin(Comp)) {
                System.out.println("Компютер выиграл!!!");
                printField();
                break;
            }

        }
    }

    public static void mainMenu() {
        System.out.println("Выберите сложность:");
        System.out.println("1. Компютер ходит рандомно");
        System.out.println("2. Компьютер анализирует ходы");
        System.out.println("3. Компютер подсчитывает очки для каждой клетки и совершает ход");
        System.out.println("4. Выйти из игры");

        int i = 0;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        switch (i) {
            case 1: {
                aiLevel = 0;
                game_with_comp_random();
                break;
            }
            case 2: {
                aiLevel = 1;
                game_with_comp();
                break;
            }
            case 3: {
                aiLevel = 2;
                game_with_comp2();
                break;
            }
            case 4: {
                aiLevel = 3;
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Было введено неверное значение!");
            }
        }
    }

    public static void initField() {
        for (int i = 0; i < Field_size; i++) {
            for (int j = 0; j < Field_size; j++) {
                field[i][j] = Empty_field;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i <= Field_size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < Field_size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < Field_size; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void userShot(String sign, int i) {
        int x = -1;
        int y = -1;
        do {
            if (i == 0) {
                System.out.print("Введите значение клетки через пробел: ");
            } else {
                System.out.println("Было введено неверное значение!");
            }
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }
        while (isCellBusy(x, y));
        field[x][y] = sign;
    }

    public static void aiShot() {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;

        if (aiLevel == 2) {
            for (int i = 0; i < Field_size; i++) {
                for (int j = 0; j < Field_size; j++) {
                    if (!isCellBusy(i, j)) {
                        field[i][j] = Comp;
                        if (checkWin(Comp)) {
                            x = i;
                            y = j;
                            ai_win = true;
                        }
                        field[i][j] = Empty_field;
                    }
                }
            }
        }

        if (aiLevel > 0) {
            if (!ai_win) {
                for (int i = 0; i < Field_size; i++) {
                    for (int j = 0; j < Field_size; j++) {
                        if (!isCellBusy(i, j)) {
                            field[i][j] = User;
                            if (checkWin(User)) {
                                x = i;
                                y = j;
                                user_win = true;
                            }
                            field[i][j] = Empty_field;
                        }
                    }
                }
            }
        }
        if (!ai_win && !user_win) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(Field_size);
                y = rnd.nextInt(Field_size);
            }
            while (isCellBusy(x, y));
        }
        field[x][y] = Comp;
        System.out.println("Компютер выбрал: " + (x + 1) + " " + (y + 1));
    }

    public static void aiShot_random() {
        int x = -1;
        int y = -1;
        do {
            Random rnd = new Random();
            x = rnd.nextInt(Field_size);
            y = rnd.nextInt(Field_size);
        }
        while (isCellBusy(x, y));

        field[x][y] = Comp;
        System.out.println("Компютер выбрал: " + (x + 1) + " " + (y + 1));
    }

    public static boolean isCellBusy(int x, int y) {
        if (x < 0 || y < 0 || x > Field_size - 1 || y > Field_size - 1) {
            return false;
        }
        return field[x][y] != Empty_field;
    }

    public static boolean checkLine(int start_x, int start_y, int dx, int dy, String sign) {
        for (int i = 0; i < Field_size; i++) {
            if (field[start_x + i * dx][start_y + i * dy] != sign)
                return false;
        }
        return true;
    }

    public static boolean checkWin(String sign) {
        for (int i = 0; i < Field_size; i++) {
            if (checkLine(i, 0, 0, 1, sign)) return true;
            if (checkLine(0, i, 1, 0, sign)) return true;
        }
        if (checkLine(0, 0, 1, 1, sign)) return true;
        if (checkLine(0, Field_size - 1, 1, -1, sign)) return true;
        return false;
    }

    public static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < Field_size; i++) {
            for (int j = 0; j < Field_size; j++) {
                if (field[i][j] == Empty_field)
                    result = false;
            }
        }
        return result;
    }
}
