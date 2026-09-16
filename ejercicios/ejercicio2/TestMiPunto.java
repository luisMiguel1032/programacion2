
public class TestMiPunto {
    public static void main(String[] args) {
        // Crear puntos (0, 0) y (10, 30.5)
        MiPunto p1 = new MiPunto();
        MiPunto p2 = new MiPunto(10, 30.5);

        // Mostrar distancia entre ellos
        System.out.println("Punto 1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Punto 2: (" + p2.getX() + ", " + p2.getY() + ")");
        
        System.out.println("\nDistancia usando objeto MiPunto: " + p1.distancia(p2));
        System.out.println("Distancia usando coordenadas (x, y): " + p1.distancia(10, 30.5));
    }
}