def CalcularMaxMin(numeros):
    max = 0
    min = None
    for num in numeros:
        if num > max:
            max = num
    
    for num in numeros:
        if num < min:
            min = num
    
    print("El mayor valor es: ",max,", y el menor: ",min)


numeros = []

while True:
    num = int(input("Ingrese un número, (0 para salir): "))

    if num == 0:
        break

    numeros.append(num)


print (numeros)
CalcularMaxMin(numeros)