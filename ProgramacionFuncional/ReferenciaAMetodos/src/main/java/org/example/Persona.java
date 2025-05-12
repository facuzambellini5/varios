package org.example;

public class Persona {

  String nombre;
  double estadtura;

  public Persona() {
  }

  public Persona(String nombre, double estadtura) {
    this.nombre = nombre;
    this.estadtura = estadtura;
  }

  public void saludar() {
    System.out.println("Hola mi nombre es: " + nombre);
  }

  @Override
  public String toString() {
    return "Persona{" +
            "nombre='" + nombre + '\'' +
            ", estadtura=" + estadtura +
            '}';
  }
}
