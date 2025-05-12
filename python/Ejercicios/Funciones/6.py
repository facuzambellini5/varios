"""Ejercicio 6
Crear una función llamada “Login”, que recibe un nombre de usuario y una contraseña y te devuelve
Verdadero si el nombre de usuario es “usuario1” y la contraseña es “asdasd”. Además recibe el número
de intentos que se ha intentado hacer login y si no se ha podido hacer login incremente este valor.
Crear un programa principal donde se pida un nombre de usuario y una contraseña y se intente hacer
login, solamente tenemos tres oportunidades para intentarlo."""

def logeo(usuario,contrasena,intentos):
    if usuario == "usuario1" and contrasena == "asdasd":
        return True, intentos
    else:
        return False, intentos + 1
    
intentos = 0
max_intentos = 3

while intentos < max_intentos:
    usuario = input("Ingrese nombre usuario: ")
    contrasena= input("Ingrese la contraseña: ")

    es_correcto, intentos = logeo(usuario, contrasena, intentos)

    if es_correcto == True:
        print(f"Se ha logeado correctamente en {intentos} intentos.")
        break
    else:
        print (f"Incorrecto! Le quedan {max_intentos - intentos} intentos.")

if intentos == max_intentos:
    print("Lo siento, ha excedido el número de intentos.")

