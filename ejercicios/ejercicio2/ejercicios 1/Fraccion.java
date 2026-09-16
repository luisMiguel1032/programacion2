
 class Fraccion {

    // Atributos
    private int numerador;
    private int denominador;

    // Constructores
    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion(int n, int d) {
        this.numerador = n;
        this.denominador = d;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fraccion) {
            Fraccion f1 = this.simplifica();
            Fraccion f2 = ((Fraccion) o).simplifica();
            return f1.numerador == f2.numerador && f1.denominador == f2.denominador;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.numerador, this.denominador);
    }

    public Fraccion suma(Fraccion o) {
        int n = (this.numerador * o.denominador) + (this.denominador * o.numerador);
        int d = this.denominador * o.denominador;
        return new Fraccion(n, d);
    }

    public Fraccion resta(Fraccion o) {
        Fraccion c = new Fraccion();
        c.numerador = (this.numerador * o.denominador) - (this.denominador * o.numerador);
        c.denominador = this.denominador * o.denominador;
        return c;
    }

    // a) Multiplicación de dos fracciones: (a/b) * (c/d)
    public Fraccion multiplica(Fraccion o) {
        int n = this.numerador * o.numerador;
        int d = this.denominador * o.denominador;
        return new Fraccion(n, d);
    }

    // b) División de dos fracciones: (a/b) / (c/d)
    public Fraccion divide(Fraccion o) {
        if (o.numerador == 0) {
            throw new ArithmeticException("No se puede dividir entre una fracción con numerador 0.");
        }
        int n = this.numerador * o.denominador;
        int d = this.denominador * o.numerador;
        return new Fraccion(n, d);
    }

    // c) Convertir a Decimal con validación de división entre 0
    public double convertirADecimal() {
        if (this.denominador == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return (double) this.numerador / this.denominador;
    }

    // d) Comprobar si esta fracción es inversa a otra (usando multiplica)
    public boolean esInverso(Fraccion o) {
        Fraccion producto = this.multiplica(o);
        return producto.numerador == producto.denominador && producto.denominador != 0;
    }

    // e) Método estático para convertir cadena "a/b" en objeto Fraccion
    public static Fraccion parseFraccion(String str) {
        String[] partes = str.split("/");
        if (partes.length != 2) {
            throw new IllegalArgumentException("Formato no válido. Debe ser 'numerador/denominador'");
        }
        int n = Integer.parseInt(partes[0].trim());
        int d = Integer.parseInt(partes[1].trim());
        return new Fraccion(n, d);
    }

    // f) Simplifica la fracción utilizando el Máximo Común Divisor (MCD)
    public Fraccion simplifica() {
        if (this.denominador == 0) {
            return new Fraccion(this.numerador, 0);
        }
        int mcd = mcd(Math.abs(this.numerador), Math.abs(this.denominador));
        if (mcd == 0) {
            return new Fraccion(this.numerador, this.denominador);
        }
        int n = this.numerador / mcd;
        int d = this.denominador / mcd;

        // Mantener el signo negativo en el numerador si corresponde
        if (d < 0) {
            n = -n;
            d = -d;
        }
        return new Fraccion(n, d);
    }

    // Método auxiliar privado para calcular MCD (Algoritmo de Euclides)
    private int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }
}