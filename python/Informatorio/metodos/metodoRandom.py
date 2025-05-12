import random

def numero_random():
    return random.randint(1,100)

print("Bienvenido al generador de numeros aleatorios!")
respuesta = (input("Ingrese una letra para empezar S/N: "))

while respuesta.upper == 'S':
    numero = numero_random()
    print("El numero random es: ",numero)