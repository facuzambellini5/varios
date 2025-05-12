import math
#Ejercicio 5
#Diseñar una función que calcule el área y el perímetro de una circunferencia. Utiliza dicha función en
#un programa principal que lea el radio de una circunferencia y muestre su área y perímetro.


def calcularAreaPerimetro(radio):
    area = math.pi * radio ** 2
    perimetro = 2 * math.pi * radio
    return area, perimetro

radio = float(input("Ingrese el radio de la circunferencia: "))

area, perimetro = calcularAreaPerimetro(radio)
print(f"El area de la circunferencia es: {area:.2f} y el perimetro: {perimetro:.2f}")


