package bagu;

class Animal{
    int x=1;
    public Animal(){
        System.out.print("animal");
    }
}
class Dog extends Animal{
    int x=2;
    public Dog(){
        System.out.print("dog");
    }
}
public class TestExtends {

    public static void main(String[] args) {
        Dog animal=new Dog();
        System.out.print(animal.x);

    }
}
