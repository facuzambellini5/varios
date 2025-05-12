package org.example;

public class Main {
  public static void main(String[] args) {

    // perro esta implementando la interfaz Animal y al mismo tiempo la clase anonima esta
    // sobreescribiendo ese metodo hacerSonido
    Animal perro = new Animal() {
          @Override
          public void hacerSonido() {
            System.out.println("Soy un perro y estoy ladrando.");
          }
        };
    perro.hacerSonido();

    // Clase anonima que usa herencia e implementa sus propios atributos y metodos.
    // todolo que esta entre las llaves representa un OBJETO
    new Vehiculo() {
      private int numPuertas;

      public void acelerar() {
        System.out.println("Soy un auto y estoy acelerando.");
      }
    }.acelerar();
  }
}
