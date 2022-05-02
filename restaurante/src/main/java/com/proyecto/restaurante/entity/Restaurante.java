package com.proyecto.restaurante.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tbl_restaurante")
@Data
@NoArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_restaurante;
    private String nombre;
    private String email;
    private String contrasena;
    private String nombre_calle;
    private int codigo_postal;
    private int numero_calle;

    public Restaurante(String nombre, String email, String contrasena,
                       String nombre_calle, int codigo_postal, int numero_calle) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.nombre_calle = nombre_calle;
        this.codigo_postal = codigo_postal;
        this.numero_calle = numero_calle;
    }
}
