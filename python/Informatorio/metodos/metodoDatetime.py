import datetime

def cantidad_dias():
    dia = int (input("Ingrese el día"))
    mes = int (input("Ingrese el mes"))
    anio = int (input("Ingrese el año"))
    fecha_inicio = datetime.date(2024, 7, 30)
    fecha_intro = datetime.date(dia, mes, anio)
    cantidad = fecha_intro - fecha_inicio
    print("La cantidad de días es: ", cantidad)

cantidad_dias()
    
