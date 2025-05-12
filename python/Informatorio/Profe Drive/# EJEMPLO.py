# EJEMPLO
from tkinter import *
#--------------------------------------------------------------------------------------------------------------
#Funciones

#File
def open_file():
    print("Archivo abierto")
def save_file():
    print("Archivo guardado")

#Edit
def cut():
    print("Archivo cortado")
def copy():
    print("Archivo cortado")
def paste():
    print("Archivo cortado")

#--------------------------------------------------------------------------------------------------------------
window = Tk() #Creamos una ventana

menu = Menu(window)
window.config(menu=menu)

#--------------------------------------------------------------------------------------------------------------
file = Menu(menu, tearoff=0) #Creamos un submenu
menu.add_cascade(label="File", menu=file) #Despliega un cuadrado vacio


#Luego añadimos las opciones que van a aparecer en dicho cuadrado que inicialmenete estaba vacio
file.add_command(label="Open", command=open_file)
file.add_command(label="Save", command=save_file)
file.add_separator()
file.add_command(label="Exit", command=quit)
#------------------------------------------------------------------------------------------------------------
edit = Menu(menu, tearoff=0)
menu.add_cascade(label="Edit", menu=edit)

edit.add_command(label="Cut", command=cut)
edit.add_command(label="Copy", command=copy)
edit.add_command(label="Paste", command=paste)

window.mainloop()
###