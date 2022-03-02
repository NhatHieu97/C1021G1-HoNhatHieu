package ss23_Behavioral_Design_Pattern.Thuc_hanh.TemplateMethod;

public abstract class Meal {
    public abstract void prepareIngredients();
    public abstract void cook();
    public void eat(){
        System.out.println("mlem mlem,that's good");
    }
    public abstract void cleanUp();
    public final void doMeal(){
        prepareIngredients();
        cook();
        eat();
        cleanUp();
    }
}
