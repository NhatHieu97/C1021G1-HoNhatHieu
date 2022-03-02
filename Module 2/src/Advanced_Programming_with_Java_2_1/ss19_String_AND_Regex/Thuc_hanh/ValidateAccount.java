package Advanced_Programming_with_Java_2_1.ss19_String_AND_Regex.Thuc_hanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    public static class AccountExample {
        /*Không chứa các ký tự đặc biệt
          Phải dài hơn 6 ký tự
          Không chứa các ký tự viết hoa
          Cho phép dấu gạch dưới (_)
        */
        private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

        public AccountExample() {
        }


        public boolean validate(String regex) {
            Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
            Matcher matcher = pattern.matcher(regex);
            return matcher.matches();
        }
    }

    public static class AccountExampleTest {

        private static AccountExample accountExample;

        public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
        public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

        public static void main(String args[]) {
            accountExample = new AccountExample();
            for (String account : validAccount) {
                boolean isvalid = accountExample.validate(account);
                System.out.println("Account is " + account +" is valid: "+ isvalid);
            }
            for (String account : invalidAccount) {
                boolean isvalid = accountExample.validate(account);
                System.out.println("Account is " + account +" is valid: "+ isvalid);
            }
        }
    }
}
