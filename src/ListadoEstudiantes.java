public class ListadoEstudiantes {

    private Estudiante[] lista;
    private int cantMax;
    private int cantActual;

    public ListadoEstudiantes(int cantMax) {
        this.cantMax = cantMax;
        this.lista = new Estudiante[cantMax];
        cantActual = 0;
    }

    public void agregar(Estudiante e){

        if (cantActual == cantMax){
            return;
        }

        this.lista[cantActual] = e;
        cantActual++;
    }

    public Estudiante buscar(int pos){

        Estudiante e = this.lista[pos];
        return e;
    }

    public int getCantActual() { return cantActual; }
}
