
import ucn.ArchivoEntrada;
import ucn.ArchivoSalida;
import ucn.Registro;

import java.io.IOException;

public class SistemaImpl implements Sistema{

    ListadoEstudiantes lista = new ListadoEstudiantes(100);

    public SistemaImpl() throws IOException {

        leerArchivo();
        escribirArchivo();
    }

    @Override
    public void leerArchivo() throws IOException {
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("Estudiantes.txt");

        while (!archivoEntrada.isEndFile()){

            Registro registro = archivoEntrada.getRegistro();
            String nombre = registro.getString();

            if (nombre != null){

                String rut = registro.getString();

                if (rut != null) {

                    double nota1 = registro.getDouble();

                    if (nota1 >= 1.0 && nota1 <= 7.0){

                        double nota2 = registro.getDouble();

                        if (nota2 >= 1.0 && nota2 <= 7.0){

                            double nota3 = registro.getDouble();

                            if (nota3 >= 1.0 && nota3 <= 7.0){

                                Estudiante estudiante = new Estudiante(nombre,rut,nota1,nota2,nota3);
                                lista.agregar(estudiante);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void escribirArchivo() throws IOException {

        ArchivoSalida archivoSalida = new ArchivoSalida("EstudiantesAprobados.txt");

        for (int i=0; i<(lista.getCantActual()); i++){

            Registro regSalida = new Registro(8);
            regSalida.agregarCampo(lista.buscar(i).getNombre());
            regSalida.agregarCampo(lista.buscar(i).getRut());
            regSalida.agregarCampo(lista.buscar(i).getNota1());
            regSalida.agregarCampo(lista.buscar(i).getNota2());
            regSalida.agregarCampo(lista.buscar(i).getNota3());
            regSalida.agregarCampo(lista.buscar(i).getPromedio());
            regSalida.agregarCampo(lista.buscar(i).getAprobado());
            archivoSalida.writeRegistro(regSalida);
        }

        archivoSalida.close();
    }
}
