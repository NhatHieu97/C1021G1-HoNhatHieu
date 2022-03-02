package Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Thuc_hanh.LopAnimalInterface;

import Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Thuc_hanh.LopAnimalInterface.Animal;

public class Tiger extends Animal {
    @Override
    public String makeSound() {
        return "Tiger: roarr!";
    }
}
