package ss21_Design_Patterns.Thuc_hanh.Factory_Method;

import javax.lang.model.element.AnnotationMirror;

public class AnimalFactory {
    public Animal getAnimal(String type){
        if ("canine".equals(type)){
            return new Dog();
        }else {
            return new Cat();
        }
    }
}
