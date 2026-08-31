package tp_grupal.primera_trabajo;

import java.util.Scanner;

public class ejercicio_f1yf2_grupo12 {

    // Scanner único para todo el programa
    public static Scanner sc = new Scanner(System.in);

    /**
     * Modulo para que el usuario ingrese la cantidad y estado de las cocheras
     * 
     * @return ARREGLO
     */
    public static char[] cargarArregloEstacionamiento() {
        int cantidadCocheras;
        do {
            System.out.print("Ingrese la cantidad de cocheras: ");
            cantidadCocheras = sc.nextInt();
        } while (cantidadCocheras <= 0);
        char[] estacionamiento = new char[cantidadCocheras];

        for (int i = 0; i < estacionamiento.length; i++) {
            char estado;
            do {
                System.out.print("Ingrese el estado de la cochera " + (i + 1) + " (O o L): ");
                estado = sc.next().charAt(0);
            } while (estado != 'L' && estado != 'O');
            estacionamiento[i] = estado;
        }
        return estacionamiento;
    }

    /**
     * Modulo que busca y devuelve el indice del
     * primer lugar libre que tenga N lugares consecutivos libres.
     * 
     * @param arr char[]
     * @param n INT
     * @return INT
     */
    public static int buscarIndiceDeLugaresConsecutivos(char[] arr, int n) {
        int cantLugaresConsecutivos = 0; // cuenta la cantidad de lugares consecutivos libres
        int indice = -1;                 // inicializa el indice en -1 para indicar que no se encontraron N lugares consecutivos libres
        int indiceInicio = 0;            // obtiene el indice del primer lugar libre que tenga N lugares consecutivos libres
        int longitud = arr.length;       // obtiene la longitud del arreglo
        int i = 0;                       // inicializa el indice para recorrer el arreglo

        while (i < longitud && cantLugaresConsecutivos < n) {
            if (arr[i] == 'L') {
                cantLugaresConsecutivos++; // incrementa la cantidad de lugares consecutivos libres
                if (cantLugaresConsecutivos == 1) {
                    indiceInicio = i; // guarda el indice del primer lugar libre
                }

                if (cantLugaresConsecutivos == n) {
                    indice = indiceInicio; // guarda el indice del primer lugar libre que tenga N lugares consecutivos libres
                }

            } else {
                cantLugaresConsecutivos = 0; // reinicia la cuenta si encuentra un lugar ocupado
            }
            // incrementa el indice para continuar con la busqueda
            i++;
        }
        // retorna el indice del primer lugar libre que tenga N lugares consecutivos libres, o -1 si no se encontraron
        return indice;
    }

    /**
     * Menu)
     * Modulo que muestra el menú principal del programa y permite al usuario
     * seleccionar opciones.
     * 
     * @return VACIO
     */
    public static void menu(char[] arrEstados) {
        boolean salir = false;
        // Carga el arreglo de cocheras
        // char[] arrEstados = cargarArregloEstadoCocheras();

        do {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1: Mostrar cantidad de cocheras libres");
            System.out.println("2: Buscar primera cochera libre");
            System.out.println("3: Solicitar una posicion a una cochera libre");
            System.out.println("4: Mostrar el estado final del estacionamiento");
            System.out.println("5: Buscar N lugares consecutivos de cocheras libres");
            System.out.println("6: Salir\n");

            // Validamos que el usuario haya ingresado un entero
            if (sc.hasNextInt()) {

                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        // System.out.println("\nCantidad de cocheras libres: " +
                        // contarCocherasLibres(arrEstados)+"\n");
                        break;
                    case 2:
                        /*
                         * int indicePrimeraCocheraLibre = buscarPrimeraCocheraLibre(arrEstados);
                         * if (indicePrimeraCocheraLibre != -1) {
                         * System.out.println("\nLa primera cochera libre se encuentra en el índice: "
                         * + indicePrimeraCocheraLibre + "\n");
                         * } else {
                         * System.out.println("\nNo hay cocheras libres.\n");
                         * }
                         */
                        break;
                    case 3:
                        // System.out.println("\nIngrese un índice desde 1 al " + arrEstados.length
                        // + " para solicitar una cochera libre:");
                        if (sc.hasNextInt()) {
                            int indice = sc.nextInt();
                            // solicitarCocheraLibre(arrEstados, indice);
                        } else {
                            System.out.println("\nEntrada no válida. Por favor, ingrese un número entero.");
                            sc.next(); // Limpiar la entrada inválida
                        }
                        break;
                    case 4:
                        System.out.println("\nEstado del estacionamiento:\n");
                        mostrarArregloEstadoCocheras(arrEstados);
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("\nIngrese la cantidad N de lugares consecutivos que desea buscar:\n");
                        int n = sc.nextInt();
                        // mostrarArregloEstadoCocheras(char[] arr, int indiceN, int cantidadN)
                        int indice = buscarIndiceDeLugaresConsecutivos(arrEstados, n);
                        
                        if (indice != -1) {
                            System.out.println("\nSe encontraron " + n 
                                + " lugares consecutivos libres a partir del índice: " + (indice + 1));
                        } else {
                            System.out.println("\nNo se encontraron " + n + " lugares consecutivos libres.");
                        }
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

            } else {
                // El dato ingresado NO era un entero
                System.out.println("\nOpción no válida. Intente nuevamente con un numero entero.\n");

                // Elimina del Scanner el dato incorrecto
                sc.next();
            }
        } while (!salir);

    }

    public static void main(String[] args) {
        char[] estacionamiento = cargarArregloEstacionamiento();
        menu(estacionamiento);
    }

    public static void mostrarArregloEstadoCocheras(char[] finalEstacionamiento) {
        int i;
        System.out.print("Cocheras: ");
        for (i = 0; i < finalEstacionamiento.length; i++) {
            System.out.print(" [" + finalEstacionamiento[i] + "] ");
        }
    }
}
