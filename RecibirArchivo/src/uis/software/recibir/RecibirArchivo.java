package uis.software.recibir;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



import org.json.JSONException;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class RecibirArchivo {
	

	@POST
	@Path("/recibir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response recibirREST(InputStream incomingData) {
		String datos = "";
		StringBuilder builder = new StringBuilder();
		InputStreamReader entrada = new InputStreamReader(incomingData);
		try {
			BufferedReader in = new BufferedReader(entrada);
			String line = null;
			while ((line = in.readLine()) != null) {
				builder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + builder.toString());
		datos = builder.toString();
		String result = "";
	      try {  
	    	  ContenedorJSON archivoJSON = new ContenedorJSON(datos);
	    	  //Se verifica y se obtiene la respuesta
	          if((archivoJSON.checkCamposArchivo()) && (archivoJSON.checkCamposRuta())){
	             if ((archivoJSON.checkQCamposObjeto()) && (archivoJSON.checkQCamposRuta())) {
	                result="Los nombres y la cantidad de los campos ¡SI COINCIDEN! response";
	             } else {
	                result = "Los nombres o la cantidad de los campos ¡NO COINCIDEN! response";
	             }
	          }
	          else{
	                result = "Los nombres o la cantidad de los campos ¡NO COINCIDEN! response";
	          }
	       } catch (JSONException e) {
	          e.printStackTrace();
	       }
	      //En caso de que sea exitoso imprima result
		return Response.status(200).entity(result).build();

	}
}
