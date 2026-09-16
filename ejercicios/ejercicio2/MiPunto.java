

public class MiPunto {

    // a) Atributos x e y
    private double x;
    private double y;

    // b) Constructor sin argumentos (0, 0)
    public MiPunto() {
        this(0.0, 0.0);
    }

    // c) Constructor especificado
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // a) Métodos Getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // d) Distancia hasta un objeto tipo MiPunto
    public double distancia(MiPunto punto) {
        return distancia(punto.getX(), punto.getY());
    }

    // e) Distancia hasta las coordenadas x e y especificadas
    public double distancia(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}