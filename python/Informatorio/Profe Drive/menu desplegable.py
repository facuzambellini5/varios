from tkinter import *

window = Tk()

menu = Menu(window)
window.config(menu=menu)

file = Menu(menu, tearoff=0) #tearoff es para que saque unas lineas que aparecen por defecto
menu.add_cascade(label = 'Archivo', menu = file)  #Un desplegable vacio

edit = Menu(menu, tearoff=0)
menu.add_cascade(label="Editar", menu=edit)

file.add_command(label= 'Abrir')
file.add_command(label= 'Guardar')
file.add_command(label= 'Salir') #con cada uno de estos agregamos opciones al desplegable

edit.add_command(label="Cortar")
edit.add_command(label="Copiar")
edit.add_command(label="Pegar")

window.mainloop()



