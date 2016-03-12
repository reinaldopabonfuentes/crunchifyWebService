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

import org.json.JSONObject;
 
@Path("/")
public class Entrega {
 
	@GET
	@Path("/consultar")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response verifyRESTService(InputStream incomingData) {
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