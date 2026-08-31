package practice.algorithm;

public class SubStringMaxIncrement {

    public String subStringMaxIncrease(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder current = new StringBuilder();
        StringBuilder max = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (current.isEmpty() || c >= current.charAt(current.length() - 1)) {
                current.append(c);
            } else {

                if (current.length() > max.length()) {
                    max.setLength(0); // Clear chuỗi max cũ
                    max.append(current);
                }
                current.setLength(0);
                current.append(c);
            }
        }
        if (current.length() > max.length()) {
            max.setLength(0);
            max.append(current);
        }

        return max.toString();
    }

    public static void main(String[] args) {
        SubStringMaxIncrement sc = new SubStringMaxIncrement();
        System.out.println(sc.subStringMaxIncrease("abcabcdgabxy"));
        System.out.println(sc.subStringMaxIncrease("abcabcgdgabmnsxy"));
    }
}
