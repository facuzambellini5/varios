import tkinter as tk

root = tk.Tk()
root.title("Ejemplo de grid con sticky")

# Crear widgets
label1 = tk.Label(root, text="Label 1", bg="lightblue")
label2 = tk.Label(root, text="Label 2", bg="lightgreen")

# Colocar los widgets en la cuadrícula con alineación
label1.grid(row=0, column=0, sticky="W")  # Alineado a la izquierda (oeste)
label2.grid(row=1, column=1, sticky="E")  # Alineado a la derecha (este)

root.mainloop()