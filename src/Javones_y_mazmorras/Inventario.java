package Javones_y_mazmorras;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Equipamiento> equipamiento;

    public Inventario() {
        this.equipamiento = new ArrayList<>();

    public void agregarEquipamiento (Equipamiento equipamiento) {
        this.equipamiento.add(equipamiento);
        System.out.println(equipamiento.getNombre() + "se ha añadido al inventario");

    }

    public void mostrarInventario() {
        if (equipamiento.estaVacio());
        System.out.println("el inventario esta vacio");
    } else {
        System.out.println("Inventario");

        for (int i = 0; i < equipamiento.espacio(); i++) {
            Equipamiento e = equipamiento.get(i);
            System.out.println("- " + e.getNombre() + " (" + e.getTipo() + ")");
        }
    }
    
    }
}