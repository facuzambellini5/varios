def ListadoTotalPuntos(archivo):
    with open(archivo, 'r') as archivo:
        lineas = archivo.readlines()
        resultados = []

        for linea in lineas[1:]:                # recorremos cada piloto(linea)    
            pilotos = linea[:10].strip()
            posiciones = linea.split()[-21:]
            posiciones_int = []
            
            #con este for recorremos las lineas de posiciones para convertirlas a int
            for posicion in posiciones:
                posiciones_int.append(int(posicion))
            
            puntos_piloto=0

            for i in posiciones_int:
                if i in tabla_puntos:
                    puntos_piloto += tabla_puntos[i]
                else:
                    puntos_piloto += 0

            resultados.append((pilotos, puntos_piloto))

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
        equipos_puntajes = {}
        
        lista_equipos = []
        lista_puntaje = []

        for linea in lineas[1:]:
            equipo = linea[12:40].strip()
            posiciones = linea.split()[-21:]
            posiciones_int = []

            for i in posiciones:
                posiciones_int.append(int(i))

            puntos_pilotos = 0
            for posicion in posiciones_int:
                if posicion in tabla_puntos:
                    puntos_pilotos += tabla_puntos[posicion]

            if equipo not in equipos_puntajes:
                equipos_puntajes[equipo] = puntos_pilotos
            else:
                equipos_puntajes[equipo] += puntos_pilotos
        
        for i in equipos_puntajes:
            lista_equipos.append(i)
            lista_puntaje.append(equipos_puntajes[i])

        n = len(lista_puntaje)
        for i in range(n):
            for j in range(0, n - i - 1):
                if lista_puntaje[j] < lista_puntaje[j + 1]:  # Orden descendente por puntos
                    # Intercambiar puntajes
                    lista_puntaje[j], lista_puntaje[j + 1] = lista_puntaje[j + 1], lista_puntaje[j]
                    # Intercambiar los equipos correspondientes
                    lista_equipos[j], lista_equipos[j + 1] = lista_equipos[j + 1], lista_equipos[j]
        for i in range(n):
            print(f"{lista_equipos[i]}: {lista_puntaje[i]}")
            

def PromedioPuntos(archivo):
    with open(archivo, 'r') as archivo:
        lineas = archivo.readlines()
        
        for linea in lineas[1:]:
            pilotos = linea[:10].strip()
            posiciones = linea.split()[-21:]
            posiciones_int = []
            
            for posicion in posiciones:
                posiciones_int.append(int(posicion))

            puntos_piloto = 0
            cantidad_valida = 0
            carreras = 0
            promedio_valido = 0

            for i in posiciones_int:
                carreras += 1
                if i in tabla_puntos:
                    puntos_piloto += tabla_puntos[i]
                    if i != 0:
                        cantidad_valida += 1
                else:
                    puntos_piloto += 0
            
            promedio_carreras = puntos_piloto/carreras
            
            if cantidad_valida > 0:
                promedio_valido = puntos_piloto/cantidad_valida
            
            
            
            print(f"El promedio de puntos del total de carreras de {pilotos} es: {promedio_carreras:.2f} ")
            print(f"El promedio de los puntos validos de {pilotos} es: {promedio_valido:.2f}")


def MejorPosicion(archivo):
    with open(archivo, 'r') as archivo:
        lineas = archivo.readlines()
        mejor_posicion = []
        piloto = []
        for linea in lineas[1:]:                
            pilotos = linea[:10].strip()
            posiciones = linea.split()[-21:]
            posiciones_int = []
            


            for posicion in posiciones:
                posiciones_int.append(int(posicion))

            min = None
            for i in posiciones_int:
                if i != 0:
                    if min == None:
                        min = i
                    elif i < min:
                        min = i

            mejor_posicion.append(min)
            piloto.append(pilotos)


        n = len(piloto)
        for i in range(n):
            for j in range(0, n - i - 1):
                if piloto[j] < piloto[j + 1]:  # Orden descendente por puntos
                    # Intercambiar puntajes
                    piloto[j], piloto[j + 1] = piloto[j + 1], piloto[j]
                    # Intercambiar los equipos correspondientes
                    piloto[j], piloto[j + 1] = piloto[j + 1], piloto[j]
        for i in range(n):
            print(f"{piloto[i]}: {mejor_posicion[i]}")
                    



            
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
        print("---------------------------------")
        print("Puntos total de los pilotos: ")
        print("---------------------------------")
        ListadoTotalPuntos(archivo)
    elif opcion == '2':
        print("---------------------------------")
        print("Puntos de los equipos: ")
        print("---------------------------------")
        ListadoPuntosEquipos(archivo)
    elif opcion == '3':
        print("---------------------------------")
        print("Promedio de puntos de cada piloto: ")
        print("---------------------------------")
        PromedioPuntos(archivo)
    elif opcion == '4':
        print("---------------------------------")
        print("Mejor posición de cada piloto: ")
        print("---------------------------------")
        MejorPosicion(archivo)
    elif opcion == '0':
        print("---------------------------------")
        print("Saliendo del programa...")
        print("---------------------------------")
        break
    else:
        print("Ingrese una opción correcta por favor.")
        