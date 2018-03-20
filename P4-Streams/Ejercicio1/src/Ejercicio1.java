import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {

        //Escribir un fichero con las letras del alfabeto
        File escriptor = new File("prueba.txt");
        try (FileWriter arxiu = new FileWriter(escriptor)) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                arxiu.write(ch + " ");
            }
        } catch (IOException e) {
            System.out.println("Imposible abrir el archivo para escribir");
        }

        //Abrir un fichero y leerlo
        File escriptorIn = new File("prueba.txt");
        try (FileReader arxiuIn = new FileReader(escriptorIn)) {
            int unChar;
            while ((unChar = arxiuIn.read()) != -1) {
                System.out.print((char) unChar);
            }
        } catch (IOException e) {
            System.out.println("Imposible abrir el archivo para leer");
        }
    }
}
