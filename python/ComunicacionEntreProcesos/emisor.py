import socket

host = "181.94.194.194"
port = 5000

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect((host, port))

while True:
    mensaje = input("Ingrese un mensaje: ")
    sock.sendall(mensaje.encode('utf-8'))
    if( mensaje.lower() == "salir"):
        print("Cerrando conexión.")
        break
sock.close()
print("Conexión cerrada.")






