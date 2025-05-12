def EscribirEspaciado(texto):

    for i in texto:
        print(i, end=' ' )

texto = input("Ingrese un texto a ser espaciado: ")

EscribirEspaciado(texto)