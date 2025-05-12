import mysql.connector
conexion1=mysql.connector.connect(host="localhost", user="facu", passwd="12345678", database="sakila_es", auth_plugin="mysql_native_password")

cursor1=conexion1.cursor()
cursor1.execute("select * from actor")

for base in cursor1:
    print (base)
conexion1.close()

