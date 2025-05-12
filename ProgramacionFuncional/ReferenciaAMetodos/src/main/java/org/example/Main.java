package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {

    // Referencia a un metodo estatico

    // int num -> String.valueOf(num); ejemplo lambda (faltaria la imlementacion de una interfaz
    // funcional)
    // String::valueOf;   Referencia a metodo

    Function<Integer, String> convertidor = String::valueOf;
    String resultado = convertidor.apply(10);
    System.out.println(resultado);

    //Referencia a un metodo de instancia de un objeto.
    Persona persona = new Persona();
    persona.nombre = "pepe";

    Runnable saludo = persona::saludar; //uso de la interface runnable
    saludo.run(); //ejecutar el hilo de runnable

    //Function -> un parametro de entrada y otro de salida
    //Runnable -> solo ejecuta


    //Referencia a un constructor

    BiFunction<String, Double, Persona> crearPersona = Persona::new;  //Recibe 2 tipos de parametros.
    Persona persona1 = crearPersona.apply("pepe",1.87);

    System.out.println("La persona es: " + persona1.toString());





  //Referencia a un metodo de instancia de un objeto arbitrario.

  List<Persona> personas = new ArrayList<>();
  personas.add(new Empleado());
  personas.add(new Gerente());
  personas.add(new Empleado());

  personas.forEach(Persona::saludar);


  }
}
