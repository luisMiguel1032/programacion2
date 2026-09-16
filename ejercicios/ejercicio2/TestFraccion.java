package ejercicios;

/**
 * Programa de manejo de fracciones.
 *
 * @author Juan Perez
 * @version 1.1 03/03/2026
 */
public class TestFraccion {

    public static void main(String[] args) {
        // Objetos base
        Fraccion f1 = new Fraccion(1, 4);
        Fraccion f2 = new Fraccion(4, 3);

        System.out.println("--- Operaciones Base ---");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("suma = " + f1.suma(f2));
        System.out.println("resta = " + f1.resta(f2));

        System.out.println("\n--- a) Multiplicación ---");
        System.out.println("f1 * f2 = " + f1.multiplica(f2)); // 4/12

        System.out.println("\n--- b) División ---");
        System.out.println("f1 / f2 = " + f1.divide(f2)); // 3/16

        System.out.println("\n--- c) Convertir a Decimal ---");
        Fraccion fDec = new Fraccion(1, 2);
        System.out.println("Decimal de 1/2 = " + fDec.convertirADecimal()); // 0.5

        System.out.println("\n--- d) esInverso ---");
        Fraccion fInv = new Fraccion(4, 1);
        System.out.println("¿f2 es inverso de f1?: " + f1.esInverso(f2)); // false
        System.out.println("¿(4/1) es inverso de f1 (1/4)?: " + f1.esInverso(fInv)); // true

        System.out.println("\n--- e) parseFraccion ---");
        Fraccion parsed = Fraccion.parseFraccion("-2/3");
        System.out.println("Parse de '-2/3': " + parsed);
        System.out.println("parseFraccion(f1.toString()).equals(f1): " +
                Fraccion.parseFraccion(f1.toString()).equals(f1)); // true

        System.out.println("\n--- f) Simplificación ---");
        Fraccion s1 = new Fraccion(2, 8);
        Fraccion s2 = new Fraccion(14, 28);
        System.out.println("2/8 simplificado: " + s1.simplifica());   // 1/4
        System.out.println("14/28 simplificado: " + s2.simplifica()); // 1/2
    }
}