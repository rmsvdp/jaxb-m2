package jaxb;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Listacoches")

/**
 * Garage de coches
 * @author root
 *
 */
public class Coches {
	@XmlElement(name = "coche")
    protected List<Coche> autos;

	public List<Coche> getCoches() {
		return autos;
	}

	public void setCoches(List<Coche> items) {
		this.autos = items;
	}
 
}
