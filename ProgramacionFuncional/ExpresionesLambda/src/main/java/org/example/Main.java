package org.example;

import org.example.logica.Mensajero;

public class Main {
  public static void main(String[] args) {

    // Expresion Lambda que usa la interfaz funcional y usa el unico metodo declarado en la misma.
    // No se "llama" literalmente al metodo, pero al haber SOLO UN metodo en la interfaz, java sabe
    // que se lo llama a ese metodo.
    Mensajero lambdaMsj =
        (nombre, edad) -> {
          System.out.println("Hola desde Lambda. Nombre: " + nombre);
          System.out.println("Su edad es: " + edad);
        };
    lambdaMsj.emitirMensaje("Facu", 22);
  }
}
