package Javones_y_mazmorras;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private List<String> inventario;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.inventario = new ArrayList<>(); 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public List<String> getInventario() {
        return inventario;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Puntos de Vida: " + puntosVida);
        System.out.println("Inventario: " + (inventario.isEmpty() ? "Vacío" : inventario));
    }

    public void bajarVida(int vida) {
        if (vida > 0) {
            puntosVida -= vida;
            if (puntosVida < 0) {
                puntosVida = 0; 
            }
            System.out.println(nombre + " ha recibido " + vida + " de daño. Vida restante: " + puntosVida);
        }
    }

    public void agregarEquipamiento(String equipamiento) {
        inventario.add(equipamiento);
        System.out.println("Se ha añadido " + equipamiento + " al inventario de " + nombre);
    }
}
