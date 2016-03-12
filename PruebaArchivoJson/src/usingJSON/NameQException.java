package usingJSON;

public class NameQException extends Exception {
   /*Q stands for Quantity
    *NameQuantityException
    *Si no tiene el mismo número de elementos, arroja esta excepción 
    */
   
   public NameQException(String mensaje) {
      super(mensaje);
   }
   
}