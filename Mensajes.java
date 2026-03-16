package lib.parcial2;

/**
 * Contiene constantes de mensajes y valores "mágicos" usados en la aplicación.
 *
 * <p>Centralizar cadenas y números facilita traducción y mantenimiento.</p>
 */
public final class Mensajes {
    private Mensajes() {}

    /** Mensaje que solicita el porcentaje de aumento por consola. */
    public static final String PROMPT_PORCENTAJE = "Introduzca el porcentaje de aumento de salario: ";

    /** Título mostrado antes del listado de empleados. */
    public static final String LISTA_EMPLEADOS_TITULO = "Lista de Empleados:";

    /** Texto para cargo no disponible en toString. */
    public static final String CARGO_NO_DISPONIBLE = "N/A";

    // Textos internos / excepciones

    /** Mensaje usado cuando se pasa un label null a fromLabel. */
    public static final String LABEL_NULL = "Label null";

    /** Prefijo de mensaje cuando se desconoce un cargo. */
    public static final String CARGO_DESCONOCIDO_PREFIX = "Cargo desconocido: ";

    /** Mensaje utilizado cuando el nombre no cumple las reglas. */
    public static final String NOMBRE_INVALIDO = "Nombre inválido: debe tener al menos dos palabras";

    /** Mensaje para cargo nulo. */
    public static final String CARGO_NULO = "Cargo nulo";

    /** Mensaje base para salario inválido. */
    public static final String SALARIO_INVALIDO = "Salario inválido";

    /** Prefijo de mensaje cuando el salario está por debajo del convenio. */
    public static final String SALARIO_DEBAJO_CONVENIO_PREFIX = "Salario por debajo del convenio: ";

    // Textos usados en toString de Empleado

    /** Prefijo de la representación en texto de Empleado. */
    public static final String EMPLEADO_PREFIX = "Empleado{";

    /** Etiqueta para nombre en toString. */
    public static final String EMPLEADO_NOMBRE_LABEL = "nombre='";

    /** Etiqueta para cargo en toString. */
    public static final String EMPLEADO_CARGO_LABEL = ", cargo='";

    /** Etiqueta para salario en toString. */
    public static final String EMPLEADO_SALARIO_LABEL = ", salario=";

    /** Sufijo de la representación en texto de Empleado. */
    public static final String EMPLEADO_SUFFIX = "}";

    // Números "mágicos"

    /** Capacidad inicial por defecto usada en la aplicación. */
    public static final int DEFAULT_INITIAL_CAPACITY = 3;

    /** Multiplicador usado al redimensionar el array de empleados. */
    public static final int RESIZE_MULTIPLIER = 2;

    /** Adición fija usada al redimensionar el array de empleados. */
    public static final int RESIZE_ADDITION = 1;

    /** Convenio salarial (mínimo permitido). */
    public static final double SALARIO_MINIMO_CONVENIO = 12000.0;
}