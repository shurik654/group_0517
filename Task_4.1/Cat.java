public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat(int age, int weight, int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;}

    public boolean fight(Cat anotherCat) {
        int a=0;
        int b=0;
        if (this.age>anotherCat.age) b++;
        else a++;
        if (this.weight>anotherCat.weight) b++;
        else a++;
        if (this.strength>anotherCat.strength) b++;
        else a++;
        if (a>b) return(true);
        else return(false);
    }

    public static void main(String[] args) {

    }
}
