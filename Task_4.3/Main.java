public class Main{
    public static void main(String[] args) {
        Horse horse = new Horse("Гром",4,45);
        Pegasus pegasus = new Pegasus("Спирит",5,70);
        horse.run();
        pegasus.fly();
    }
}
abstract class Animal{
    String nickname;
    int age;
    int speed;

    public Animal(String nickname, int age, int speed) {
        this.nickname = nickname;
        this.age = age;
        this.speed = speed;}
            }

class Horse extends Animal{
    public Horse(String nickname, int age, int speed) {
        super(nickname, age, speed);
    }
    public void run(){
        System.out.println("Игого, я поскакал");
    }
}
class Pegasus extends Animal {
    public Pegasus(String nickname, int age, int speed) {
        super(nickname, age, speed);
    }

    public void fly() {
        System.out.println("Игого, я полетел");
    }
}
