def ListadoFechaPromedio(fecha, archivo):
    max = []
    min = []
    suma_max = 0
    suma_min = 0
    fecha_encontrada = False
    
    with open(archivo, 'r') as archivo:
        for i in archivo:
            if fecha == i[0:8]:
                fecha_encontrada = True
                print(i)

                if i[9:14] != '     ':
                    max.append(float(i[9:14]))
                else:
                    pass

                if i[15:20] != '     ':
                    min.append(float(i[15:20]))
                else:
                    pass

        if fecha_encontrada: 
            for i in max:
                suma_max += i

            for i in min:
                suma_min += i

            promedio_max = suma_max / len(max)
            promedio_min = suma_min / len(min)

            print(f"Promedio de temperatura máximo registrado: {promedio_max:.2f}")
            print(f"Promedio de temperatura mínimo registrado: {promedio_min:.2f}")
        else:
            print(f"No se encontraron registros de la fecha: {fecha}")
        
            
def RegistroAmplitudTermica(archivo):
    max_amplitud = 0
    
    with open(archivo, 'r') as archivo:
        for i in archivo:
            if i.startswith("FECHA") or i.startswith("--------"):
                continue

            fecha = i[0:8]
            max_str = i[9:14]
            min_str = i[15:20]
            base = i[21:]

            if max_str != '     '  and min_str != '     ':
                try:
                    max = float(max_str)
                    min = float(min_str)

                    amplitud = abs(max-min)

                    if amplitud > max_amplitud:
                        max_amplitud = amplitud
                        registro_max_amplitud = f"Fecha: {fecha} Temp. máxima: {max}°C Temp. minima: {min}°C Base: {base}"
                except:
                    continue
                
        print ("Registro de mayor amplitud térmica:")
        print(registro_max_amplitud)
        print(f"Este registro tiene una amplitud térmica de: {max_amplitud}°C")
        
        

def NombreBase(base_ingresada, archivo):
    base_encontrada = False
    registro_max = 0
    
    with open(archivo, 'r') as archivo:
        for i in archivo:
            
            fecha = i[0:8]
            max_str = i[9:14]
            min_str = i[15:20]
            base = i[21:]
            registro_base_ingresada = f"{fecha} {max_str} {min_str} {base}"

            if base_ingresada in base:
                base_encontrada = True
                print(registro_base_ingresada)
                if max_str != '     ':
                    try:
                        max = float(max_str)
                        if max > registro_max:
                            registro_max = max
                            fecha_max = i[0:8]
                    except:
                        continue
        if base_encontrada:
            print(f"La mayor temperatura registrada es: {registro_max}°C en la fecha: {fecha_max}")
        else:
            print(f"No se ha encontrado una base con el nombre: {base_ingresada}")
        
                
archivo = 'registro_temperatura365d_smn.txt'

while True:
    print("""
          1. Consultar por una fecha, con el promedio de temperatura mínimo y máximo.
          2. Registro en el que se da la mayor amplitud térmica.
          3. Registros de una base determinada. Mostrando también la fecha en que hizo más calor.
          0. Salir del programa.
          """)
    
    opcion = input("Elija una opción: ")

    if opcion == '1':
        while True:
            fecha = (input("Ingrese una fecha(8 caracteres): "))
            if len(fecha) == 8:
                break
            else:
                print("Fecha incorrecta, intente nuevamente.")
        ListadoFechaPromedio(fecha, archivo)

    elif opcion == '2':
        RegistroAmplitudTermica(archivo)

    elif opcion == '3':
        base_ingresada = input("Ingrese el nombre de la base: ").upper()
        NombreBase(base_ingresada, archivo)

    elif opcion == '0':
        print("Saliendo del programa...")
        break

    else:
        print("Por favor ingrese una opción válida.")
