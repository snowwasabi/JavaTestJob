package com.company;

public class Solution {

    public static Integer getResult(String race, String cellType) {

        //Преобразование данных под свойства поля
        switch (race) {
            case "Human":
                cellType = cellType.replace("S", "5 ");
                cellType = cellType.replace("W", "2 ");
                cellType = cellType.replace("T", "3 ");
                cellType = cellType.replace("P", "1 ");

                break;
            case "Swamper":
                cellType = cellType.replace("S", "2 ");
                cellType = cellType.replace("W", "2 ");
                cellType = cellType.replace("T", "5 ");
                cellType = cellType.replace("P", "2 ");
                break;
            case "Woodman":
                cellType = cellType.replace("S", "3 ");
                cellType = cellType.replace("W", "3 ");
                cellType = cellType.replace("T", "2 ");
                cellType = cellType.replace("P", "2 ");
                break;
        }

//        System.out.print(cellType + "\n");
//        System.out.print("\n");

        //      Создание поля
        //1. Из строки в массив
        String strArr[] = cellType.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
//            System.out.print(numArr[i]);
        }
        numArr[0] = 0; //т.к. стартовая клетка не входит в затраты

//        System.out.print("\n");

        //2. Из массива в двумерный массив
        int lengthX = 4;
        int lengthY = 4;
        int[][] field = new int[lengthX][lengthY];
        int n = 0;
        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                try {
                    field[i][j] = numArr[n];
//                    System.out.print(field[i][j]+"\t");
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    field[i][j] = 0;
                }
                n++;
            }
//            System.out.print("\n");
        }

//        System.out.print("\n");

//        for (int i = 0; i < lengthY; i++){
//            for (int j = 0; j < lengthX; j++) {
//                System.out.print(field[i][j] + "\t");
//            }
//            System.out.print("\n");
//        }
//        System.out.print("\n");

        //      Нахождение кратчайшего пути!
        for (int i = 1; i < field.length; i++) {
            field[i][0] = field[i][0] + field[i - 1][0];
            field[0][i] = field[0][i] + field[i - 1][0];
        }
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {
                field[i][j] = field[i][j] + Math.min(field[i - 1][j], field[i][j - 1]);
            }
        }

//        for (int i = 0; i < lengthY; i++){
//            for (int j = 0; j < lengthX; j++) {
//                System.out.print(field[i][j] + "\t");
//            }
//            System.out.print("\n");
//        }

        Integer r = field[lengthY - 1][lengthX - 1];
        return (r);
    }

}
