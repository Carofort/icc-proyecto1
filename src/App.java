import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        MetodosOrdenamiento ordenador = new MetodosOrdenamiento();
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while(!salir){
            System.out.println("*Menú principal*");
            System.out.println("1. Ingrese un arreglo");
            System.out.println("2. Ordenar Arreglo");
            System.out.println("0. Salir");

            opcion = leer.nextInt();

            switch(opcion){
                case 1:
                    ordenador.arregloPrincipal();
                    break;
                case 2:
                if(ordenador.getArreglo() == null){
                    System.out.println("Debe ingresar primeramente un arreglo");
                } else{
                    ordenador.ordenarArreglo(); 
                }    
                    break;
                case 0:
                    salir = true;
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Solo las opciones: 0, 1 y 2");    
            }   
        }     
        leer.close();
    }
}
