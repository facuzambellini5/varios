#Ejercicio 4
#Crea una función “calcularMaxMin” que recibe una lista con valores numéricos y devuelve el valor
#máximo y el mínimo. Crea un programa que pida números por teclado y muestre el máximo y el
#mínimo, sin utilizar los métodos de listas.


def calcularMaxMin():
    menor = None
    mayor = 1
    for numero in numeros:
        if numero > mayor:
            mayor = numero

    for numero in numeros:
        if menor is None:
            menor = numero
        elif numero < menor:
            menor = numero

    return print("El número mayor es: ",mayor," y el menor: ", menor)

numeros = []

while True:
    num = int(input("Ingrese un número: "))
    if num == 0:
        break
    numeros.append(num)

print(calcularMaxMin())





