import tkinter as tk

ventana=tk.Tk()
ventana.title("Barra plegable")
ventana.geometry("400x150")
ventana.configure(background="light sky blue")
var = tk.StringVar(ventana)
var.set("Elegir")

opciones =["Buenos Aires","Buenos Aires Capital","Catamarca","Chaco","Chubut","Córdoba","Corrientes","Entre Ríos","Formosa","Jujuy","La Pampa","La Rioja","Mendoza","Misiones","Neuquen","Río Negro","Salta","San Juan",
           "San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego"]

opcion = tk.OptionMenu(ventana, var, *opciones)
opcion.config(width=9)
opcion.pack(side="left",padx="30",pady="30")

provincia_texto= tk.Label(ventana, text="Provincia Seleccionada", bg="light steel blue").pack(padx=5,pady=5,ipadx=5,ipady=5,fill=tk.X)
provincia_selec=tk.Label(ventana, textvariable=var,padx=5,pady=5,width=50,).pack()
ventana.mainloop()
