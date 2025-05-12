caracter = input("Ingrese un caracter: ")

if caracter.isupper():
    print(caracter.isupper())
    print("El caracter esta en mayúsculas")
elif caracter.islower():
    print(caracter.islower())
    print("El caracter esta en minusculas")
elif caracter.isdigit():
    print(caracter,isdigit())
    print("El caracte es un numero")
else:
    print("El caracter es un caracter especial")


##                                      .upper()
## si se pone por ejemplo print(caracter.lower()) se transforma lo que pongamos automaticamente a lower o upper