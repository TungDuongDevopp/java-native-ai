package practice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassRoom {
    private static Pattern pattern;
    private static final String regex ="^(C|A|P)\\d{4}(G|H|I|K)$";

    public ClassRoom() {
        pattern = Pattern.compile(regex);
    }

    public boolean validate(String className) {
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }

    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        List<String> classrooms = new ArrayList<>(
                List.of(
                        "C0223G", "A0323K","M0318G", "P0323A","P0323A4"
                )
        );
        for (String classroom : classrooms) {
            boolean isValid = classRoom.validate(classroom);
            System.out.printf("%s %s%n", classroom, isValid);
        }
    }
}
