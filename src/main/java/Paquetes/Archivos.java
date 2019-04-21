package Paquetes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Archivos {
    
    public static ArrayList<String> leerArchivo(String ruta) {//lee el archivo de la ruta especificada desde segunda linea recibe ruta y devuelve un array con en texto de cada linea
        ArrayList<String> texto=new ArrayList();
        File archivo = new File(ruta);
        String line=null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            br.readLine();
            while((line = br.readLine()) != null){
                texto.add(line);
            }
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return texto;
    }
    public static String seleccionarArchivo() { //selecciona un archivo
        boolean estado=true;
        String ruta = "";
        while(estado){
        try {
            JFileChooser j = new JFileChooser();
            j.showOpenDialog(j);
            ruta = j.getSelectedFile().getAbsolutePath();
            estado=false;
        } catch (Exception e) {
            System.out.println("Error al selecionar archivo");
        }
        }
        return ruta;
    }
    public static String recibirPalabra() { // recibe un texto y lo valida
        String num = " ";
        boolean estado = true;

        while (estado) {

            try {
                System.out.println("Ingrese el texto que desea agregar");
                Scanner sc = new Scanner(System.in);

                num = sc.nextLine();
                estado = false;

            } catch (InputMismatchException e) {
                System.out.println("El caracter ingresado no es una palabra, intentelo nuevamente.");
                estado = true;
            }

        }
        return num;
    }
    public static String recibirRuta() { //recibe una ruta

        String ruta = JOptionPane.showInputDialog("Escriba la ruta del archivo");

        return ruta;
    }
    
    
}
