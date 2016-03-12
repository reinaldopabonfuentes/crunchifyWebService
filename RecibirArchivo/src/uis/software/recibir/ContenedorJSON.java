package uis.software.recibir;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ContenedorJSON {
   /*
    * Contiene los Objetos, Arrays de Json y los métodos necesarios
    */
   private JSONObject objeto; // Todo el objeto JSON leído del archivo
   private String[] camposObjeto;

   public ContenedorJSON(String fileData) { 
      objeto = new JSONObject(fileData);
      camposObjeto = JSONObject.getNames(objeto);
   }

   public JSONObject getObjeto() {
      return objeto;
   }

   public String[] getCamposObjeto() {
      return camposObjeto;
   }

   public boolean checkQCamposObjeto() {
      /*
       * Verifica si la cantidad de campos en el objetoJSON es igual al
       * predefinido
       * qCamposObjeto: cantidad de campos predefinidos
       * nVector:Tamaño del vector de nombres que tiene el archivo
       */
      int qCamposObjeto = 7;
      int nVector = camposObjeto.length;
      if (nVector == qCamposObjeto) {
         return true;
      } else {
         return false;
      }
   }

   public boolean checkQCamposRuta() {
      /*
       * Verifica si la cantidad de campos en cada componente del vector Ruta
       * es igual al predefinido
       * qCamposRuta: cantidad de campos predefinidos
       * nRuta: tamaño del vector ruta
       * rutaN: objeto sub-i del vector ruta
       * camposRutaN: vector de los nombres del objeto rutaN
       * nCamposRutaN: tamaño del vector camposRutaN
       */
      int qCamposRuta = 5;
      JSONArray ruta = (JSONArray) objeto.get("ruta");
      int nRuta = ruta.length();
      for (int i = 0; i < nRuta; i++) {
         JSONObject rutaN = ruta.getJSONObject(i);
         String[] camposRutaN = JSONObject.getNames(rutaN);
         int nCamposRutaN = camposRutaN.length;
         if (nCamposRutaN != qCamposRuta) {
            return false;
         }
      }
      return true;

   }

   public boolean checkCamposArchivo() {
      /*
       * Devuelve true si los nombres del archivo JSON son iguales a lo
       * predefinido contador: cuenta las veces que los nombres están bien
       * rtasCorrectas: Cantidad de respuestas correctas que deben existir
       * nombres: Vector de nombres del archivo qNames:Cantidad de nombres que
       * deben existir para que se pueda validar
       */
      int qNames = 7;
      int contador = 0;
      String[] nombres = JSONObject.getNames(objeto);
      for (int i = 0; i < nombres.length; i++) {
         String string = nombres[i];
         switch (string) {
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
      /*
       * Si hay tantos elementos bien (contador) como la cantidad de nombres
       * predefinidos (qNames), todos los elementos del archivo tienen los
       * nombres OK
       */
      if (contador == qNames) {
         return true;
      } else {
         return false;
      }
   }

   public boolean checkCamposRuta() {
      /*
       * Devuelve true si todos los elementos del JSONArray ruta tienen los
       * nombres de acuerdo a lo predefinido rutaN: objeto de cada posición i
       * del vector ruta nVector:Tamaño del vector ruta respuestas: Almacena
       * true o false, dependiendo de elemento del vector ruta
       */
      JSONArray ruta = (JSONArray) objeto.get("ruta");
      int nVector = ruta.length();
      int qNames = 5;
      int prueba = 0;
      boolean[] respuesta = new boolean[nVector];
      for (int i = 0; i < nVector; i++) {
         JSONObject rutaN = ruta.getJSONObject(i);
         String[] nombresRutaN = JSONObject.getNames(rutaN);
         respuesta[i] = checkCamposRutaStringArray(nombresRutaN, qNames);
      }
      for (int i = 0; i < nVector; i++) {
         if (respuesta[i] != true) {
            prueba = prueba + 1;
         }
      }
      if (prueba == 0) {
         return true;
      } else {
         return false;
      }
   }

   public boolean checkCamposRutaStringArray(String[] nombresRutaN, int qNames) {
      /*
       * Devuelve true si los nombres del objeto rutaN son iguales a los
       * predefinidos contador: cuenta las veces que los nombres son acorde a lo
       * predefinido rutaN: almacena la ruta sub-i del vector ruta nombresRutaN:
       * almacena los nombres de la ruta sub-i del vector ruta nombre: almacena
       * el nombre sub-j de nombresRutaN contador: cuenta las veces que los
       * nombres están bien qNames: Cantidad de respuestas correctas que deben
       * existir nVector = tamaño del vector ruta pasado por el archivo
       */
      int nVector = nombresRutaN.length;
      boolean decision = false;
      int contador = 0;
      // Debe ir hasta qNames porque se asume que ya pasó la excepción y se
      // corrigió
      for (int j = 0; j < nVector; j++) {
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
       * Como son 5 nombres, si el número de nombres bien (contador) es igual a
       * qNames, devuelva true
       */
      if (contador == qNames) {
         decision = true;
         return decision;
      } else {
         return decision;
      }

   }

}
