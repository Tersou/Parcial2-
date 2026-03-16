package lib.parcial2;

/**
 * Representa un empleado de la empresa con nombre, cargo y salario.
 *
 * <p>La clase expone getters y setters para sus atributos y un {@link #toString()}
 * que formatea la información usando constantes definidas en {@link Mensajes}.</p>
 */
class Empleado {
    private String nombre;
    private Cargos.Cargo cargo;
    private double salario;

    /**
     * Crea un nuevo empleado.
     *
     * @param nombre  nombre completo del empleado
     * @param cargo   cargo profesional (enum {@link Cargos.Cargo})
     * @param salario salario anual del empleado
     */
    public Empleado(String nombre, Cargos.Cargo cargo, double salario) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    /**
     * Devuelve el nombre del empleado.
     *
     * @return nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre nuevo nombre completo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el cargo del empleado.
     *
     * @return cargo (enum {@link Cargos.Cargo})
     */
    public Cargos.Cargo getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado.
     *
     * @param cargo nuevo cargo (no nulo)
     */
    public void setCargo(Cargos.Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * Devuelve el salario del empleado.
     *
     * @return salario anual
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     *
     * @param salario nuevo salario anual
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Representación textual del empleado.
     *
     * @return cadena con nombre, cargo y salario
     */
    @Override
    public String toString() {
        return Mensajes.EMPLEADO_PREFIX +
                Mensajes.EMPLEADO_NOMBRE_LABEL + nombre + '\'' +
                Mensajes.EMPLEADO_CARGO_LABEL + (cargo != null ? cargo.getLabel() : Mensajes.CARGO_NO_DISPONIBLE) + '\'' +
                Mensajes.EMPLEADO_SALARIO_LABEL + salario +
                Mensajes.EMPLEADO_SUFFIX;
    }
}
