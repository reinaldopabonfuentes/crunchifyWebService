package usingJSON;

public class NameQException extends Exception {
   /*Q stands for Quantity
    *NameQuantityException
    *Si no tiene el mismo n�mero de elementos, arroja esta excepci�n 
    */
   
   public NameQException(String mensaje) {
      super(mensaje);
   }
   
}