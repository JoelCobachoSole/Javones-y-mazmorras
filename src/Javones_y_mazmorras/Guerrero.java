package Javones_y_mazmorras;

public class Guerrero extends Personaje {
    private boolean protegiendo;
    private Personaje compañeroProtegido;

    public Guerrero(String nombre, int nivel, int puntosVida, String inventario) {
        super(nombre, nivel, puntosVida, inventario);
        this.protegiendo = false;
        this.compañeroProtegido = null;
    }

    public void proteger(Personaje compañero) {
        if (this.protegiendo) {
            System.out.println(this.getNombre() + " ya está protegiendo a otro personaje.");
        } else {
            this.protegiendo = true;
            this.compañeroProtegido = compañero;
            System.out.println(this.getNombre() + " ahora está protegiendo a " + compañero.getNombre() + ".");
        }
    }

    public void dejarDeProteger() {
        if (this.protegiendo) {
            System.out.println(this.getNombre() + " deja de proteger a " + this.compañeroProtegido.getNombre() + ".");
            this.protegiendo = false;
            this.compañeroProtegido = null;
        } else {
            System.out.println(this.getNombre() + " no está protegiendo a nadie.");
        }
    }

    public void setPuntosVida(int puntosVida) {
        if (this.protegiendo && this.compañeroProtegido != null) {
            System.out.println(this.getNombre() + " reduce el daño recibido en la mitad mientras protege a " + this.compañeroProtegido.getNombre() + ".");
            puntosVida /= 2;
        }
        super.setPuntosVida(puntosVida);
    }

    public Personaje estaProtegiendo() {
        return this.compañeroProtegido;
    }
}