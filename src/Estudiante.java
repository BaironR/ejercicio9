import ucn.StdOut;

import java.text.DecimalFormat;

public class Estudiante {

    private String nombre;
    private String rut;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudiante(String nombre, String rut, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.rut = rut;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public double getNota1() { return this.nota1; }

    public double getNota2() { return this.nota2; }

    public double getNota3() {
        return this.nota3;
    }

    public double getPromedio() { return (double)Math.round((this.nota1+this.nota2+this.nota3)/3*10d)/10d; }
    public String getAprobado(){

        double promedio = (this.nota1+this.nota2+this.nota3)/3;
        double promedioUnDecimal = (double)Math.round(promedio*10d)/10d;
        StdOut.println(promedioUnDecimal);

        if (promedioUnDecimal >= 4.0){

            return "Aprobado";
        }
        return "Reprobado";
    }
}
