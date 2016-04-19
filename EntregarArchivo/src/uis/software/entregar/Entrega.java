package uis.software.entregar;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;
 
@Path("/")
public class Entrega {
 
	@GET
	@Path("/consultar")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response verifyRESTService(InputStream incomingData) {
		String string = "";
		JSONObject objeto=buildResponse("5", "facil", "soleado, feliz");

		// Retorna el objeto
		return Response.status(200).entity(objeto.toString()).build();
	}
	
	private JSONObject buildResponse(String id, String complejidad, String tag) {
		JSONObject ob = new JSONObject();
		ob.put("id", id);
		ob.put("complejidad", complejidad);
		ob.put("tag", tag);
		ob.put("ruta", buildArray());
		return ob;
		
	}
	
	private JSONArray buildArray() {
		JSONArray array = new JSONArray();		
		array.put(buildCoordinate("14/01/2016", "06:00:00", "7.04024", "-73.11703"));
		array.put(buildCoordinate("14/01/2016", "06:00:00", "7.04054", "-73.11708"));
		array.put(buildCoordinate("14/01/2016", "06:00:00", "7.04084", "-73.11712"));		
		return array;
	}
	
	private JSONObject buildCoordinate(String fecha, String hora, String latitud, String longitud) {
		JSONObject ob = new JSONObject();
		ob.put("fecha", fecha);
		ob.put("hora", hora);
		ob.put("latitud", latitud);
		ob.put("longitud", longitud);
		return ob;
	}
	

	
	public Response verifyRESTServiceOldVersion(InputStream incomingData) {
		String string = "";
		JSONObject objeto=null;
		try {
			//Leer el archivo
			InputStream archivoLeer = new FileInputStream("E://workspace//EntregarArchivo//Ruta.json");
			InputStreamReader archivoReader = new InputStreamReader(archivoLeer);
			BufferedReader br = new BufferedReader(archivoReader);
			String line;
			while ((line = br.readLine()) != null) {
				string += line + "\n";
			}
			//Se convierte a JSON Object
			br.close();
			System.out.println(string);
			objeto = new JSONObject(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Retorna el objeto
		return Response.status(200).entity(objeto.toString()).build();
	}
	
}