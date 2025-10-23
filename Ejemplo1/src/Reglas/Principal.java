
package Reglas;

public class Principal {
    public static void main(String[] args) {
        
         // Creando una instancia de una subclase y almacenándola en el tipo de la superclase.
        Rule simpleRule = new BusinessRule () ;
        
        System.out.println("Metodo 1:");
        // Determinando el tipo de objeto en Java usando la palabra clave instanceof  
        System.out.println("Comprobando el tipo de objeto en Java usando instanceof ==>\n" ) ;
        if ( simpleRule instanceof Rule ){
            System.out.println ( "Es una instancia de Rule" ) ;
        }
        if ( simpleRule instanceof SystemRule ) {
            System.out.println ( "Es una instancia de SystemRule" ) ;
        }
        if ( simpleRule instanceof BusinessRule ){
            System.out.println ( "Es una instancia de BusinessRule" ) ;
        }
        
        System.out.println("\n\nMetodo 2:");
        // determinando el tipo de objeto en Java usando el método getClass()
        System.out . println ( "Comprobar el tipo de objeto en Java usando getClass() ==>\n" ) ;
        if ( simpleRule.getClass ( ) == Rule.class ) {
            System.out.println ( "Es una instancia de Rule" ) ; 
        }
        if ( simpleRule.getClass ( ) == SystemRule.class) {
            System.out.println ( "LEes una instancia de SystemRule" ) ;
        }
        if ( simpleRule.getClass () == BusinessRule.class) {
            System.out.println ( "Es una instancia de BusinessRule" ) ;
        }
         // Determinar el tipo de objeto en Java usando el método isInstance( )     
         
        System.out.println("\n\nMetodo 3:");
        // isInstance() es similar al operador instanceof y devuelve verdadero incluso si el objeto pertenece a unasubclase.
        System.out.println( "Comprobar el tipo de objeto en Java usando isInstance() ==>\n" ) ;
        if ( Rule.class.isInstance ( simpleRule ) ){ 
            System.out.println ( "Es una instancia de Rule" ) ;
        }  
        if ( SystemRule.class.isInstance ( simpleRule ) ) {
            System.out.println ( "Es una instancia de SystemRule" ) ;
        }
        if ( BusinessRule.class.isInstance ( simpleRule ) ){
            System.out.println ( "Es una instancia de BusinessRule " ) ;
        }   
        // Salida: Comprobación del tipo de objeto en Java usando instanceof == > SystemRule es una instancia de Rule SystemRule es una instancia de BusinessRule.
    }  
}
