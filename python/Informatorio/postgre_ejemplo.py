import psycopg2

conn = psycopg2.connect(database = 'database', user = 'postgres', host = 'localhost', password = '794613', port = '5432')
cur = conn.cursor()
print("Se conectó a la BD exitosamente.")

cur.execute('''UPDATE PERSONA SET DIRECCION 'CHACO' WHERE NOMBRE='GERMAN';''')
cur.execute('''SELECT * FROM PERSONA''')

"""cur.execute('''SELECT * FROM PERSONA ORDER BY NOMBRE''')"""

rows = cur.fetchall()

"""
cur.execute('''INSERT INTO PERSONA (ID, APELLIDO, NOMBRE, DIRECCION, EDAD)
            VALUES (1, 'PEREZ', 'GERMAN', 'CHACO', 32)''')

cur.execute('''INSERT INTO PERSONA (ID, APELLIDO, NOMBRE, DIRECCION, EDAD)
            VALUES (2, 'RODRIGUEZ', 'FATIMA', 'BERMEJO', 22)''')

cur.execute('''INSERT INTO PERSONA (ID, APELLIDO, NOMBRE, DIRECCION, EDAD)
            VALUES (3, 'ACUÑA', 'MATIAS', 'LA PAMPA', 31)''')
"""



print("Se han ingresado los datos correctamente")

conn.commit()
print("Se ha guardado exitosamente")

cur.close()
print("Se ha cerrado la conexión.")

for row in rows:
    print(row)