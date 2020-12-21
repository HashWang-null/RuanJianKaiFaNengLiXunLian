package file;


import java.io.File;
import java.util.regex.Pattern;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class SearchFile {
    public static void main(String[] args) {
        File file = new File("D:/Desktap");
        searchFiles(file);
//        System.out.println("[.+]");
    }
    public static int f(int n) {
        if(n == 1) {
            return 1;
        }
        return n * f(n-1);
    }


    public static void searchFiles(File file) {
        if(file != null && file.isFile()) {
            if(Pattern.matches(".+/.[(jpg)|(txt)]", file.getName())) {
                System.out.println(file.getName());
            }
            return;
        }
        for(File iFile: file.listFiles()) {
            searchFiles(iFile);
        }
    }
}
