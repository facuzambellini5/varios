def EscribirCentrado(texto):
   
    print(" " * (80 - len(texto) // 2 ),texto)
    print(" " * (80 - len(texto) // 2), "=" * len(texto))
 

texto = input("Ingrese un texto: ")

EscribirCentrado(texto)