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

public class ReturnCoursName {

    public static List<String> eurList() {

        String name = " http://cbu.uz/uzc/arkhiv-kursov-valyut/json/";
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        try {
            URL url = new URL(name);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                stringBuilder.append(row);
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Eur>>() {
        }.getType();
        List<Eur> eurList = gson.fromJson(stringBuilder.toString(), type);
        for (Eur eur : eurList) {

            String ccyNmUZ = eur.getCcyNmUZ();
            stringList.add(ccyNmUZ);

        }
        return stringList;

    }

    public static Eur eurList(int n) {

        String name = " http://cbu.uz/uzc/arkhiv-kursov-valyut/json/";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(name);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                stringBuilder.append(row);
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Eur>>() {
        }.getType();
        List<Eur> eurList = gson.fromJson(stringBuilder.toString(), type);
        return eurList.get(n - 1);


    }

    public static double eurList2(int n) {
        String name = " http://cbu.uz/uzc/arkhiv-kursov-valyut/json/";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(name);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                stringBuilder.append(row);
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Eur>>() {
        }.getType();
        List<Eur> eurList = gson.fromJson(stringBuilder.toString(), type);
        String nominal = eurList.get(n - 1).getRate();
        return Double.parseDouble(nominal);
    }
    public static  void eur (File file, String text){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  static List<String> eurs(File file){
        List<String> eurList = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileInputStream fileInputStream =new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            while ((row = bufferedReader.readLine()) !=null){
                stringBuilder.append(row);
            }
            bufferedReader.close();
            fileInputStream.close();
            Type type = new TypeToken<List<String>>() {}.getType();
            Gson gson = new Gson();
            eurList= gson.fromJson(stringBuilder.toString(), type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return eurList;


    }

}