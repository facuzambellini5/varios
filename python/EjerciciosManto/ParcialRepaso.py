def CalcularPromedio(temperaturas):
    suma = 0
    cantidad = 0
    for i in temperaturas:
        cantidad += 1
        suma += i
    return suma / cantidad


def MenorTemperatura(fechas,momentos,temperaturas):
    menor = None
    indice = -1

    for i in temperaturas:
        indice += 1
        menor = i
        if i < menor:
            menor = i
    print(fechas[indice], momentos[indice], menor)

    
def ListadoTarde(fechas, momentos, temperaturas):
    indice = -1
    for i in momentos:
        indice += 1
        if i == 'T':
            print (fechas[indice], temperaturas[indice], momentos[indice])

    


fechas = []
temperaturas = []
momentos = []


while True:

    fecha = (input("Ingrese una fecha (solo puede contener 8 caracteres): "))

    if fecha == "":
        break

    if len(fecha) == 8:
        fechas.append(fecha)
        
    else:
        print("Fecha invalida, intente nuevamente.")
        continue


    temperatura = int(input("Ingrese una temperatura: "))
    temperaturas.append(temperatura)

    while True:
        momento = input("Ingrese un momento del día (M-T-N): ").upper()
        if momento == 'M':
            momentos.append(momento)
            break
        elif momento == 'T':
            momentos.append(momento)
            break
        elif momento == 'N':
            momentos.append(momento)
            break
        else:
            print("Incorrecto, intente nuevamente.")
            continue


while True:
    print("")
    print("""MENU
-------
        1. Promedio de todas las temperaturas.
        2. Fecha y momento de la menor temperatura registrada.
        3. Listado de fecha y temperatura de las observaciones que se hicieron en la tarde.
        4. Salir del programa""")
    print("")

    opcion = int(input("Elige una opcion: "))

    if opcion == 1:
        print("El promedio de todas las temperaturas es: ", CalcularPromedio(temperaturas))
    elif opcion == 2:
        MenorTemperatura(fechas,momentos,temperaturas)
    elif opcion == 3:
        ListadoTarde(fechas,momentos,temperaturas)
    elif opcion == 4:
        print("Saliendo del programa...")
        break
    else:
        print("Ingrese una opción válida.")





    

