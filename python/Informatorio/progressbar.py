from tkinter import *
from tkinter.ttk import*
import time



def start():
    GB=100
    download=0
    speed=1
    while download<GB:
        time.sleep(0.05)
        bar['value']+= speed
        download+=speed
        porcentaje.set(str(download)+ "%")
        ventana.update_idletasks()

ventana=Tk()

porcentaje=StringVar() #crea variable de tipo String

bar=Progressbar(ventana,orient=HORIZONTAL,length=300)
bar.pack(padx=10,pady=10)

porcentaje_etiqueta=Label(ventana,textvariable=porcentaje).pack()


buttom=Button(ventana,text="Desargar",command=start).pack()








ventana.mainloop()