package com.proyecto.pack.entity;




import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_pack")
@Data
@NoArgsConstructor
public class Pack  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pack;
	
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
	
	


	public Pack(String nombre, String descripcion, String imagen, String direccion, double precio, Date fecha
			) {
	
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.direccion = direccion;
		this.precio = precio;
		this.fecha = fecha;

		
	}

}
