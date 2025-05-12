def ListadoFechaPromedio(fecha):
    max = []
    min = []
    suma_max = 0
    suma_min = 0
    print("  FECHA   TMAX  TMIN    BASE ",end="")
    print()
    for i in archivo:
        if fecha == i[0:8]:
            print(i)
            #print(f"Fecha: {i[0:8]}")
            #print(f"Temperatura Max: {i[10:14]}")
            #print(f"Temperatura Min: {i[16:20]}")
            #print(f"Nombre Base: {i[21:]}")

            if i[9:14] != '     ':
                max.append(float(i[9:14]))
            else:
                pass

            if i[15:20] != '     ':
                min.append(float(i[15:20]))
            else:
                pass
       
    for i in max:
        suma_max += i

    for i in min:
        suma_min += i

    promedio_max = suma_max / len(max)
    promedio_min = suma_min / len(min)

    print(f"Promedio de temperatura máximo registrado: {promedio_max:.2f}")
    print(f"Promedio de temperatura minima registrado: {promedio_min:.2f}")
    
            
def RegistroAmplitudTermica(archivo):
    max_amplitud = 0
    registro_max_amplitud = ""

    for i in archivo:

        if i.startswith("FECHA") or i.startswith("--------"):
            continue

        fecha = i[0:8]
        max_str = i[9:14]
        min_str = i[15:20]
        base = i[21:54]


        if max_str != '     '  and min_str != '     ':
            try:
                max = float(max_str)
                min = float(min_str)

                amplitud = abs(max-min)

                if amplitud > max_amplitud:
                    max_amplitud = amplitud
                    registro_max_amplitud = f"{fecha} {max_str} {min_str} {base}"
            except:
                continue
    print (f"Registro de mayor amplitud térmica: {registro_max_amplitud}")
    print(f"Este registro tiene una amplitud térmica de: {max_amplitud}")
        

def NombreBase():
    for i in archivo:
        print(i[21:])

archivo = open('registro_temperatura365d_smn.txt')
while True:
    print("""
          1. Consultar por una fecha, con el promedio de temperatura mínimo y máximo.
          2. Registro en el que se da la myor amplitud térmica.
          3. Registros de una base determinada. Mostrando también la fecha en que hizo más calor.
          0. Salir del programa.
          """)
    opcion = int(input("Elija una opción: "))

    if opcion == 5:
        for i in archivo:
            print(f"Fecha: {i[0:8]}")
            print(f"Temperatura Max: {i[10:14]}")
            print(f"Temperatura Min: {i[16:20]}")
            print(f"Nombre Base: {i[21:]}")
    elif opcion == 1:
        while True:
            fecha = (input("Ingrese una fecha(8 caracteres): "))
            if len(fecha) == 8:
                break
            else:
                print("Fecha incorrecta, intente nuevamente.")
        ListadoFechaPromedio(fecha)  
    elif opcion == 2:
        RegistroAmplitudTermica(archivo)
    elif opcion == 3:
        NombreBase()
    elif opcion == 0:
        print("Saliendo del programa...")
        break




