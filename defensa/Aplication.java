
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
        return numeroDeVidas > 0;          // true: aún le quedan vidas
    }
}

class JuegoAdivinaNumero extends Juego {
    private int numeroAAdivinar;

    public JuegoAdivinaNumero(int vidas) {
        super(vidas);
    }

    public boolean validaNumero(int n) {
        if (n >= 0 && n <= 10) return true;
        System.out.println("Error: el número debe estar entre 0 y 10");
        return false;
    }

    public void juega() {
        Scanner sc = new Scanner(System.in);
        reiniciaPartida();
        numeroAAdivinar = new Random().nextInt(11);          // de 0 a 10
        System.out.println("Adivina un número entre 0 y 10");
        while (true) {
            int n = sc.nextInt();
            if (!validaNumero(n)) continue;        // no válido: no pierde vida
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

class JuegoAdivinaPar extends JuegoAdivinaNumero {
    public JuegoAdivinaPar(int vidas) {
        super(vidas);
    }

    @Override
    public boolean validaNumero(int n) {
        if (!super.validaNumero(n)) return false;      // fuera de 0 a 10
        if (n % 2 != 0) {
            System.out.println("Error: el número debe ser par");
            return false;
        }
        return true;
    }
}

class JuegoAdivinaImpar extends JuegoAdivinaNumero {
    public JuegoAdivinaImpar(int vidas) {
        super(vidas);
    }

    @Override
    public boolean validaNumero(int n) {
        if (!super.validaNumero(n)) return false;
        if (n % 2 == 0) {
            System.out.println("Error: el número debe ser impar");
            return false;
        }
        return true;
    }
}

public class Aplication {
    public static void main(String[] args) {
        JuegoAdivinaNumero j1 = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar j2 = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar j3 = new JuegoAdivinaImpar(3);

        j1.juega();
        j2.juega();
        j3.juega();
    }
}