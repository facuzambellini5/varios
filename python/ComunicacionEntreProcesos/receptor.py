import socket

HOST = "192.168.1.64"
PORT = 5004

with socket.socket(socket.AF_INET) as s:
    s.bind((HOST, PORT))
    s.listen()
    print(f"Servidor escuchando en {HOST}:{PORT} ...")
    conn, addr = s.accept()
    with conn:
        print("Conexión desde:", addr)
        while True:
            data = conn.recv(1024)
            if not data:
                break
            print("Cliente dice:", data.decode())
            conn.sendall(b"Mensaje recibido\n")