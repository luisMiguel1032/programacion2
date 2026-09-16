package ejercicios;

public class TestAlgebraVectorial {
    public static void main(String[] args) {
        AlgebraVectorial a = new AlgebraVectorial(3, 0, 0);
        AlgebraVectorial b = new AlgebraVectorial(0, 4, 0);
        AlgebraVectorial c = new AlgebraVectorial(6, 0, 0);

        System.out.println("--- Perpendicularidad entre a y b ---");
        System.out.println("a) |a + b| == |a - b| : " + a.esPerpendicularA(b));
        System.out.println("b) |a - b| == |b - a| : " + a.esPerpendicularB(b));
        System.out.println("c) a . b == 0         : " + a.esPerpendicularC(b));
        System.out.println("d) |a+b|^2 == |a|^2+|b|^2 : " + a.esPerpendicularD(b));

        System.out.println("\n--- Paralelismo entre a y c ---");
        System.out.println("e) a == r * c : " + a.esParalelaE(c));
        System.out.println("f) a x c == 0 : " + a.esParalelaF(c));

        System.out.println("\n--- Proyección y Componente ---");
        System.out.println("Proy_b(a): " + a.proyeccion(b));
        System.out.println("Comp_b(a): " + a.componente(b));
    }
}