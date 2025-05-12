import tkinter as tk


menu=tk.Tk()
menu.title=("Busca tu pasaje")
menu.geometry('380x300')

origen = tk.Label(menu,text="Origen",font=("Arial", 12))
origen.place(x=10,y=50)

destino = tk.Label(menu,text="Destino",font=("Arial",12))
destino.place(x=10,y=140)



opciones_origen=["1","2","3","4","5"]
origen_lista=tk.OptionMenu(menu,*opciones_origen)
origen_lista.place(width=100,x=10,y=72)


opciones_destino=["1","2","3","4","5",]
destino_lista=tk.OptionMenu(menu,*opciones_destino)
destino_lista.place(width=100,x=10,y=162)












menu.mainloop()





