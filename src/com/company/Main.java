package com.company;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String cellType = null;
        String race = null;

        //      Получение данных
        try {
            File file = new File("Data.txt");

            //Создание файла при его отсутствии
            if (!file.exists()) {
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                pw.println("STWSWTPPTPTTPWPP");
                pw.println("Woodman");
                pw.close();
            }

            //Считывание данных из файла
            BufferedReader br = null;
            br = new BufferedReader(new FileReader("Data.txt"));
            cellType = br.readLine();
            race = br.readLine();

            //Проверка на дополнительные данные в файле
            String i = null;
            i = br.readLine();
            if (i == null)
                br.close();
            else {
                System.out.println("new data");
                br.close();
            }
        } catch (IOException e) {
            System.out.print("Error: " + e);
        }

        assert race != null;
        Integer s = Solution.getResult(race, cellType);
        System.out.print(s);
    }
}
