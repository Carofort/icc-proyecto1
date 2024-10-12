import java.util.Scanner;
import java.util.Arrays;
public class MetodosOrdenamiento{
    private int[] arreglo;
    public void arregloPrincipal(){
        Scanner leer = new Scanner(System.in);
        int tamanio = leerEnteroValido(leer, "Ingrese el tamaño del arreglo: ", false);
        arreglo = new int[tamanio];

        for(int i = 0; i < tamanio; i++){
            arreglo[i] = leerEnteroValido(leer, "Valor en la posición " + i, true);
        }
        System.out.println("Arreglo ingresado: " + Arrays.toString(arreglo));
    }

    public int[] getArreglo() {
        return arreglo;
    }
  
    public static int leerEnteroValido(Scanner leer, String mensaje, boolean numerosNegativos){
        int numero;
        do{
            System.out.println(mensaje);
            while(!leer.hasNextInt()){
                System.out.println("Le pedí un entero válido");
                System.out.println(mensaje);
                leer.next();
            }
            numero = leer.nextInt();
            if(!numerosNegativos && numero < 0){
                System.out.println("No se permiten números negativos");

            }
        } while(!numerosNegativos && numero < 0);
        return numero;
    }    

    public void ordenarArreglo(){ 
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            System.out.println("- Escoja un método de ordenamiento: ");
            System.out.println("1. Método Burbuja");
            System.out.println("2. Método Selección");
            System.out.println("3. Método Inserción");
            System.out.println("4. Método Burbuja Mejorado");
            System.out.println("0. Regresar al menu principal");
            int metodo = leerEnteroValido(leer, "Solo las opciones: 0, 1, 2, 3 y 4", false, 0, 4);

            if(metodo == 0){
                salir = true;
                continue;
            }    

            System.out.println("- ¿En qué orden?");
            System.out.println("1. Ascendente");
            System.out.println("2. Descendente");
            boolean ascendente = leerEnteroValido(leer, "Solo las opciones: 1 y 2", false, 1, 2) == 1;

            System.out.println("- ¿Desea ver los pasos?");
            System.out.println("1. Si");
            System.out.println("2. No");
            boolean logs = leerEnteroValido(leer, "Solo las opciones: 1 y 2", false, 1, 2) == 1;

            int[] arregloCopia = Arrays.copyOf(arreglo, arreglo.length);

            switch(metodo){
                case 1:
                    burbujaTradicional(arregloCopia, ascendente, logs);
                    break;
                case 2:
                    sortBySeleccion(arregloCopia, ascendente, logs);
                    break;
                case 3:
                    sortInsercion(arregloCopia, ascendente, logs);
                    break;
                case 4:
                    sortBubbleAvanzado(arregloCopia, ascendente, logs);
                    break;
                default:
                    System.out.println("Solo las opciones: 0, 1, 2, 3 y 4");
            }    
            System.out.println("Arreglo ordenado: " + Arrays.toString(arregloCopia));
        } 
      
    }
    public static int leerEnteroValido(Scanner leer, String mensaje, boolean numerosNegativos,
                                       int min, int max){
        int numero;
        do{
            System.out.println(mensaje);
            while(!leer.hasNextInt()){
                System.out.println("Le pedí un entero válido");
                System.out.println(mensaje);
                leer.next();
            }
            numero = leer.nextInt();
            if(!numerosNegativos && numero < 0){
                System.out.println("No se permiten números negativos");

            }else if(numero < min || numero > max) {
            }

        } while(!numerosNegativos && numero < 0 || (numero < min || numero > max));
        return numero;
    }    

    //BURBUJA
    public void burbujaTradicional(int[] arregloCopia, boolean ascendente, boolean logs) {
        int tamanio = arregloCopia.length;
        for (int i = 0; i < tamanio - 1; i++) {
            for (int j = 0; j < tamanio - 1; j++) {
                if (ascendente? arregloCopia[j] > arregloCopia[j + 1] : arregloCopia[j] < arregloCopia[j + 1]){  
                    int aux = arregloCopia[i];
                    arregloCopia[i] = arregloCopia[j + 1];
                    arregloCopia[j + 1] = aux;
                }
            }
            if(logs){
                System.out.println("Estado del arreglo: " + Arrays.toString(arregloCopia));
            }
        }
    }

    //SELECCIÓN
    public void sortBySeleccion(int[] arregloCopia, boolean ascendente, boolean logs) { 
        int tamanio = arregloCopia.length;
        for(int i = 0; i < tamanio; i++){
            System.out.println("Iteracion número " + (i + 1));
            int indice = i;
            for(int j = i + 1; j < tamanio; j++){
                if (ascendente? arregloCopia[j] < arregloCopia[indice] : arregloCopia[j] > arregloCopia[indice]){
                    indice = j;   
                    
                }     
            }
            int aux = arregloCopia[indice];
            arregloCopia[indice] = arregloCopia[i];
            arregloCopia[i] = aux;      
            
            if(logs){
                System.out.println("Estado del arreglo" + Arrays.toString(arregloCopia));
            }
        }
    }
    
    //INSERCIÓN
    public void sortInsercion(int[] arregloCopia, boolean ascendente, boolean logs) {
        int tamanio = arregloCopia.length;
        if(logs){
            for(int i = 1; i < tamanio; i++){
                System.out.println("Iteracion número " + i);
                int aux = arregloCopia[i];
                int j = i - 1;
                System.out.println("i=" + i + " j=" + j + " [i]=" + arregloCopia[i] + " [j]=" + arregloCopia[j]);
                while(j >= 0 && (ascendente? arregloCopia[j] > aux  : arregloCopia[j] < aux)){
                    System.out.println("Comparamos " + aux + " con " + arregloCopia[j]);
                    arregloCopia [j + 1] = arregloCopia[j];
                    j--;
                    System.out.println( Arrays.toString(arregloCopia));
                }
                arregloCopia[j+1] = aux;
                System.out.println(Arrays.toString(arregloCopia));
                }
        } else {
            for(int i = 1; i < tamanio; i++){
                int aux = arregloCopia[i];
                int j = i - 1;
                while(j >= 0 && (ascendente? arregloCopia[j] > aux  : arregloCopia[j] < aux)){
                    arregloCopia [j + 1] = arregloCopia[j];
                    j--;
                }
                arregloCopia[j + 1] = aux;
            }
        }
    }

    //BURBUJA AVANZADO
    public void sortBubbleAvanzado(int[] arregloCopia, boolean ascendente, boolean logs) {
        int tamanio = arregloCopia.length;
        if(logs){
            for(int i = 0; i < tamanio; i++){
                boolean intercambio = false;
                System.out.println("Iteración: " + (i+1));
                for(int j = 0; j < tamanio - 1 - i; j++){
                    System.out.println("j= " + j +" [j]=" + arregloCopia[j] + 
                    " j+1= " + j+1 +" [j+1]=" + arregloCopia[j+1]);
                    if(ascendente? arregloCopia[j] > arregloCopia[j + 1] : arregloCopia[j] < arregloCopia[j + 1]){
                        System.out.println("Si hay cambio");
                        int aux = arregloCopia[j];
                        arregloCopia[j] = arregloCopia[j + 1];
                        arregloCopia[j + 1] = aux;
                        intercambio = true;
                    } 
                    System.out.println( Arrays.toString(arregloCopia));
                if(!intercambio){
                    System.out.println("No hubo cambio");
                    break;
                }
                }          
            }
        } else {
            for(int i = 0; i < tamanio; i++){
                boolean intercambio = false;
                for(int j = 0; j < tamanio - 1 - i; j++){
                    if(ascendente? arregloCopia[j] > arregloCopia[j + 1] : arregloCopia[j] < arregloCopia[j + 1]){
                        int aux = arregloCopia[j];
                        arregloCopia[j] = arregloCopia[j + 1];
                        arregloCopia[j + 1] = aux;
                        intercambio = true;
                    } 
                }
                if(!intercambio){
                    break;   
                }       
            }
        }
    }  
}
    