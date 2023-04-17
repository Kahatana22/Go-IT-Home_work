package Modul10.Tasks.Task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/main/java/Modul10/Resource/file.txt");
        Scanner s = new Scanner(fis);
        while (s.hasNext()) {
            String str = s.nextLine();
            Pattern pattern = Pattern.compile("(\\(\\d{3}\\)\\s*\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})");
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                System.out.println("str = " + str);
            }
        }
        fis.close();
    }
}
