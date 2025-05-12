archivo = []
piloto = []
equipo = []
posicion = []
total = []


def lector_archivo():
    texto = open("F1_2024.txt")
    for i in texto:
        archivo.append(i)
    
    for i in archivo:
        piloto.append(i[0:11])
        equipo.append(i[11:41])
        posicion.append(i[47:])
    

lector_archivo()

def menu(): 
    while True:
        print("""       
        Menu
        1. Listado con el total de puntos de cada piloto, ordenado de mayor a menor puntaje.
        2. Listado de puntos de cada equipo, ordenado de mayor a menor puntaje.
        3. Promedio de puntos de cada piloto
        4. Mejor posición obtenida por cada piloto en orden alfabético.
        0. Salir""")
        opcion = input("Elegir una opcion: ")
        if opcion == "1":
            print(piloto)
        elif opcion == "2":
            print("2")
        elif opcion == "3":
            print ("3")
        elif opcion == "4":
            print ("4")
        elif opcion == "0":
            print("Saliendo del programa...")
            break
        else: 
            print("Ingreso una opcion incorrecta, ingrese algunas de las opciones disponibles")
    return



# def opc_1 ():
#     #1. Listado con el total de puntos de cada piloto, ordenado de mayor a menor puntaje.
# tabla_puntos = {1: 25, 2: 18, 3: 15, 4: 12, 5: 10, 6: 8, 7: 6, 8: 4, 9: 2, 10: 1}
# puntos = 0
# for i in posicion:
#     if i in tabla_puntos:
#         puntos += tabla_puntos[i]



menu()
lector_archivo()
# try:
#     for linea in posicion:
#         linea = int(linea)
#         total += int(linea)
# except:
#         ValueError
# for i in piloto:
#     print (piloto[i],total[linea])