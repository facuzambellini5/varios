package org.example;

public class Main {
  public static void main(String[] args) {

    // Clase Anónima
    Operador suma1 =
        new Operador() {
          @Override
          public int operar(int num1, int num2) {
            return num1 + num2;
          }
        };
    System.out.println("Suma desde clase anónima: " + suma1.operar(10, 20));

    Operador suma2 = (num1, num2) -> num1 + num2; // Integer::sum
    System.out.println("Suma desde lambda: " + suma2.operar(20, 20));
  }
}
