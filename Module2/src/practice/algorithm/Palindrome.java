package practice.algorithm;

public class Palindrome {

    public boolean isPalindrome(String str) {
    if(str.isBlank()) return false;
    str = str.toLowerCase().trim();

    int left = 0;
    int right = str.length() - 1;
    while(left < right) {
        char leftChar = str.charAt(left);
        char rightChar = str.charAt(right);
        if(leftChar != rightChar) {
            return false;
        }
        left++;
        right--;
    }
    return true;
    }

    public static void main(String[] args) {
        String str = "Able was I ere I saw Elbao";
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(str));
    }
}
