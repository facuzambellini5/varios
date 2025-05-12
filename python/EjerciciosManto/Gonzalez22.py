"""Hacer un algoritmo que permita ingresar N números y que luego calcule la suma y el promedio
de los números ingresados.
"""

num = 1
cant_num = 0
suma = 0

while num != 0:

    num = float(input("Ingrese un número por favor: "))

    if num != 0:
        cant_num += 1
        suma += num

promedio = suma / cant_num

print("La suma de todos los números es: ",suma,)
print("El promedio de los números ingresados es: ",promedio)



    





