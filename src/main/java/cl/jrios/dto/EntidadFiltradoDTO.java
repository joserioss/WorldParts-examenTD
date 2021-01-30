package cl.jrios.dto;

public class EntidadFiltradoDTO {
	
	private String fecha_desde;
	private String fecha_hasta;
	private Integer apellido;
	private Integer edad;
	public String getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(String fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public String getFecha_hasta() {
		return fecha_hasta;
	}
	public void setFecha_hasta(String fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	public Integer getApellido() {
		return apellido;
	}
	public void setApellido(Integer apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "EntidadFiltradoDTO [fecha_desde=" + fecha_desde + ", fecha_hasta=" + fecha_hasta + ", apellido="
				+ apellido + ", edad=" + edad + "]";
	}
	

}
