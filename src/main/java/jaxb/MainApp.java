package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
public class MainApp {

	public static void main(String[] args) {
		String ruta = "C:\\rms\\coches.xml";
		// Generación de archivo a partir de una lista de objetos
		CrearXml(ruta);
		// Generación de una lista de objetos a partir de datos de un archivo
		CrearObjetos(ruta);
    }
/**
 * Recupera un garaje de coches a partir del contenido de un archivo xml
 * @param origen
 */
	public static void CrearObjetos(String origen) {
		 try {
			 // Clase sobre la que trabajar
			 JAXBContext jaxbContext = JAXBContext.newInstance(Coches.class);
			 // Objeto para recuperar desde archivo
			 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 // Generar lista de coches desde el archivo
			    Coches miGaraje = (Coches) jaxbUnmarshaller.unmarshal( new File(origen) );		     
			 // Salida por pantalla para comprobar resultado
			    for(Coche auto : miGaraje.getCoches())
			    {
			        System.out.println("Id: " +auto.getId());
			        System.out.println("Marca: " +auto.getNombre());
			        System.out.println("Valor: " +auto.getPrecio()+ "€");
			    }
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Crea un archivo xml a partir de un objeto Garaje
	 * @param destino Ruta de salida del archivo
	 */
	public static void CrearXml(String destino) {
		
		JAXBContext jaxbContext = null;
        try {

            // Registrar clase con la que vamos a trabajar
            jaxbContext = JAXBContext.newInstance(Coches.class);
            // Preparar generador de información Xml
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // fijar propiedad del generador: salida formateada
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Creamos un objeto
            Coches miGaraje = new Coches();
            miGaraje.setCoches(new ArrayList<Coche>());
            Coche o1 = new Coche();
            o1.setId(1);
            o1.setNombre("Audi A1");
            o1.setPrecio("34999.00");
            miGaraje.getCoches().add(o1);
            Coche o2 = new Coche(2,"Mercedes E220","54500.00");
            miGaraje.getCoches().add(o2);
            Coche o3 = new Coche(3,"Coupe Fiat Sport","49000.00");
            miGaraje.getCoches().add(o3);
            // Salida a fichero
            jaxbMarshaller.marshal(miGaraje, new File(destino));
            // Salida a consola
            // jaxbMarshaller.marshal(miGaraje, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
	}
	}


