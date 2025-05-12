listaNotas = []
ingresar = True

while ingresar == True:
    nota = float(input('Ingrese nota del estudiante, o 0 para terminar.'))
    if nota == 0:
        ingresar = False
    else:
        listaNotas.append(nota)

if listaNotas:
    promedio = sum(listaNotas)/len(listaNotas)
    print (f'El promedio del estudiante es: {promedio}')
    print (listaNotas)
else:
    print("No se cargaron datos")
