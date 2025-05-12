import tkinter as tk
import funcionescalculadora

ventana = tk.Tk()
ventana.geometry("500x500")
ventana.config(bd=15)

nro1 = ventana.StringVar()
nro2 = ventana.StringVar()


resultado = ventana.StringVar()

etiqueta_nro1 = tk.Label(ventana, text = "Número 1").pack()
input_nro1 = tk.Entry(ventana, justify = "center",textvariable = nro1).pack()

etiqueta_nro2 = tk.Label(ventana, text = "Número 2").pack()
input_nro2= tk.Entry(ventana, justify= "center",textvariable = nro2).pack()

etiqueta_resultado = tk.Label(ventana, text="Resultado").pack()
input_resultado =tk.Entry(ventana, justify ="center",textvariable="resultado", state = "disabled").pack()

separador = tk.Label(ventana, text=" ").pack()

boton_suma = tk.Button(ventana, text="SUMA",command=funcionescalculadora.suma).pack()

boton_resta = tk.Button(ventana, text="RESTA",command=funcionescalculadora.resta).pack()

boton_multiply = tk.Button(ventana, text="MULTIPLICACIÓN",command=funcionescalculadora.multiply).pack()

boton_division = tk.Button(ventana, text="DIVISIÓN",command=funcionescalculadora.division).pack()

