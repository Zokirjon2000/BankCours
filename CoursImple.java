package Courses$;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoursImple implements CoursInter {
    private Scanner sc  = new Scanner(System.in);
    private   List<String> stringList1 ;
    private File file = new File(" AllCours.txt");

    @Override
    public void EURSlist() {
        List<String> eurs = ReturnCoursName.eurList();
        for (int i = 0; i < eurs.size(); i++) {
            System.out.println(  (i+1)  + " -> "+ eurs.get(i));
        }
    }

    @Override
    public void eurListname() {
        List<String> stringList = ReturnCoursName.eurList();
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(  (i+1)  + " -> "+ stringList.get(i));
        }
        System.out.println(" Kusr haqida malumotni tanlang ? ");
        int n = sc.nextInt();
        Eur eur = ReturnCoursName.eurList(n);
        System.out.println(eur);
    }

    @Override
    public void MoneyUz() {
        List<String> stringList = ReturnCoursName.eurList();
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(  (i+1)  + " -> "+ stringList.get(i));
        }
        System.out.println(" Siz qaysi valyutada pulingiz bor ");
        int n = sc.nextInt();
        double money  = ReturnCoursName.eurList2(n);
        System.out.println( " Tanlagan valyutadangizdagi  pulni kiriting  ");
        double money1 = sc.nextDouble();
        System.out.println(money*money1);
              String string = String.valueOf(money*money1);
              Gson gson = new Gson();
        List<String> eurs = ReturnCoursName.eurs(file);
        if (eurs == null){
            eurs = new ArrayList<>();
        }
        eurs.add(string);
        String s = gson.toJson(eurs);
        ReturnCoursName.eur(file,s);
    }

    @Override
    public void readFile() {
        List<String> stringList = ReturnCoursName.eurs(file);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println((i+1) + " -> " + stringList.get(i));
        }
        double sum = 0;
        for (int i = 0; i < stringList.size(); i++) {
            double p = Double.parseDouble(stringList.get(i));
            sum+=p;
        }

        System.out.println(" Sizning jami pulingiz : " + " -> " + sum);

    }


}
