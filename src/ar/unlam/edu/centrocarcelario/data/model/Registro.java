package ar.unlam.edu.centrocarcelario.data.model;

import java.time.LocalDate;

public class Registro implements Comparable<Registro> {

    private LocalDate fecha;
    private String desc;


    public Registro(LocalDate fecha, String desc) {
	super();
	this.fecha = fecha;
	this.desc = desc;
    }




    public LocalDate getFecha() {
	return fecha;
    }




    public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
    }




    public String getDesc() {
	return desc;
    }




    public void setDesc(String desc) {
	this.desc = desc;
    }




    @Override
    public int compareTo(Registro o) {

	return this.getFecha().compareTo(o.getFecha());
    }


}
