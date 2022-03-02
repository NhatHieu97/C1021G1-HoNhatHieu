package Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Thuc_hanh.LopAnimalInterface;

public class Test {
    public static void main(String[] args) {
        Animal[] animal = new Animal[2];
        animal[0] = new Tiger();
        animal[1] = new Chiken();
        for (Animal animals: animal){
            System.out.println(animals.makeSound());

            if(animals instanceof Chiken){
                IEat iEat = (Chiken) animals;
                System.out.println(iEat.howToEat());

            }

        }
        

        Fruit[] fruit = new Fruit[2];
        fruit[0] = new Orange();
        fruit[1] = new Apple();
        for (Fruit fruits : fruit){
            System.out.println(fruits.howToEat());
        }




    }
}
