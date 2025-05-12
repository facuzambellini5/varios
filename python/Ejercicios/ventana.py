import tkinter as tk

def borrar():
    nro1.set('')
    nro2.set('')

def saludar():
    print("Hola!")

ventana = tk.Tk()
ventana.title("Mi primeara ventana con Tkinter")
ventana.geometry('500x500')

etiqueta = tk.Label(ventana, text = 'Hola mundo', font = ('Arial' , 12))
etiqueta.pack()

boton = tk.Button(ventana, text= "hola",command=saludar)
boton.pack()

ventana.mainloop()