package ss23_Behavioral_Design_Pattern.Thuc_hanh.TemplateMethod;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        Meal meal = new HamburgerMeal();
        meal.doMeal();

        System.out.println();

        Meal meal1 = new TacoMeal();
        meal1.doMeal();
    }
}
