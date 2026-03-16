package lib.parcial2;

/**
 * Gestión colectiva de empleados: mantiene una lista dinámica interna,
 * permite dar de alta empleados, aumentar salarios y mostrar el listado.
 *
 * <p>Nota: la capacidad inicial se pasa al constructor y el array se expande
 * automáticamente cuando es necesario.</p>
 */
class Empleados {
    private Empleado[] lista;
    private int size = 0;

    /**
     * Constructor con capacidad inicial.
     *
     * @param capacidad capacidad inicial del array interno
     */
    public Empleados(int capacidad) {
        this.lista = new Empleado[capacidad];
    }

    /**
     * Da de alta (añade) un empleado al conjunto.
     * Si la capacidad se agota, el array se redimensiona automáticamente.
     *
     * @param e empleado a añadir (no nulo)
     */
    public void altaEmpleado(Empleado e) {
        if (size >= lista.length) {
            Empleado[] nuevo = new Empleado[lista.length * Mensajes.RESIZE_MULTIPLIER + Mensajes.RESIZE_ADDITION];
            System.arraycopy(lista, 0, nuevo, 0, lista.length);
            lista = nuevo;
        }
        lista[size++] = e;
    }

    /**
     * Aumenta el salario de todos los empleados dados de alta en el porcentaje indicado.
     *
     * @param porcentaje porcentaje de aumento (por ejemplo 10 para +10%)
     */
    public void aumentarSalario(double porcentaje) {
        for (int i = 0; i < size; i++) {
            Empleado emp = lista[i];
            double nuevoSalario = emp.getSalario() * (1 + porcentaje / 100);
            emp.setSalario(nuevoSalario);
        }
    }

    /**
     * Muestra por salida estándar el listado de empleados actualmente dados de alta.
     */
    public void mostrarListado() {
        for (int i = 0; i < size; i++) {
            System.out.println(lista[i]);
        }
    }

    /**
     * Devuelve una copia del array con los empleados actualmente dados de alta.
     *
     * @return array con los empleados (tamaño = número de empleados)
     */
    public Empleado[] getLista() {
        Empleado[] actual = new Empleado[size];
        System.arraycopy(lista, 0, actual, 0, size);
        return actual;
    }
}