import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Crear un array de strings
        String[] strings = new String[]{"lio", "tema", "amigo", "alisas"};

        //Declarar e instanciar un archivo para escribirlo
        File file;
        FileWriter fileWriter;
        PrintWriter printWriter = null;
        try {
            file = new File("entrada.txt");
            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);

            //Recorrer el array de strings y escribir el archivo por lineas
            for (String string : strings) {
                printWriter.println(string);
            }

        } catch (IOException e) {
            System.out.println("Imposible abrir el archivo para escribir");
        } finally {
            if (printWriter != null) {
                printWriter.flush();
            }
        }

        //Declarar e instanciar un archivo para leerlo
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            file = new File("entrada.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String s;

            //Recorrer el archivo y leer linea por linea
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Imposible abrir el archivo para leer");
        }

        //Pedir el número al usuario
        int num;
        System.out.print("Introduzca un número entre 3 y 6: ");
        do {
            try {
                num = scanner.nextInt();
                if (num > 3 && num < 6) {
                    break;
                } else {
                    System.out.print("Vuelve a introducir un número entre 3 y 6: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Introduzca un entero: ");
                scanner.next();
            }
        } while (true);

        //Declarar e instanciar un archivo para escribirlo
        File file1 = new File("salida.txt");
        FileWriter fileWriter1 = null;

        try {
            fileWriter1 = new FileWriter(file1);
        } catch (IOException e) {
            System.out.println("Imposible abrir el archivo para escribir");
            ;
        }
        if (fileWriter1 != null) {
            try (PrintWriter printWriter1 = new PrintWriter(fileWriter1)) {
                for (String string : strings) {
                    if (string.length() <= num) {
                        if (string.length() == num)
                            printWriter1.print(string);
                        else
                            printWriter1.print(string + ", ");
                    }
                }
            }
        }
    }
}
