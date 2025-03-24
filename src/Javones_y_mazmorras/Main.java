package Javones_y_mazmorras;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Personaje> personajes = new ArrayList<>();
        
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Interactuar");
            System.out.println("4. Añadir item a un personaje");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            if (opcion == 1) {
                System.out.print("Ingrese nombre del personaje: ");
                String nombre = scanner.nextLine();
                System.out.print("Seleccione tipo (1. Mago, 2. Guerrero, 3. Ladrón): ");
                int tipo = scanner.nextInt();
                System.out.print("Ingrese nivel: ");
                int nivel = scanner.nextInt();
                System.out.print("Ingrese puntos de vida: ");
                int vida = scanner.nextInt();
                scanner.nextLine();
                
                Personaje nuevoPersonaje = null;
                if (tipo == 1) {
                    System.out.print("Ingrese mana: ");
                    double mana = scanner.nextDouble();
                    nuevoPersonaje = new Mago(nombre, nivel, vida, "", mana);
                } else if (tipo == 2) {
                    nuevoPersonaje = new Guerrero(nombre, nivel, vida, "");
                } else if (tipo == 3) {
                    nuevoPersonaje = new Ladron(nombre, nivel, vida, "");
                }
                
                if (nuevoPersonaje != null) {
                    personajes.add(nuevoPersonaje);
                    System.out.println("Personaje creado con éxito.");
                }
            } else if (opcion == 2) {
                if (personajes.isEmpty()) {
                    System.out.println("No hay personajes creados.");
                } else {
                    for (Personaje p : personajes) {
                        p.mostrarInfo();
                    }
                }
            } else if (opcion == 3) {
                if (personajes.size() < 2) {
                    System.out.println("Debe haber al menos dos personajes para interactuar.");
                    continue;
                }
                System.out.println("Seleccione el personaje que actuará:");
                for (int i = 0; i < personajes.size(); i++) {
                    System.out.println((i + 1) + ". " + personajes.get(i).getNombre());
                }
                int idx1 = scanner.nextInt() - 1;

                System.out.println("Seleccione el personaje objetivo:");
                for (int i = 0; i < personajes.size(); i++) {
                    if (i != idx1)
                        System.out.println((i + 1) + ". " + personajes.get(i).getNombre());
                }
                int idx2 = scanner.nextInt() - 1;

                Personaje actuante = personajes.get(idx1);
                Personaje objetivo = personajes.get(idx2);
                
                // Realizar interacción según el tipo de personaje
                if (actuante instanceof Mago) {
                    // El mago puede lanzar hechizo
                    System.out.println(actuante.getNombre() + " está listo para lanzar un hechizo.");
                    ((Mago) actuante).lanzarHechizo();
                } else if (actuante instanceof Guerrero) {
                    // El guerrero puede proteger
                    System.out.println(actuante.getNombre() + " está listo para proteger.");
                    ((Guerrero) actuante).proteger(objetivo);
                } else if (actuante instanceof Ladron) {
                    // El ladrón puede robar
                    if (objetivo.getInventario().isEmpty()) {
                        System.out.println(objetivo.getNombre() + " no tiene ningún item para robar.");
                    } else {
                        System.out.println(actuante.getNombre() + " intenta robar un item de " + objetivo.getNombre());
                        String itemRobado = objetivo.getInventario().get(0); // Robar el primer item
                        objetivo.getInventario().remove(0);  // Eliminar el item robado del inventario
                        actuante.getInventario().add(itemRobado);  // Añadirlo al inventario del ladrón
                        System.out.println(actuante.getNombre() + " ha robado " + itemRobado + " de " + objetivo.getNombre());
                    }
                }
            } else if (opcion == 4) {
                System.out.println("Seleccione el personaje al que se le añadirá un item:");
                for (int i = 0; i < personajes.size(); i++) {
                    System.out.println((i + 1) + ". " + personajes.get(i).getNombre());
                }
                int idx = scanner.nextInt() - 1;
                scanner.nextLine();  // Limpiar el buffer

                System.out.print("Ingrese el nombre del item: ");
                String itemNombre = scanner.nextLine();
                System.out.print("Ingrese el tipo del item (arma, armadura, etc.): ");
                String itemTipo = scanner.nextLine();

                Equipamiento nuevoItem = new Equipamiento(itemNombre, itemTipo);
                personajes.get(idx).getInventario().add(itemNombre);  // Añadir el item al inventario del personaje
                System.out.println("Item añadido al inventario de " + personajes.get(idx).getNombre());
            } else if (opcion == 5) {
                System.out.println("Saliendo del juego...");
                scanner.close();
                return;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
