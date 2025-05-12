"""Escriba un programa que entregue todos los divisores del número entero ingresado:
Ingrese numero: 200
1 2 4 5 8 10 20 25 40 50 100 200
"""

num = int(input("Ingrese un número por favor:  "))

for i in range(1, num + 1):
    if num % i == 0:
        print(i, end=" ")