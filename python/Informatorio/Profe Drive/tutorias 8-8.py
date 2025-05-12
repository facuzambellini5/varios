from tkinter import *
from time import *

def update():
    time_string = strftime('%I:%M:%S:%p') #Hora-minuto-segundo-am o pm
    time_label.config(text=time_string) #esta estiqueta es igual el timestring
    time_label.after(1000,update) #para que la hora corra, after toma milisegundos

    day_string = strftime('%A') #Muestra el dia de la semana %A
    day_label.config(text=day_string) 

    date_string = strftime('%B %d,%y') #mes- dia numerico- anio
    date_label.config(text=date_string)

window = Tk()

time_label = Label(window, font=('Arial',20),foreground='white',background= 'black')  ##color de la ventana y fuente
time_label.pack()

day_label = Label(window, font=('Arial',20),foreground='white',background= 'black')
day_label.pack()

date_label = Label(window, font=('Arial',20),foreground='white',background= 'black')
date_label.pack()


update()
window.mainloop() #es para mostrar la ventana

