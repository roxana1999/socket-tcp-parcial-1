package sockets;

public class DatosMeteorologicos {
	Integer id_estacion;
	String ciudad;
	Integer porcentaje_humedad;
	Integer temperatura;
	Integer velocidad_viento;
	String fecha;
	String hora;
	
	public DatosMeteorologicos(){}

	public DatosMeteorologicos(Integer pid_estacion, String pciudad, Integer pporcentaje_humedad, Integer ptemperatura, Integer pvelocidad_viento, String pfecha, String phora){
		this.id_estacion = pid_estacion;
		this.ciudad = pciudad;
		this.porcentaje_humedad = pporcentaje_humedad;
		this.temperatura = ptemperatura;
		this.velocidad_viento = pvelocidad_viento;
		this.fecha = pfecha;
		this.hora = phora;
	}
	
	public Integer getid_estacion() {
		return id_estacion;
	}
	
	public void setid_estacion(Integer id_estacion) {
		this.id_estacion = id_estacion;
	}

	public String getciudad() {
		return ciudad;
	}

	public void setciudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public long getporcentaje_humedad() {
		return porcentaje_humedad;
	}

	public void setporcentaje_humedad(Integer porcentaje_humedad) {
		this.porcentaje_humedad = porcentaje_humedad;
	}
	
	public Integer gettemperatura() {
		return temperatura;
	}

	public void settemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}
	
	public Integer getvelocidad_viento() {
		return velocidad_viento;
	}
	
	public void setvelocidad_viento(Integer velocidad_viento) {
		this.velocidad_viento = velocidad_viento;
	}
}
