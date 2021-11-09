package servidor;


public class Main {

 
    public static void main(String[] args) {
        // TODO code application logic here
        PublicadorUsuario pUsuario = new PublicadorUsuario();
        PublicadorCuponera pCuponera = new PublicadorCuponera();
        PublicadorInstitucion pInstitucion = new PublicadorInstitucion();
        
        pUsuario.publicar();
        pInstitucion.publicar();
        pCuponera.publicar();
    }

}