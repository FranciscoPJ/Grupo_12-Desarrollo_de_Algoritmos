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
     * Modulo que busca la primer cochera libre, -1 en caso de no encontrarla
     * 
     * @param arr
     * @return int
     */
    public static int primerCocheraLibre(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'L') {
                return i;
            }
        }
        return -1;
    }

    public static void mostrarArregloEstadoCocheras(char[] finalEstacionamiento) {
        int i;
        System.out.print("Cocheras: ");
        for (i = 0; i < finalEstacionamiento.length; i++) {
            System.out.print(" [" + finalEstacionamiento[i] + "] ");
        }
    }

    public static int contarCocherasLibres(char[] arrLibre) {  // Modulo que se encarga de contar las cocheras libres
        int contador = 0;   // contador guarda la cantidad de cocheras libres, se inicia en 0

        for (int i = 0; i < arrLibre.length; i++) {
        if (arrLibre[i] == 'L') {
            contador++;
        } /* mientras la posición en la que se encuentra la variable i en el arreglo sea una L,
          significa que la cochera está libre y el contador de cocheras libres suma 1 */
    }

        return contador; // Cuando termine el for, se retornará el valor de la variable contador
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
                        
            i++; // incrementa el indice para continuar con la busqueda
        }
        // retorna el indice del primer lugar libre que tenga N lugares consecutivos libres, o -1 si no se encontraron
        return indice;
    }

    public static void ocuparLugar(char[] arr) {
        int lugar_a_ocupar = 0;
        int contadorLugaresDisponibles = primerCocheraLibre(arr); // <-----  [ Usar el modulo creado por juan. ]
        if (contadorLugaresDisponibles != 0) {
            boolean lugarOcupado = false;
            System.out.println("\nLos siguientes lugares estan disponibles: ");
            for (int i = 0; i < arr.length; i++) { //Repasa todo el arreglo
                if (arr[i] == 'L') {
                    System.out.println("Lugar: " + (i + 1)); // imprime los lugares en donde hay lugares disponibles.
                }
            }
            do {
                System.out.println("\nIngrese el lugar que desea ocupar ");
                lugar_a_ocupar = sc.nextInt();
                lugar_a_ocupar--; // le resto uno para que el usuario no ponga entre 0 y arr.lenght, pues se busca que la posicion 0 la pongan como 1

                if (lugar_a_ocupar >= 0 && lugar_a_ocupar <= arr.length) { //Nos aseguramos de que el numero de lugar este en el rango del arreglo.
                    if (arr[lugar_a_ocupar] == 'O') { //Busca segun el indice puesto cual lugar esta disponible.
                        System.out.println("El lugar ya se encuentra ocupado, por favor ingrese otro numero del listado disponible");
                        lugarOcupado = false;
                    } else if (arr[lugar_a_ocupar] == 'L') {
                        arr[lugar_a_ocupar] = 'O'; // Cambia a O el lugar desocupado.
                        lugarOcupado = true; // Cambia a true para cerrar el bucle

                    }
                } else {
                    System.out.println("Ingrese un numero valido");
                    lugarOcupado = false; // flag para repetir el bucle
                }
            } while (!lugarOcupado);
        } else {
            System.out.println("No hay cocheras disponibles..");
        }
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
                         System.out.println("\nCantidad de cocheras libres: " +
                         contarCocherasLibres(arrEstados)+"\n");
                        break;
                    case 2:
                        int primerCocheraLibre = primerCocheraLibre(arrEstados);
                        if (primerCocheraLibre != -1) {
                            System.out.println(
                                    "La primer cochera libre se encuentra en el indice: " + (primerCocheraLibre + 1));
                        } else {
                            System.out.println("No hay cocheras libres.");
                        }                       
                        break;
                    case 3:                        
                        ocuparLugar(arrEstados); // <----- Agregar al principio el modulo que muestra la cantidad de lugares disponibles                      
                        break;
                    case 4:
                        System.out.println("\nEstado del estacionamiento:\n");
                        mostrarArregloEstadoCocheras(arrEstados);

                        System.out.println();
                        break;
                    case 5:
                        System.out.println("\nIngrese la cantidad N de lugares consecutivos que desea buscar:\n");
                        int n = sc.nextInt();
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
        // Carga el arreglo de cocheras
        char[] estacionamiento = cargarArregloEstacionamiento();
        menu(estacionamiento);
    }

}
