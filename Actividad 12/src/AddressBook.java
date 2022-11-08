import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
Scanner scan = new Scanner(System.in);
    String tel;
    String nom;
    String archivoin = "C:/Users/luisf/IdeaProjects/Actividad 12/contactos.txt";
    String archivoout= "C:/Users/luisf/IdeaProjects/Actividad 12/contactos.txt";

    HashMap<String, String> contactos = new HashMap<>();
    BufferedReader bf;
    BufferedWriter bw;

    public void load( ) throws IOException {

        {
            try {
                bf = new BufferedReader(new FileReader(archivoout));
                bw = new BufferedWriter(new FileWriter(archivoin,true));

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void save( ) throws IOException {
        bw.newLine();
        bw.write(String.valueOf(contactos));
        bw.flush();
        bf.close();
        bw.close();
    }

    public void list() throws IOException {

        for (Map.Entry<String,String>entry: contactos.entrySet()){

            System.out.println();
            System.out.println("{"+entry.getKey()+":"+entry.getValue()+"}");
        }
    }

    public void create() throws IOException {

        System.out.print("Por favor ingrese el número telefonico ");
        tel=scan.nextLine();
        System.out.println();
        System.out.print("Por favor ingrese el nombre ");
        nom=scan.nextLine();
        contactos.put(tel,nom);

    }

    public void delete() throws IOException {
        System.out.print("Por favor ingrese el número telefonico que desee borrar");
        tel=scan.nextLine();
        contactos.remove(contactos.containsKey(tel));
        System.out.println("El contacto a sido eliminado");

    }
}

