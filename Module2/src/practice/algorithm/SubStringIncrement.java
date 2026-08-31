package practice.algorithm;

public class SubStringIncrement {

    public String subStringIncre(String s){
        StringBuilder sb = new StringBuilder();
        if(s==null||s.isBlank()){
            return "";
        }
        s = s.trim();
        sb.append(s.charAt(0));
        for(int i=1;i<s.length()-1;i++){
          char c = s.charAt(i);
          if(Character.isSpaceChar(c)){
             sb.append(c);
          } else if (c > sb.charAt(sb.length()-1)) {
              sb.append(c);
          }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SubStringIncrement s = new SubStringIncrement();
        System.out.println(s.subStringIncre("Welcome back"));
    }
}
