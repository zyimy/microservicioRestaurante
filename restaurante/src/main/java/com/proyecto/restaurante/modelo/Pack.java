package com.proyecto.restaurante.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
public class Pack {


    private String nombre;

    private String descripcion;

    private String imagen;

    private String direccion;

    private String status;

    private double precio;

    private String hora_disponible;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private int restauranteId;

    public Pack(String nombre, String descripcion, String imagen, String direccion, String status, double precio, String hora_disponible, Date fecha, int restauranteId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.direccion = direccion;
        this.status = status;
        this.precio = precio;
        this.hora_disponible = hora_disponible;
        this.fecha = fecha;
        this.restauranteId = restauranteId;
    }
}
