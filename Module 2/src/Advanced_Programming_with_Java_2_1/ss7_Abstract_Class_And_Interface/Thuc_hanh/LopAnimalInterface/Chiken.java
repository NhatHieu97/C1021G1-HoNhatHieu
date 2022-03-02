package Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Thuc_hanh.LopAnimalInterface;

public class Chiken extends Animal implements IEat {
    @Override
    public String makeSound() {
        return "Chiken: kuctac kuctac!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
