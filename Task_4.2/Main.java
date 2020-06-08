public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Mouse tuffiMouse = new Mouse("Tuffi",8,3);
        Cat tomCat = new Cat("Tom", 25, 20);
        Cat butchCat = new Cat("Butch",28,20);
        Dog spikeDog = new Dog("Spike",58,15);
        Dog taykDog = new Dog("Tayk",20,8);
    }
}
class Cat {
    String name;
    int height;
    int tail;

    public Cat(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
class Dog {
    String name;
    int height;
    int tail;

    public Dog(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
class Mouse {
    String name;
    int height;
    int tail;

    public Mouse(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
