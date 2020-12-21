package IOexercise;

import sun.swing.FilePane;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class IOTest {
    static  String  filepath = "D:/Desktap/1.txt";

    public static void main(String[] args) {

    }

    public static void BufferedReaderWay() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String str;
        while((str = br.readLine()) != null) {
//            System.out.println(br.readLine());
            System.out.println(str);
        }
        br.close();
    }

    public static void BufferedInputStreamWay() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));
        byte[] bytes = new byte[1024];
        int n = 0;
        while((n = bis.read(bytes, 0, bytes.length)) != -1) {
            String str = new String(bytes, 0 ,n ,"GBK");
            System.out.print(str);
        }
        bis.close();
    }

    public static void InputStreamWay() throws IOException {
        InputStream is = new FileInputStream(filepath);
        int n = -1;
        byte[] bytes = new byte[100];
        while((n = is.read(bytes, 0, bytes.length)) != -1) {
            String str = new String(bytes, 0, n);
            System.out.print(str);
        }
        is.close();
    }

    public static void InputStreamReaderWay() throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8);
        int n = 0;
//        char[] chars = new char[1000];
//        while((n = isr.read(chars, 0, chars.length)) != -1) {
//            for(int i = 0; i < n; i++) {
//                System.out.print(chars[i]);
//            }
//        }
        while((n = isr.read()) != -1) {
            System.out.print((char) n);
        }
        isr.close();
    }

    public static void ReaderWay() throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8);
        int n;
        while((n = reader.read()) != -1) {
            System.out.print((char) n);
        }
        reader.close();
    }

    public static void FileInputStreamWay() throws IOException {
        FileInputStream fis = new FileInputStream(filepath);
        int n = fis.read();
        while(n != -1) {
            System.out.print((char)n);
            n = fis.read();
        }
        fis.close();
    }
}
