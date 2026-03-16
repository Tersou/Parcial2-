package lib.parcial2;
import java.util.Scanner;

/**
 * Aplicación principal que demuestra el uso de las clases de gestión de empleados.
 *
 * <p>El método {@link #main(String[])} crea una instancia de {@link Empleados},
 * da de alta varios empleados, solicita un porcentaje y muestra el listado.</p>
 */
public class SistemaGestionEmpleados {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        Empleados empleados = new Empleados(Mensajes.DEFAULT_INITIAL_CAPACITY);

        // Dar de alta los tres empleados usando los cargos tipados
        empleados.altaEmpleado(new Empleado("Juan", Cargos.Cargo.DESARROLLADOR, 50000));
        empleados.altaEmpleado(new Empleado("María", Cargos.Cargo.DISENADORA, 45000));
        empleados.altaEmpleado(new Empleado("Pedro", Cargos.Cargo.GERENTE, 60000));

        Scanner scanner = new Scanner(System.in);
        System.out.print(Mensajes.PROMPT_PORCENTAJE);
        double porcentaje = scanner.nextDouble();

        empleados.aumentarSalario(porcentaje);

        System.out.println(Mensajes.LISTA_EMPLEADOS_TITULO);
        empleados.mostrarListado();

        scanner.close();
    }
}
