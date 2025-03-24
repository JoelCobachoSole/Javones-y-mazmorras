package Javones_y_mazmorras;

public class Ladron extends Personaje {
    private boolean invisible;

    public Ladron(String nombre, int nivel, int puntosVida, String inventario) {
        super(nombre, nivel, puntosVida, inventario);
        this.invisible = false;
    }

    public void robar() {
        if (invisible) {
            System.out.println(getNombre() + " roba en sigilo mientras está invisible.");
        } else {
            System.out.println(getNombre() + " roba abiertamente.");
        }
    }

    public void hacerseInvisible() {
        invisible = !invisible;
        if (invisible) {
            System.out.println(getNombre() + " ahora está invisible.");
        } else {
            System.out.println(getNombre() + " ha dejado de ser invisible.");
        }
    }

    public boolean estaInvisible() {
        return invisible;
    }

    @Override
    public void interactuar(Personaje otro) {
        if (otro instanceof Guerrero) {
            System.out.println(getNombre() + " se mueve sigilosamente alrededor de " + otro.getNombre() + ".");
        } else if (otro instanceof Mago) {
            System.out.println(getNombre() + " observa a " + otro.getNombre() + " y espera su oportunidad.");
        }
    }
}

