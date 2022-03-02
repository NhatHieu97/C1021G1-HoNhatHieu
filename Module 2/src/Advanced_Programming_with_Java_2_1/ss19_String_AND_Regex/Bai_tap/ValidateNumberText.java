package Advanced_Programming_with_Java_2_1.ss19_String_AND_Regex.Bai_tap;

public class ValidateNumberText {
    public static final String[] validClassName = new String[] {"(84)-(978489648)"};
    public static final String[] inValidClassName = new String[] {"(a8)-(22222222)"};

    public static void main(String[] args) {
        ValidateNumber validateNumber = new ValidateNumber();
        for (String className: validClassName){
            boolean isValid = validateNumber.validate(className);
            System.out.println("Class Number Is: " + isValid);
        }
        for (String className1: inValidClassName){
            boolean isValid = validateNumber.validate(className1);
            System.out.println("Class Number1 Is: " + isValid);
        }
    }
}
