lista = []

while True:

    num = int(input("Ingrese un numero: "))

    if num == 0:
        break

    lista.append(num)


print(sum(lista) / len(lista))
