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
     * Menu)
     * Modulo que muestra el menú principal del programa y permite al usuario
     * seleccionar opciones.
     * 
     * @return VACIO
     */
    public static void menu() {
        boolean salir = false;
        // Carga el arreglo de cocheras
        // char[] arrEstados = cargarArregloEstadoCocheras();

        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1: Mostrar cantidad de cocheras libres");
            System.out.println("2: Buscar primera cochera libre");
            System.out.println("3: Solicitar una posicion a una cochera libre");
            System.out.println("4: Mostrar el estado final del estacionamiento");
            System.out.println("5: Salir\n");

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
                        // mostrarArregloEstadoCocheras(arrEstados);
                        break;
                    case 5:
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
        menu();
    }
}
