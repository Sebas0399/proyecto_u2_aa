package com.uce.edu.demo.repository.modelo.onetomany;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura {
	@Id
	@Column(name="fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_id_seq")
	@SequenceGenerator(name = "fact_id_seq", sequenceName = "fact_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name="fact_total")
	private BigDecimal total;
	@Column(name="fact_fecha")

	private LocalDateTime fecha;
	@OneToMany(mappedBy = "factura",cascade = CascadeType.ALL)
	
	private List<Producto>productos;
	//set y get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", total=" + total + ", fecha=" + fecha + ", productos=" + productos + "]";
	}
	
}
