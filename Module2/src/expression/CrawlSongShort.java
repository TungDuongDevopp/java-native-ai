package expression;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongShort {
    public static void main(String[] args) {
        try {
            Path file = Path.of("D:\\java-native-ai\\Module2\\src\\expression\\song.html");
            String content = Files.readString(file, StandardCharsets.UTF_8);

            content = content.replaceAll("\\R+", "");

            Pattern pattern = Pattern.compile("name_song\"[^>]*>(.*?)</a>");
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

