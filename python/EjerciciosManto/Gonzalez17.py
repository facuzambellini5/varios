"""En una carrera que tiene varios tramos, el ganador es aquel competidor que tarda menos en
llegar a la meta. Se mide el tiempo que tarda cada corredor en realizar cada tramo, esta medición se
toma en minutos. La cantidad de tramos no es fija.
Desarrolle un programa que permita ingresar los tiempos de un corredor de cada tramo y entregue
como resultado el tiempo total de carrera en formato horas:minutos.
"""

minutos = 1
tramos = 0
cant_minutos = 0

while minutos != 0:
   
   minutos = float(input("Ingrese la cantidad de minutos del tramo: "))
   print("Duración del tramo: ",minutos)

   if minutos != 0:
      tramos += 1

   cant_minutos = cant_minutos + minutos
   horas = cant_minutos / 60

print("El tiempo total de viaje es: ",horas," hora/s, y la cantidad de tramos: ",tramos)








