num1 = float (input("Ingrese un número: "))
num2 = float (input("Ingrese otro número: "))
tipo_operacion = (input("Ingrese el tipo de operacion: "))

def suma (num1, num2):
    return (num1 + num2)

def resta (num1, num2):
    return num1 - num2

def division (num1, num2):
    return num1 / num2

def multiplicacion (num1, num2):
    return num1 * num2

def calculadora (num1, num2, tipo_operacion):
    if tipo_operacion == '+':
         return suma(num1,num2)
    elif tipo_operacion == '-':
        return resta(num1,num2)
    elif tipo_operacion == '/':
        return division(num1,num2)
    elif tipo_operacion == '*':
        return multiplicacion(num1,num2)

print ("El resultado de la operacion ",tipo_operacion," es: ",(calculadora(num1,num2,tipo_operacion)))