class Coche():

    ruedas = 4

    def __init__(self, marca, modelo, color) -> None: #constructor
        self.marca = marca
        self.modelo=modelo
        self.color=color

    #Metodos
    def acelerar(self):
        print('El auto de marca {self.marca} y color {self.color} esta acelerando')

    def frenar(self):
        print('El auto de marca {self.marca} y color {self.color} esta frenando')

    un_coche = Coche('Toyota','Corolla','Negro')
    otro_coche= Coche('Renault','Duster','Blanco')

    un_coche.acelerar()
    otro_coche.frenar()