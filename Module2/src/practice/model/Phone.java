package practice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    private static Pattern pattern;
    private static final String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public Phone() {
        pattern = Pattern.compile(regex);
    }

    public boolean validate(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        List<String> phones = new ArrayList<>(
                List.of(
                        "(84)-(0978489648)", "(a8)-(22222222)","(84)-(22b22222)","(84)-(9978489648)",
                        "(84)-(0978489648)"
                )
        );
        for(String phoneNum : phones){
          boolean isValid =  phone.validate(phoneNum);
          System.out.println(phoneNum + " " + isValid);
        }
    }
}
