import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);


        AddressBook addressBook = new AddressBook();
        int operador;
        int i=0;
        String respuesta ="";

        while (i<5){


            System.out.println("                --------Bienvenido--------");
            System.out.println("Escriba el número correspondiente a la operación a realizar.");
            System.out.println("                1.....................Load");
            System.out.println("                2.....................Save");
            System.out.println("                3.....................List");
            System.out.println("                4...................Create");
            System.out.println("                5...................Delete");
            System.out.println("                0....................Salir");
            System.out.print("            Ingrese la operación que desee realizar ");
            operador= scan.nextInt();
            System.out.print("");


            switch (operador){
                case 1:
                    addressBook.load();
                    System.out.println("Su archivo a sido cargado correctamente");
                    break;
                case 2:
                    try {
                        addressBook.save();
                        System.out.println("Su archivo a sido guardado correctamente");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Contactos: ");
                    addressBook.list();
                    break;
                case 4:
                    addressBook.create();
                    break;
                case 5:
                    addressBook.delete();
                    break;
                case 0:
                    i=5;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operador);
            }
            i++;
        }

    }
}