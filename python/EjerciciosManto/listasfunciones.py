def CalcularPromedio(notas):
    suma = 0
    cantidad = 0
    for nota in notas:
        cantidad += 1
        suma += nota
    
    return suma / cantidad


def PorcentajeAprobados(notas):
    aprobados = 0
    cantidad = 0
    for i in notas:
        cantidad += 1
        if i >= 6:
            aprobados += 1
    return (aprobados / cantidad) * 100


def PorcentajeDesaprobados(notas):
    desaprobados = 0
    cantidad = 0
    for i in notas:
        cantidad += 1
        if i < 6:
            desaprobados += 1
    return (desaprobados / cantidad) * 100


def ListaAprobados(nombres,notas):
    cantidad = 0
    for i in notas:
        cantidad += 1

    for i in range(cantidad):
        if notas[i] >= 6:
            print(nombres[i],": ",notas[i])


def ListaDesaprobados(nombres, notas):
    cantidad = 0
    for i in notas:
        cantidad += 1

    for i in range(cantidad):
        if notas[i] < 6:
            print(nombres[i],": ",notas[i])

        
nombres = []
notas = []

while True:
    
    nombre = input("Ingrese un nombre: ")
    
    if nombre == "":
        break

    nombres.append(nombre)

    while True:
        nota = int (input("Ingrese una nota (0 - 10):"))
        if nota > 0 and nota < 11:
            notas.append(nota)
            break
        else:
            print("Valor incorrecto, vuelve a intentar por favor.")
            continue
print("""          MENU
      -----------
      1: Promedio de notas
      2: Porcentaje de aprobados
      3: Porcentade de desaprobados
      4: Listado de nombres y notas aprobados
      5: Listado de nombres y notas desaprobados
      0: Salir""")

while True:
    opcion = input("Ingrese una opción: ")
    if opcion == "1":
        print(f"El promedio de las notas es: {CalcularPromedio(notas)}")
        break
    elif opcion == "2":
        print(f"El porcentaje de aprobados es: {PorcentajeAprobados(notas)}%")
        break
    elif opcion == "3":
        print(f"El porcentaje de desaprobados es: {PorcentajeDesaprobados(notas)}%")
        break
    elif opcion == "4":
        print("La lista de aprobados es:")
        ListaAprobados(nombres,notas)
        break
    elif opcion == "5":
        print("La lista de desaprobados es:")
        ListaDesaprobados(nombres, notas)
        break
    elif opcion == "0":
        print("Saliendo del programa...")
        break
    else:
        print("Incorrecto!")
        
    



     


    