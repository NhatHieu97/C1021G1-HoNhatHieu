package Advanced_Programming_with_Java_2_1.ss19_String_AND_Regex.Bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {


    public static final String REGEX = "^[C,A,P][0-9]{4}[G,H,I,K,L,M]";

    public boolean validate(String regrex){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(regrex);
        return matcher.matches();
    }

}
