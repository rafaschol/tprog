

import java.util.Arrays;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.datatype.DatatypeConfigurationException;

import servidor.DataContenedor;
import servidor.DataInstitucion;
import servidor.DataItem;
import servidor.MailRepetidoException_Exception;
import servidor.UsuarioRepetidoException_Exception;

@WebListener
public class InicioListener implements ServletContextListener {
	


    public InicioListener() {
    	
    	
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        DataContenedor contString = port.listarDataInstituciones();
		DataInstitucion[] colInst = contString.getInstituciones().toArray(new DataInstitucion[0]);
        
      
		
		
		String[] instituciones = Arrays.stream(colInst)
				.map(institucion -> institucion.getNombre()).toArray(String[]::new);
		sce.getServletContext().setAttribute("instituciones", instituciones);
		
		DataContenedor contString2 = port.listarCategorias();
		String[] categorias = contString2.getStrings().toArray(new String[0]);
		
		
		sce.getServletContext().setAttribute("categorias", categorias);
    }
	
}
