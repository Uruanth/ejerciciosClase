package principal;

import diccionario.Diccionario;
import persistencia.Documento;

import java.io.IOException;
import java.util.Scanner;

public class Ejecutar {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Diccionario diccionario = new Diccionario();
        int option = 0;

        do {
            System.out.println("\nEscoga la opción que desea:\n" +
                    "1.Agregar entrada al diccionario\n" +
                    "2. Buscar una palabra en Ingles\n" +
                    "3. Ver todo el diccionario\n" +
                    "4. Guardar cambios en el diccionario\n" +
                    "5. Salir");

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("opcion no valida");
            }


            switch (option) {
                case 1:
                    System.out.println("Ingrese la palabra en ingles:");
                    String key = scanner.nextLine();
                    key = scanner.nextLine();
                    System.out.println("Ingrese la palabra en español: ");
                    String val = scanner.nextLine();
                    diccionario.agregar(key, val);
                    break;
                case 2:
                    System.out.println("Ingrese la palabra a buscar traducción");
                    String sear = scanner.nextLine();
                    sear = scanner.nextLine();
                    System.out.println("La palabra en español es: " + diccionario.buscar(sear));
                    break;
                case 3:
                        diccionario.getDic().forEach((k,v) -> System.out.println("En ingles: "+k+". En español: "+v));
                        break;
                case 4:
                    diccionario.guardarCambios(diccionario.getDic());
                    break;
                case 5:
                    System.out.println("Gracias, adios");
                    break;
                default:
                    System.out.println("opcion no disponible, vuelva a intentar");
                    break;
            }
        } while (option != 5);

    }

}
