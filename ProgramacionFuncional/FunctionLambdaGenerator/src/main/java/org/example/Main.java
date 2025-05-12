package org.example;

public class Main {
  public static void main(String[] args) {

    Multiplier doubleIt = (num) -> num * 2;
    Multiplier tripleIt = (num) -> num * 3;
    Multiplier quadrupleIt = (num) -> num * 4;
    Multiplier quintupleIt = (num) -> num * 5;

    int num = 15;

    System.out.println("El doble de " +num+" es: "+doubleIt.multiply(num));
    System.out.println("El triple de " +num+" es: "+tripleIt.multiply(num));
    System.out.println("El cuadruple de " +num+" es: "+quadrupleIt.multiply(num));
    System.out.println("El quintuple de " +num+" es: "+quintupleIt.multiply(num));
  }
}