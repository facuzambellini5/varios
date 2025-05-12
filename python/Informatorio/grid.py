from tkinter  import *


ventana=Tk()
ventana.geometry("380x300")
titulo_etiqueta=Label(ventana,text="Ingrese sus datos").grid(row=0,column=0,columnspan=2)

primer_nombre_etiqueta=Label(ventana,text="Primer nombre").grid(row=1,column=0,columnspan=2)
primer_nombre=Entry(ventana).grid(row=1,column=2)


apellido=Label(ventana,text="Apellido").grid(row=2,column=0,columnspan=2)
apellido=Entry(ventana).grid(row=2,column=2)

enviar_botno=Button(ventana,text="Enviar").grid(row=3,column=2)


ventana.mainloop()