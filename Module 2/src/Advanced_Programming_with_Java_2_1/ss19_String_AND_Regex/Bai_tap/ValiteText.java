package Advanced_Programming_with_Java_2_1.ss19_String_AND_Regex.Bai_tap;

public class ValiteText {
    private static Validate validate;

    public static final String[] validClassName = new String[] {"C0318G","C10G121"};
    public static final String[] inValidClassName = new String[] {"M0318G","P0323A"};

    public static void main(String[] args) {
        validate = new Validate();
        for(String className: validClassName){
            boolean isValid = validate.validate(className);
            System.out.println("Class Name Is: " + isValid);
        }
        for(String className1: validClassName){
            boolean notValid = validate.validate(className1);
            System.out.println("Class Name1 Is: " + notValid);
        }
    }

}
