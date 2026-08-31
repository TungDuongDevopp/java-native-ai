package practice.inspection;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabelExtractor {
    // Dùng non-greedy (.*?) để khớp chính xác từng nhãn
    private static final Pattern pattern = Pattern.compile("\\[LABEL:(.*?)]");

    public static void extractLabels(List<String> datasetLines) {
        for (String line : datasetLines) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println("Nhãn trích xuất được: " + matcher.group(1));
            }
        }
    }

    public static void main(String[] args) {
        List<String> data = Arrays.asList(
                "[LABEL:cat] img_01.jpg [LABEL:dog] img_02.jpg",
                "[LABEL:bird] img_03.jpg",
                "[LABEL:car] img_04.jpg [LABEL:bus] img_05.jpg [LABEL:train] img_06.jpg"
        );
        System.out.println("--- Bắt đầu trích xuất ---");
        extractLabels(data);
    }
}

