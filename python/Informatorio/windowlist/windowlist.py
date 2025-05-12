from tkinter import *


def add_to_list():
    listbox.insert(listbox.size(), entry_box.get())
    listbox.config(height= listbox.size())

def delete():
    for index in listbox.curselection(): ##.curselection crea una tupla con los indices
        listbox.delete(index)
    listbox.config(height=listbox.size())




window = Tk()
window.title=("Lista")
window.geometry('380x200')
listbox = Listbox(window, selectmode=MULTIPLE)
listbox.pack()

listbox.insert(1,"Pizza")
listbox.insert(2,"Hamburguesa")

listbox.config(height= listbox.size())

entry_box=Entry(window)
entry_box.pack()

add_button=Button(window, text="Añadir a la lista",command=add_to_list)
add_button.pack()

delete_button=Button(window,text="Eliminar",comman=delete)
delete_button.pack()




window.mainloop()