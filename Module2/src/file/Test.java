package file;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        System.out.println("simple message");

        System.err.println("error message");


        int i = System.in.read();//tra ve ma ASCII cua ky tu dau tien

        System.out.println((char)i);//in ky tu lay duoc ra man hinh

    }
}
