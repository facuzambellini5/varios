def ListadoTotalPuntos(archivo):
    with open(archivo, 'r') as archivo:
        lineas = archivo.readlines()
        resultados = []
        for linea in lineas[1:]:                # recorremos cada piloto(linea)
            datos = linea.strip().split()
            pilotos = datos[0]
            posiciones = datos[-21:]
            posiciones_int = []
            puntaje = []
            
            

            #con este for recorremos las lineas de posiciones para convertirlas a int
            for posicion in posiciones:
                posiciones_int.append(int(posicion))

            
            for i in range(len(posiciones_int)): #recorre lacantidad de elementos (tamaño) de la lista
                posicion = posiciones_int[i]     #declaramos una variable que adopta el valor de cada elemento que recorre el indice i
                if posicion in tabla_puntos:     #verificamos que la posicion este dentro de la tabla de puntajes
                    posiciones_int[i] = tabla_puntos[posicion] #Sobreescribimos el valor de la lista posiciones_int del indie [i] por el puntaje (tabla_puntaje)
                    if posiciones_int[i] != 0:
                        puntaje.append(tabla_puntos[posicion])                                            
                else:
                    posiciones_int[i] = 0
            

            suma = 0
            for i in puntaje: # sumamos el total de puntajes
                suma += i       

            resultados.append((pilotos, suma))
            

        n = len(resultados)
        for i in range(n):
            for j in range(0, n-i-1):
                if resultados[j][1] < resultados[j+1][1]:
                    resultados[j], resultados[j+1] = resultados[j+1], resultados[j]
        for pilotos, suma in resultados:
            print(pilotos,": ", suma)
            
        
    
def ListadoPuntosEquipos(archivo):
    with open(archivo, 'r') as archivo:
        lineas = archivo.readlines()
        equipos = {}

        for linea in lineas[1:]:
            nombre_equipo = linea[12:40].strip()
            posiciones = linea[-21:].split()
            posiciones 



tabla_puntos = {1: 25, 2: 18, 3: 15, 4: 12, 5: 10, 6: 8, 7: 6, 8: 4, 9: 2, 10: 1}


archivo = 'F1_2024.txt'

while True:
    print(
        """
        1. Listado con el total de puntos de cada piloto, ordenado de mayor a menor puntaje.
        2. Listado de puntos de cada equipo, ordenado de mayor a menor puntaje.
        3. Promedio de puntos de cada piloto
        4. Mejor posición obtenida por cada piloto en orden alfabético.
        0. Salir
        """)
    opcion = input("Elija una opción: ")

    if opcion == '1':
        ListadoTotalPuntos(archivo)
    elif opcion == '2':
        ListadoPuntosEquipos(archivo)
    elif opcion == '3':
        PromedioPuntos()
    elif opcion == '4':
        MejorPosicion()
    elif opcion == '0':
        print("Saliendo del programa...")
        break
    else:
        print("Ingrese una opción correcta por favor.")
        