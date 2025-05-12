"""Hacer un algoritmo que muestre la tabla de multiplicar de un numero ingresado por el usuario.
Y que la muestre con el formato: A x B = C
"""

num = int (input("Ingrese un número: "))

for i in range (1,11):
    resultado = num*i
    print (num," X ",i," = ",resultado)