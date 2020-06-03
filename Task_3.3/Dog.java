public class Dog {
    private String name;
    private int age;
    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
        public int getAge(){
        return age;
    }
        public static void main(String[] args) {
        Dog rich = new Dog("Ричи",11);
        System.out.println("Имя собаки: "+rich.getName() + ", Возраст собаки: "+rich.getAge()+ " лет");
        System.out.println("Имя собаки: "+rich.name + ", Возраст собаки: "+rich.age + " лет");
    }
}
