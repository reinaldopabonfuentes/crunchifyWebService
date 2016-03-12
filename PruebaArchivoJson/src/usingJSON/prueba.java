package usingJSON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;


public class prueba {
   public static void main(String[] args)
         throws FileNotFoundException, JSONException {
      /*
       * Lectura y almacenamiento del archivo en fileData
       */
      String fileData = "";
      BufferedReader br = null;
      try {
         String line;
         br = new BufferedReader(
               new FileReader("R://Dropbox//Windows 7//Ruta.json"));
         while ((line = br.readLine()) != null) {
            fileData += line + "\n";
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            if (br != null)
               br.close();
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
      try {
         /*
          * Parsear
          */
         ContenedorJSON archivoJSON = new ContenedorJSON(fileData);
         /**/
         
         if((archivoJSON.checkCamposArchivo()) && (archivoJSON.checkCamposRuta())){
            if ((archivoJSON.checkQCamposObjeto()) && (archivoJSON.checkQCamposRuta())) {
               System.out.println("Los nombres y la cantidad de los campos ¡SI COINCIDEN!");
            } else {
               System.out.println("Los nombres o la cantidad de los campos ¡NO COINCIDEN!, ");
            }
         }
         else{
               System.out.println("Los nombres o la cantidad de los campos ¡NO COINCIDEN!");
            
         }
         
         
       
      

      } catch (JSONException e) {
         e.printStackTrace();
      }

   }

}
