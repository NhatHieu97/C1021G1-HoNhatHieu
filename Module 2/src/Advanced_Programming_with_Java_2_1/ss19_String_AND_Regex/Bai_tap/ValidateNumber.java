package Advanced_Programming_with_Java_2_1.ss19_String_AND_Regex.Bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumber {
    public static final String REGEX = "^\\(84\\)\\-\\([0-9]{9}\\)$";
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
