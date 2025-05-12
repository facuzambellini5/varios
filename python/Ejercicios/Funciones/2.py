def EsMultiplo(num1, num2):

    if num1 % num2 == 0:
        print(f"{num1} es múltiplo de {num2}. El primero es múltiplo.")
    elif num2 % num1 == 0:
        print(f"{num2} es múltiplo de {num1}. El primero NO es múltiplo.")
    else:
        print("No son múltiplos.")


num1 = int(input("Ingrese el primer número: "))
num2 = int(input("Ingrese el segundo número: "))

EsMultiplo(num1, num2)