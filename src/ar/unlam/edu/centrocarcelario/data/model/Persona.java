package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;

public abstract class Persona {

    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fdn;

    public Persona(Integer dni, String nombre, String apellido, LocalDate fdn) {
	// TODO Auto-generated constructor stub
	this.dni = dni;
	this.apellido = apellido;
	this.nombre = nombre;
	this.fdn = fdn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFdn() {
        return fdn;
    }

    public void setFdn(LocalDate fdn) {
        this.fdn = fdn;
    }

}
