import tkinter as tk
from calculadoraTkinker import nro1, nro2, resultado

def borrar():
    nro1.set = ("")
    nro2.set = ("")

def suma():
    resultado.set (float (nro1.get()) + float(nro2.get()))
    borrar()

def resta():
    resultado.set (float (nro1.get()) - float (nro2.get()))
    borrar()

def multiply():
    resultado.set (float (nro1.get()) * float (nro2.get()))
    borrar()

def division():
    resultado.set (float (nro1.get()) / float (nro2.get()))
    borrar()
