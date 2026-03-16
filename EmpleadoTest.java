package lib.parcial2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios de la clase {@link Empleado} según el análisis de caja negra.
 */
public class EmpleadoTest {

    /** Caso válido: creación con salario igual al convenio. */
    @Test
    void crearEmpleado_valido_salarioConvenio_noLanza() {
        assertDoesNotThrow(() -> {
            Empleado e = new Empleado("Juan Pérez", Cargos.Cargo.DESARROLLADOR, Mensajes.SALARIO_MINIMO_CONVENIO);
            assertEquals("Juan Pérez", e.getNombre());
            assertEquals(Cargos.Cargo.DESARROLLADOR, e.getCargo());
            assertEquals(Mensajes.SALARIO_MINIMO_CONVENIO, e.getSalario());
        });
    }

    /** Caso válido: nombre con varias palabras. */
    @Test
    void crearEmpleado_valido_nombresMultiples_noLanza() {
        assertDoesNotThrow(() -> new Empleado("María de la Fuente", Cargos.Cargo.DISENADORA, 45000.0));
    }

    /** Caso válido adicional. */
    @Test
    void crearEmpleado_valido_tercerCaso_noLanza() {
        assertDoesNotThrow(() -> new Empleado("Ana María López", Cargos.Cargo.GERENTE, 60000.0));
    }

    /** Verifica setters válidos. */
    @Test
    void setters_validos_aplicanCambios() {
        Empleado e = new Empleado("Ana López", Cargos.Cargo.GERENTE, 20000.0);
        assertDoesNotThrow(() -> e.setNombre("Ana María López"));
        assertEquals("Ana María López", e.getNombre());
        assertDoesNotThrow(() -> e.setSalario(25000.0));
        assertEquals(25000.0, e.getSalario());
        assertDoesNotThrow(() -> e.setCargo(Cargos.Cargo.DESARROLLADOR));
        assertEquals(Cargos.Cargo.DESARROLLADOR, e.getCargo());
    }

    // ----- Casos no válidos -----

    /** Nombre nulo al crear debe lanzar IllegalArgumentException. */
    @Test
    void crearEmpleado_nombreNull_lanza() {
        assertThrows(IllegalArgumentException.class, () ->
                new Empleado(null, Cargos.Cargo.DESARROLLADOR, 20000.0));
    }

    /** Nombre vacío al crear debe lanzar IllegalArgumentException. */
    @Test
    void crearEmpleado_nombreVacio_lanza() {
        assertThrows(IllegalArgumentException.class, () ->
                new Empleado("", Cargos.Cargo.DISENADORA, 20000.0));
    }

    /** Nombre con una sola palabra al crear debe lanzar IllegalArgumentException. */
    @Test
    void crearEmpleado_nombreUnaPalabra_lanza() {
        assertThrows(IllegalArgumentException.class, () ->
                new Empleado("Juan", Cargos.Cargo.GERENTE, 30000.0));
    }

    /** Cargo nulo al crear debe lanzar IllegalArgumentException. */
    @Test
    void crearEmpleado_cargoNull_lanza() {
        assertThrows(IllegalArgumentException.class, () ->
                new Empleado("Luis Gomez", null, 30000.0));
    }

    /** Salario negativo al crear debe lanzar IllegalArgumentException. */
    @Test
    void crearEmpleado_salarioNegativo_lanza() {
        assertThrows(IllegalArgumentException.class, () ->
                new Empleado("Luis Gomez", Cargos.Cargo.DESARROLLADOR, -1.0));
    }

    /** Salario por debajo del convenio al crear debe lanzar IllegalArgumentException. */
    @Test
    void crearEmpleado_salarioDebajoConvenio_lanza() {
        double menor = Mensajes.SALARIO_MINIMO_CONVENIO - 1.0;
        assertThrows(IllegalArgumentException.class, () ->
                new Empleado("Laura Ruiz", Cargos.Cargo.DISENADORA, menor));
    }

    /** Salario NaN al crear debe lanzar IllegalArgumentException. */
    @Test
    void crearEmpleado_salarioNaN_lanza() {
        assertThrows(IllegalArgumentException.class, () ->
                new Empleado("Pedro Alonso", Cargos.Cargo.GERENTE, Double.NaN));
    }

    /** setNombre inválido debe lanzar IllegalArgumentException. */
    @Test
    void setNombre_invalido_lanza() {
        Empleado e = new Empleado("María Pérez", Cargos.Cargo.DESARROLLADOR, 20000.0);
        assertThrows(IllegalArgumentException.class, () -> e.setNombre("Mononombre"));
        assertThrows(IllegalArgumentException.class, () -> e.setNombre(""));
        assertThrows(IllegalArgumentException.class, () -> e.setNombre(null));
    }

    /** setSalario inválido debe lanzar IllegalArgumentException. */
    @Test
    void setSalario_invalido_lanza() {
        Empleado e = new Empleado("María Pérez", Cargos.Cargo.DESARROLLADOR, 20000.0);
        assertThrows(IllegalArgumentException.class, () -> e.setSalario(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> e.setSalario(-500.0));
        double menor = Mensajes.SALARIO_MINIMO_CONVENIO - 0.1;
        assertThrows(IllegalArgumentException.class, () -> e.setSalario(menor));
    }

    /** setCargo nulo debe lanzar IllegalArgumentException. */
    @Test
    void setCargo_null_lanza() {
        Empleado e = new Empleado("Ana Gómez", Cargos.Cargo.GERENTE, 30000.0);
        assertThrows(IllegalArgumentException.class, () -> e.setCargo(null));
    }
}