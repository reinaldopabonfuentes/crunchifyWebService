package usingJSON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

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
         br = new BufferedReader(new FileReader("Ruta.json"));
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
      JSONObject objeto = null;
      JSONArray ruta = null;

      try {
         /*
          * Parsear fileData en un JSONObject 
          * Obtener el vector ruta que está en el archivo JSON
          */
         objeto = new JSONObject(fileData);
         ruta = (JSONArray) objeto.get("ruta");
         if(checkNamesSub(ruta) && checkNamesFile(objeto) ){
            System.out.println("Todos los nombres del archivo (tanto del objeto como del vector), tienen el buen nombre");         
            }
         else{
            System.out.println("No todos los nombres del archivo (tanto del objeto como del vector), tienen el buen nombre");  
         }

      } catch (JSONException e) {
         e.printStackTrace();
      }
   }
   public static boolean checkNamesFile(JSONObject objeto)
   {
      /*
       * Devuelve true si los nombres del archivo JSON son iguales a lo predefinido
       * contador: cuenta las veces que los nombres están bien
       * rtasCorrectas: Cantidad de respuestas correctas que deben existir
       * nombres: Vector de nombres del archivo
       */
      int contador = 0;
      String[] nombres = JSONObject.getNames(objeto);
      int rtasCorrectas = nombres.length;
      for (int i = 0; i < nombres.length; i++) {
         String string = nombres[i];
         switch (string)
         {
            case "id":
               contador++;
               break;
            case "ruta":
               contador++;
               break;
            case "complejidad":
               contador++;
               break;
            case "fechaRuta":
               contador++;
               break;
            case "horaRuta":
               contador++;
               break;
            case "comentarios":
               contador++;
               break;
            case "etiquetas":
               contador++;
               break;
               
         }
      }
      /*Si hay tantos elementos bien (contador)
       * como el tamaño del vector (rtasCorrecta)
       * todos los elementos del archivo tienen los nombres OK
       */
      if(contador==rtasCorrectas){
         return true;
      }
      else
      {
         return false;
      }
   }

   public static boolean checkNamesSub(JSONArray ruta) {
      /*
       * Devuelve true si todos los elementos del JSONArray ruta tienen los
       * nombres de acuerdo a lo predefinido
       * rutaN: objeto de cada posición i del vector ruta
       * contador: cuenta las veces que los nombres están bien
       * rtasCorrecta: Cantidad de respuestas correctas que deben existir
       */
      int contador = 0;
      int rtasCorrecta = ruta.length();
      for (int i = 0; i < ruta.length(); i++) {
         JSONObject rutaN = ruta.getJSONObject(i);
         boolean decision = checkNameRuta(rutaN);
         if (decision) {
            contador++;
         }
      }
      /*Si hay tantos elementos bien (contador)
       * como el tamaño del vector (rtaCorrecta)
       * todos los elementos del vector tienen los nombres OK
       */
      if (rtasCorrecta == contador) {
         return true;
      } else {
         return false;
      }
   }

   public static boolean checkNameRuta(JSONObject rutaN) {
      /*
       * Devuelve true si los nombres del objeto rutaN son iguales a los
       * predefinidos 
       * contador: cuenta las veces que los nombres son acorde a lo
       * predefinido 
       * rutaN: almacena la ruta sub-i del vector ruta 
       * nombresRutaN: almacena los nombres de la ruta sub-i del vector ruta 
       * nombre: almacena
       * el nombre sub-j de nombresRutaN
       * contador: cuenta las veces que los nombres están bien
       * rtasCorrecta: Cantidad de respuestas correctas que deben existir
       */
      String[] nombresRutaN = JSONObject.getNames(rutaN);
      int contador = 0;
      int rtasCorrectas = nombresRutaN.length;
      for (int j = 0; j < nombresRutaN.length; j++) {
         String nombre = nombresRutaN[j];
         switch (nombre) {
         case "fecha":
            contador++;
            break;
         case "longitud":
            contador++;
            break;
         case "latitud":
            contador++;
            break;
         case "hora":
            contador++;
            break;
         case "altitud":
            contador++;
            break;
         }
      }
      /*
       * Como son 5 nombres, si el número de nombres bien (contador)
       * es igual a 5, devuelva true
       */
      if (contador == rtasCorrectas)

      {
         return true;
      } else

      {
         return false;
      }
   }
}
