package Courses$;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoursMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoursInter coursInter = new CoursImple();
        while (true) {
            System.out.println(" 1-> All cours " +
                    " 2-> eur listname " +
                    " 3-> Uzb money " +
                    " 4-> All Sum ");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    coursInter.EURSlist();
                    break;
                case 2:
                    coursInter.eurListname();
                    break;
                case 3:
                    coursInter.MoneyUz();
                    break;
                case 4:
                    coursInter.readFile();
                    break;

            }
        }
    }
}
