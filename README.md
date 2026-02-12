## pedidoRestaurante
# 📦 Sistema de Gestión de Pedidos - DAM

# 📝 Descripción
Este proyecto es una aplicación de consola desarrollada en Java que permite gestionar pedidos de una tienda. Aplica los conceptos fundamentales de la Programación Orientada a Objetos (POO) y el patrón **Modelo-Vista-Controlador (MVC)**.

**Características principales:**
* **Validación robusta:** Uso de Expresiones Regulares (Regex) para validar DNI, Email y Teléfono en la clase `Clientes`.
* **Gestión dinámica:** Uso de `ArrayList` en el controlador para administrar múltiples pedidos.
* **Control de errores:** Implementación de excepciones `IllegalArgumentException` para asegurar la integridad de los datos.

## 🚀 Cómo ejecutar el programa

Sigue estos pasos para probar la aplicación en tu equipo:

1. **Requisitos:** Asegúrate de tener instalado el JDK (Java Development Kit) 17 o superior.
2. **Clonar o descargar:** Descarga este repositorio en tu ordenador.
3. **Compilar:** Abre una terminal en la carpeta raíz del proyecto y compila las clases:
   ```bash
   javac -d bin src/**/*.java
