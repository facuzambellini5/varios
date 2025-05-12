import tkinter as tk
import calendar
from datetime import datetime

# Función para manejar la selección de un día
def seleccionar_dia(dia):
    print(f"Has seleccionado el día: {dia}")

# Función para actualizar el calendario
def actualizar_calendario():
    # Limpiar la cuadrícula existente
    for widget in calendar_frame.winfo_children():
        widget.destroy()
    
    # Obtener el mes y el año seleccionados
    año = int(year_var.get())
    mes = meses.index(month_var.get()) + 1

    # Obtener los días de la semana y los días del mes
    dias_semana = ["Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"]
    calendario_mes = calendar.monthcalendar(año, mes)

    # Crear encabezados para los días de la semana
    for i, dia in enumerate(dias_semana):
        label = tk.Label(calendar_frame, text=dia, font=('Helvetica', 12, 'bold'), padx=10, pady=10)
        label.grid(row=0, column=i)

    # Rellenar el calendario con los días como botones
    for semana in range(len(calendario_mes)):
        for dia in range(7):
            dia_numero = calendario_mes[semana][dia]
            if dia_numero != 0:
                button = tk.Button(calendar_frame, text=str(dia_numero), font=('Helvetica', 12), padx=10, pady=10,
                                   command=lambda dia=dia_numero: seleccionar_dia(dia))
                button.grid(row=semana+1, column=dia)
            else:
                label = tk.Label(calendar_frame, text="", font=('Helvetica', 12), padx=10, pady=10)
                label.grid(row=semana+1, column=dia)

# Crear la ventana principal
root = tk.Tk()
root.title("Calendario Interactivo")

# Frame para el calendario
calendar_frame = tk.Frame(root)
calendar_frame.pack(pady=20)

# Obtener el mes y el año actual
now = datetime.now()
mes_actual = now.month
año_actual = now.year

# Variables para el mes y el año seleccionados
meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
month_var = tk.StringVar(value=meses[mes_actual-1])
year_var = tk.StringVar(value=str(año_actual))

# Crear OptionMenus para seleccionar el mes y el año
month_menu = tk.OptionMenu(root, month_var, *meses)
month_menu.pack(side=tk.LEFT, padx=20)

year_menu = tk.OptionMenu(root, year_var, *[str(año) for año in range(1900, 2101)])
year_menu.pack(side=tk.LEFT, padx=20)

# Botón para actualizar el calendario
update_button = tk.Button(root, text="Actualizar Calendario", command=actualizar_calendario)
update_button.pack(side=tk.LEFT, padx=20)

# Llenar el calendario por primera vez
actualizar_calendario()

# Ejecutar la aplicación
root.mainloop()