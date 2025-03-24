package Javones_y_mazmorras;

public class Mago extends Personaje{
	
	private double mana;
	
	public Mago(String nombre, int nivel, int puntosVida, String inventario,double mana) {
		super(nombre, nivel, puntosVida, inventario);
		this.mana = mana;
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = mana;
	}
	
    public void lanzarHechizo() {
        double costoMana = 20; 
        if (mana >= costoMana) {
            mana -= costoMana;
            System.out.println(getNombre() + " ha lanzado un hechizo. Mana restante: " + mana);
        } else {
            System.out.println(getNombre() + " no tiene suficiente mana para lanzar el hechizo.");
        }
    }

    public void recargarMana() {
        double cantidadRecarga = 30; 
        mana += cantidadRecarga;
        System.out.println(getNombre() + " ha recargado mana. Mana actual: " + mana);
    }
}
