# Análisis de Caja Negra — Clase Empleado

## 1) Análisis de parámetros
| Parámetro | Dominio | Criterios de aceptación |
|---|---:|---|
| nombre | String | No nulo, no vacío, al menos dos palabras separadas por espacios. |
| cargo | Cargos.Cargo (enum) | Debe ser uno de los valores de Cargos.Cargo; no nulo. |
| salario | double | No NaN, no infinito, no negativo y >= Mensajes.SALARIO_MINIMO_CONVENIO (12000.0). |

## 2) Casos válidos
| Caso | nombre | cargo | salario | Resultado esperado |
|---:|---|---|---:|---|
| V1 | "Juan Pérez" | Cargos.Cargo.DESARROLLADOR | 12000.0 | Creación OK (salario == convenio) |
| V2 | "María de la Fuente" | Cargos.Cargo.DISENADORA | 45000.0 | Creación OK |
| V3 | "Ana María López" | Cargos.Cargo.GERENTE | 60000.0 | Creación OK |
| V4 | "Luis Gómez" (setter) | mantiene cargo válido | 20000.0 (setter) | setNombre/setSalario aplican sin excepción |
| V5 | "Nombre Largo Apellido" | Cargos.Cargo.DESARROLLADOR | Mensajes.SALARIO_MINIMO_CONVENIO + 0.01 | Creación OK |

## 3) Casos no válidos
| Caso | nombre | cargo | salario | Resultado esperado |
|---:|---|---|---:|---|
| N1 | null | válido | válido | IllegalArgumentException (nombre inválido) |
| N2 | "" (vacío) | válido | válido | IllegalArgumentException (nombre inválido) |
| N3 | "Juan" (una palabra) | válido | válido | IllegalArgumentException (nombre inválido) |
| N4 | válido | null | válido | IllegalArgumentException (cargo nulo) |
| N5 | válido | válido | -1000.0 (negativo) | IllegalArgumentException (salario inválido) |
| N6 | válido | válido | 1000.0 (< convenio) | IllegalArgumentException (salario por debajo del convenio) |
| N7 | válido | válido | Double.NaN | IllegalArgumentException (salario inválido) |
| N8 | intentar setNombre("Mono") | - | - | IllegalArgumentException (setter nombre) |
| N9 | intentar setSalario(Mensajes.SALARIO_MINIMO_CONVENIO - 0.1) | - | menor que convenio | IllegalArgumentException (setter salario) |

Notas:
- La excepción esperada para entradas inválidas es IllegalArgumentException con mensaje descriptivo.
- Los valores límite a probar: exactamente Mensajes.SALARIO_MINIMO_CONVENIO, justo por debajo y valores negativos/NaN/Inf.