import random
secretNumber = random.randint(0,100)
intentos = 0


while True:
    number = input("Ingrese un número: ")
    if not number.isdigit:
        print("Ingrese un número válido por favor")
        continue
    number = int (number)
    intentos += 1

    if number > secretNumber:
        print("El número secreto es menor")
    elif number < secretNumber:
        print ("El número secreto es mayor")
    else:
        print("Felicidades has adivinado el número ",secretNumber," en ",intentos," intentos.")
        break
print("Muchas gracias por jugar! Nos vemos la próxima!!")