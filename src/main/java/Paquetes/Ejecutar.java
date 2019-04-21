package Paquetes;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutar {

    ArrayList<Polera> poleras = new ArrayList();
    int numeroPedido=1;
    
    public void inciar(){//menu de inicio
        boolean estado = true;
        boolean estanpadob;
        while (estado) {
            System.out.println("¿Que desea hacer?");
            System.out.println("1. tomar pedido desde archivo");
            System.out.println("2. hacer un pedido");
            System.out.println("3. Modificar un  pedido");
            System.out.println("4. ver los pedidos");
            System.out.println("5. Salir");
            int opcion = recibirValidarNumero();
            switch (opcion) {
                case 1: pedidoDesdeArchivo();                    
                    break;
                case 2: System.out.println("Ingrese la talla");
                        String talla=recibirPalabra();
                        System.out.println("Ingrese el material");
                        String material=recibirPalabra();
                        System.out.println("Ingrese el si quiere estanpado (si o no)");
                        String estanpado=recibirPalabra();
                        estanpadob = estanpado.equals("si");
                        recibirPedido(talla, material, estanpadob, numeroPedido++);
                    break;
                case 3: verPedidos();
                        System.out.println("Ingrese el numero de pedido");
                        int numero=recibirValidarNumero();
                        modificarPedido(numero);
                        
                    break;
                    
                case 4: verPedidos();  
                    break;
                case 5:
                    estado = false;
                    break;

            }
        }
    }
    
    public void recibirPedido(String talla, String material, boolean estanpado, int serial) {// se crea un pedido y se agrega al arreglo
        Polera po = new Polera(talla, material, estanpado, serial);
        poleras.add(po);
    }

    public void verPedidos() {//lista de los pedidos actuales
        for (int i = 0; i < poleras.size(); i++) {
            System.out.println(i);
            System.out.println(" Talla: " + poleras.get(i).getTalla());
            System.out.println(" Material: " + poleras.get(i).getMaterial());
            System.out.println(" Estanpado: " + poleras.get(i).getEstanpado());
            System.out.println(" Serial: " + poleras.get(i).getSerial());
            System.out.println("");
        }
    }

    public void modificarPedido(int posicion) {//modifica un pedido especifico y que valor se desea modificar
        try{
        Scanner sc= new Scanner(System.in);
        int n=elegirModificacion();
        switch(n){
            case 1: System.out.println("Ingrese la nueva talla");
                    String Talla=sc.nextLine();
                    poleras.get(posicion).setTalla(Talla);
                    break;
            
            case 2: System.out.println("Ingrese el nuevo material");
                    String Material=sc.nextLine();
                    poleras.get(posicion).setMaterial(Material);
                    break;
                    
            case 3: if (poleras.get(posicion).getEstanpado()==true){
                    System.out.println("El estanpado se ha quitado");
                    poleras.get(posicion).setEstanpado(false);
                    }else{
                    poleras.get(posicion).setEstanpado(true);
                    System.out.println("El estanpado se ha agregado");
                    }
                    break;
                    
            case 4: System.out.println("Ingrese el nuevo serial");
                    int serial= sc.nextInt();
                    poleras.get(posicion).setSerial(serial);
                    break;
        }
        }catch(IndexOutOfBoundsException e){
            System.out.println(" el producto no existe");
        }
    }

    public static int elegirModificacion() {
        boolean estado = true;
        int opcion = 0;
        while (estado) {
            try {
                System.out.println("Que desea modificar: ");
                System.out.println("1. Talla\n" + "2. Material\n" + "3. Estanpado\n" + "4. Serial\n");

                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();
                estado=false;
            } catch (InputMismatchException e) {
                System.out.println("El caracter ingresado no es numerico o se encuentra fuera del rango establecido, intentelo nuevamente.");
            }

        }
        return opcion;
    }
    
    public void pedidoDesdeArchivo(){//se toma el pedido desde un archivo sin leer la primera linea
        try{
        System.out.println("Seleccione el archivo");
        String ruta=Archivos.seleccionarArchivo();
        ArrayList<String> texto=Archivos.leerArchivo(ruta);
        for(int i=0;i<texto.size();i++){
            String[] s=texto.get(i).split(",");
            recibirPedido(s[1],s[0],Boolean.parseBoolean(s[2]),numeroPedido++);
        }
        }catch(InvalidPathException e){
            System.out.println("error");
        }
    }
    public static int recibirValidarNumero() {//recibe un numero lo valida y lo devuelve
        int num = 0;
        boolean estado = true;

        while (estado) {

            try {
                Scanner sc = new Scanner(System.in);

                num = sc.nextInt();
                estado = false;

            } catch (InputMismatchException e) {
                System.out.println("El caracter ingresado no es numerico o se encuentra fuera del rango establecido, intentelo nuevamente.");
                estado = true;
            }

        }
        return num;
    }
    public static String recibirPalabra() {//recibe una palabra la valida y la devuelve
        String num = " ";
        boolean estado = true;

        while (estado) {

            try {
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
}

