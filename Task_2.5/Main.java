public class Main {
    public static void main(String[] args) {
        String arr[]=new String[3];
        arr[0]="Мама";
        arr[1]="Мыла";
        arr[2]="Раму";
        for (int a=0;a<3;a++) {
            for (int b = 0; b < 3; b++) {
                for (int c = 0; c < 3; c++) {
                    if (c != b && b!=a && c!=a)
                        System.out.println(arr[a] + arr[b] + arr[c]);
                }
            }
        }
    }
}
