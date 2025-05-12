from modulos_calculadora import suma, resta, division, multiplicacion, potencia

def calculadora():

    opcion = int (input("Ingrese una opcion"))

    if opcion == '1':
        suma()
    elif opcion == '2':
        resta()
    elif opcion == '3':
        division()
    elif opcion == '4':
        multiplicacion()
    elif opcion == '5':
        potencia()