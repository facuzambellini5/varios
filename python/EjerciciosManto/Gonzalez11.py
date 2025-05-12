"""11. Escribir un programa que lea las longitudes de los dos lados perpendiculares de un triángulo
rectángulo y calcule el área y el perímetro del triangulo. Usar el teorema de Pitágoras para calcular
la longitud del tercer lado.
"""
import math

def calc_area (lado1, lado2):
    return (lado1 * lado2) / 2

def calc_hipotenusa (lado1, lado2):
    return math.sqrt (lado1**2 + lado2**2)

def calc_perimetro(lado1, lado2, hipotenusa):
    return lado1 + lado2 + hipotenusa


lado1= float(input("Ingrese el lado 1 por favor: "))
lado2= float(input("Ingrese el lado 2 por favor: "))

area = calc_area(lado1,lado2)
hipotenusa = calc_hipotenusa(lado1,lado2)
perimetro = calc_perimetro(lado1,lado2,hipotenusa)

print("El área del triángulo es: ",area,)
print("La hipotenusa del triángulo es: ",hipotenusa) 
print("El perímetro del triángulo es: ",perimetro)


 


