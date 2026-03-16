package lib.parcial2;

/**
 * Contenedor para los cargos profesionales disponibles en la empresa.
 *
 * <p>Incluye un método utilitario {@link Cargo#fromLabel(String)} para convertir
 * etiquetas a valores del enum.</p>
 */
public class Cargos {
    /**
     * Enum con los cargos soportados y su etiqueta legible.
     */
    public enum Cargo {
        DESARROLLADOR("Desarrollador"),
        DISENADORA("Diseñadora"),
        GERENTE("Gerente");

        private final String label;

        Cargo(String label) {
            this.label = label;
        }

        /**
         * Etiqueta legible del cargo.
         *
         * @return etiqueta (p. ej. "Desarrollador")
         */
        public String getLabel() {
            return label;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return label;
        }

        /**
         * Convierte una etiqueta a un valor del enum.
         *
         * @param label etiqueta a convertir (no nula)
         * @return valor {@link Cargo} correspondiente
         * @throws IllegalArgumentException si label es null o no coincide con ningún cargo
         */
        public static Cargo fromLabel(String label) {
            if (label == null) throw new IllegalArgumentException(Mensajes.LABEL_NULL);
            for (Cargo c : values()) {
                if (c.label.equalsIgnoreCase(label) || c.name().equalsIgnoreCase(label)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(Mensajes.CARGO_DESCONOCIDO_PREFIX + label);
        }
    }

    /**
     * Devuelve la lista de cargos disponibles.
     *
     * @return array con los valores del enum {@link Cargo}
     */
    public static Cargo[] lista() {
        return Cargo.values();
    }
}