package Modelo;

import java.time.LocalDate;

public class Gato extends Mascota{

    //Constructor:
    public Gato(String raza, String nombre, String fecha_nac, String sexo, float peso,
                String tipoPelo) {
        super(raza, nombre, fecha_nac, sexo, peso, tipoPelo);
    }
}
