package CRMclientes.defensa;

import java.util.Random;
import java.util.Scanner;

class Juego {
    protected int numeroDeVidas, vidasIniciales, record;

    public Juego(int vidas) {
        vidasIniciales = vidas;
        numeroDeVidas = vidas;
        record = 0;
    }

    public void reiniciaPartida() {
        numeroDeVidas = vidasIniciales;
    }

    public void actualizaRecord() {
        if (numeroDeVidas > record) record = numeroDeVidas;
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        return numeroDeVidas > 0;          
    }
}

class JuegoAdivinaNumero extends Juego {
    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int vidas) {
        super(vidas);
    }

    public void juega() {
        Scanner sc = new Scanner(System.in);
        reiniciaPartida();
        numeroAAdivinar = new Random().nextInt(11);    
        System.out.println("Adivina un número entre 0 y 10");
        while (true) {
            int n = sc.nextInt();
            if (n == numeroAAdivinar) {
                System.out.println("Acertaste!!");
                actualizaRecord();
                return;
            }
            if (quitaVida()) {
                System.out.println(numeroAAdivinar > n ? "Es mayor" : "Es menor");
                System.out.println("Inténtalo de nuevo");
            } else {
                System.out.println("Sin vidas. El número era " + numeroAAdivinar);
                return;
            }
        }
    }
}

public class Aplicacion {
    public static void main(String[] args) {
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(3);
        juego.juega();
    }
}