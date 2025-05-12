def PorcentajeSatisfactorio(puntajes):
    satisfactorios = 0
    cantidad = 0
    for i in puntajes:
        cantidad += 1
        if i >= 6:
            satisfactorios += 1

    return (satisfactorios / cantidad) * 100

def PromedioPuntajes(puntajes):
    suma = 0
    cantidad = 0
    for i in puntajes:
        suma += i
        cantidad += 1

    return suma / cantidad

def ListadoPuntajeBajo(empleados, puntajes):
    indice = -1
    for i in puntajes:
        indice += 1
        if i < 6:
            print (empleados[indice],": ", puntajes[indice])


empleados = []
puntajes = []

while True:
    empleado = input("Ingrese el nombre del empleado: ")
    if empleado == "":
        break
    empleados.append(empleado)

    while True:
        puntaje = int(input("Ingrese el puntaje del empleado(1-10): "))
        if puntaje > 0 and puntaje < 11:
            puntajes.append(puntaje)
            break
        else:
            print("Valor incorrecto, intente nuevamente.")

while True:
    print("""
    MENU:
    ------------
    1. Porcentaje de empleados con desempeño satisfactorio.
    2. Promedio de puntajes.
    3. Listado de nombre y puntaje con desempeño bajo.
    0. Salir del programa.
      """)
    opcion = int(input("Elija una opción: "))

    if opcion == 1:
        print("El porcentaje de empleados con buen desempeño es: ",PorcentajeSatisfactorio(puntajes),"%")
    elif opcion == 2:
        print("El promedio de puntajes es: ",PromedioPuntajes(puntajes))
    elif opcion == 3:
        ListadoPuntajeBajo(empleados, puntajes)
    elif opcion == 0:
        print("Saliendo del programa...")
        break
    else:
        print("Ingrese una opcion válida.")


