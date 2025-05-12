package org.example;

public class Main {
  public static void main(String[] args) {

    Adder add15 = (num) -> num + 15;
    double result = add15.add(40);

    System.out.println(result);


    Multiply multiply = (num1,num2) -> System.out.println(num1 + " * " + num2 + " = "+(num1*num2));
    multiply.multiply(12,12);

  }
}
