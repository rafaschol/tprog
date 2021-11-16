
package servidor;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Publicador", targetNamespace = "http://servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    net.java.dev.jaxb.array.ObjectFactory.class,
    servidor.ObjectFactory.class
})
public interface Publicador {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws CuponeraCompradaException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/compraCuponeraRequest", output = "http://servidor/Publicador/compraCuponeraResponse", fault = {
        @FaultAction(className = CuponeraCompradaException_Exception.class, value = "http://servidor/Publicador/compraCuponera/Fault/CuponeraCompradaException")
    })
    public void compraCuponera(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        XMLGregorianCalendar arg2)
        throws CuponeraCompradaException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns servidor.DataUsuario
     * @throws DatosLoginIncorrectosException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/loginRequest", output = "http://servidor/Publicador/loginResponse", fault = {
        @FaultAction(className = DatosLoginIncorrectosException_Exception.class, value = "http://servidor/Publicador/login/Fault/DatosLoginIncorrectosException")
    })
    public DataUsuario login(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws DatosLoginIncorrectosException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws UsuarioYaSigueAUsuarioException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/seguirUsuarioRequest", output = "http://servidor/Publicador/seguirUsuarioResponse", fault = {
        @FaultAction(className = UsuarioYaSigueAUsuarioException_Exception.class, value = "http://servidor/Publicador/seguirUsuario/Fault/UsuarioYaSigueAUsuarioException")
    })
    public void seguirUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws UsuarioYaSigueAUsuarioException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/dejarSeguirUsuarioRequest", output = "http://servidor/Publicador/dejarSeguirUsuarioResponse")
    public void dejarSeguirUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarUsuariosWebRequest", output = "http://servidor/Publicador/listarUsuariosWebResponse")
    public DataContenedor listarUsuariosWeb();

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/mostrarDataUsuarioWebRequest", output = "http://servidor/Publicador/mostrarDataUsuarioWebResponse")
    public DataUsuario mostrarDataUsuarioWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarCuponerasActividadWebRequest", output = "http://servidor/Publicador/listarCuponerasActividadWebResponse")
    public DataContenedor listarCuponerasActividadWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarPremiosSocioRequest", output = "http://servidor/Publicador/listarPremiosSocioResponse")
    public DataContenedor listarPremiosSocio(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws ClaseVaciaException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/realizarSorteoRequest", output = "http://servidor/Publicador/realizarSorteoResponse", fault = {
        @FaultAction(className = ClaseVaciaException_Exception.class, value = "http://servidor/Publicador/realizarSorteo/Fault/ClaseVaciaException")
    })
    public void realizarSorteo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws ClaseVaciaException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/mostrarSociosGanadoresRequest", output = "http://servidor/Publicador/mostrarSociosGanadoresResponse")
    public DataContenedor mostrarSociosGanadores(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "ValorarProfesor")
    @Action(input = "http://servidor/Publicador/ValorarProfesorRequest", output = "http://servidor/Publicador/ValorarProfesorResponse")
    public void valorarProfesor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarDataClasesVigentesRequest", output = "http://servidor/Publicador/listarDataClasesVigentesResponse")
    public DataContenedor listarDataClasesVigentes(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @param arg8
     * @throws ActividadRepetidaException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/altaActividadDeportivaWebRequest", output = "http://servidor/Publicador/altaActividadDeportivaWebResponse", fault = {
        @FaultAction(className = ActividadRepetidaException_Exception.class, value = "http://servidor/Publicador/altaActividadDeportivaWeb/Fault/ActividadRepetidaException")
    })
    public void altaActividadDeportivaWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        int arg3,
        @WebParam(name = "arg4", partName = "arg4")
        float arg4,
        @WebParam(name = "arg5", partName = "arg5")
        XMLGregorianCalendar arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        StringArray arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8)
        throws ActividadRepetidaException_Exception
    ;

    /**
     * 
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarActividadesWebRequest", output = "http://servidor/Publicador/listarActividadesWebResponse")
    public DataContenedor listarActividadesWeb();

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarDataCuponeraRequest", output = "http://servidor/Publicador/listarDataCuponeraResponse")
    public DataContenedor listarDataCuponera(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/buscarRequest", output = "http://servidor/Publicador/buscarResponse")
    public DataContenedor buscar(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataActividad
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarDataActividadProfesorRequest", output = "http://servidor/Publicador/listarDataActividadProfesorResponse")
    public DataActividad listarDataActividadProfesor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/lisarSociosClaseRequest", output = "http://servidor/Publicador/lisarSociosClaseResponse")
    public DataContenedor lisarSociosClase(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/finalizarActividadDeportivaRequest", output = "http://servidor/Publicador/finalizarActividadDeportivaResponse")
    public void finalizarActividadDeportiva(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/marcarActividadFavoritaRequest", output = "http://servidor/Publicador/marcarActividadFavoritaResponse")
    public void marcarActividadFavorita(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/desmarcarActividadFavoritaRequest", output = "http://servidor/Publicador/desmarcarActividadFavoritaResponse")
    public void desmarcarActividadFavorita(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarActividadesNoEnCuponeraRequest", output = "http://servidor/Publicador/listarActividadesNoEnCuponeraResponse")
    public DataContenedor listarActividadesNoEnCuponera(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/getCategorasCuponeraRequest", output = "http://servidor/Publicador/getCategorasCuponeraResponse")
    public DataContenedor getCategorasCuponera(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarDataActividadesRequest", output = "http://servidor/Publicador/listarDataActividadesResponse")
    public DataContenedor listarDataActividades(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns servidor.DataProfesor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/dataPRequest", output = "http://servidor/Publicador/dataPResponse")
    public DataProfesor dataP();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg10
     * @param arg11
     * @param arg7
     * @param arg6
     * @param arg9
     * @param arg8
     * @throws ClaseRepetidaException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/altaClaseRequest", output = "http://servidor/Publicador/altaClaseResponse", fault = {
        @FaultAction(className = ClaseRepetidaException_Exception.class, value = "http://servidor/Publicador/altaClase/Fault/ClaseRepetidaException")
    })
    public void altaClase(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        XMLGregorianCalendar arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2,
        @WebParam(name = "arg3", partName = "arg3")
        int arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        XMLGregorianCalendar arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8,
        @WebParam(name = "arg9", partName = "arg9")
        String arg9,
        @WebParam(name = "arg10", partName = "arg10")
        String arg10,
        @WebParam(name = "arg11", partName = "arg11")
        int arg11)
        throws ClaseRepetidaException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @throws CuponeraRepetidaException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/altaCuponeraRequest", output = "http://servidor/Publicador/altaCuponeraResponse", fault = {
        @FaultAction(className = CuponeraRepetidaException_Exception.class, value = "http://servidor/Publicador/altaCuponera/Fault/CuponeraRepetidaException")
    })
    public void altaCuponera(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        XMLGregorianCalendar arg2,
        @WebParam(name = "arg3", partName = "arg3")
        XMLGregorianCalendar arg3,
        @WebParam(name = "arg4", partName = "arg4")
        float arg4,
        @WebParam(name = "arg5", partName = "arg5")
        XMLGregorianCalendar arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        float arg7)
        throws CuponeraRepetidaException_Exception
    ;

    /**
     * 
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarCategoriasRequest", output = "http://servidor/Publicador/listarCategoriasResponse")
    public DataContenedor listarCategorias();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg10
     * @param arg7
     * @param arg6
     * @param arg9
     * @param arg8
     * @throws MailRepetidoException_Exception
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/altaProfesorRequest", output = "http://servidor/Publicador/altaProfesorResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://servidor/Publicador/altaProfesor/Fault/UsuarioRepetidoException"),
        @FaultAction(className = MailRepetidoException_Exception.class, value = "http://servidor/Publicador/altaProfesor/Fault/MailRepetidoException")
    })
    public void altaProfesor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        XMLGregorianCalendar arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8,
        @WebParam(name = "arg9", partName = "arg9")
        String arg9,
        @WebParam(name = "arg10", partName = "arg10")
        String arg10)
        throws MailRepetidoException_Exception, UsuarioRepetidoException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     * @throws MailRepetidoException_Exception
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/altaSocioRequest", output = "http://servidor/Publicador/altaSocioResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://servidor/Publicador/altaSocio/Fault/UsuarioRepetidoException"),
        @FaultAction(className = MailRepetidoException_Exception.class, value = "http://servidor/Publicador/altaSocio/Fault/MailRepetidoException")
    })
    public void altaSocio(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        XMLGregorianCalendar arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6)
        throws MailRepetidoException_Exception, UsuarioRepetidoException_Exception
    ;

    /**
     * 
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarDataInstitucionesRequest", output = "http://servidor/Publicador/listarDataInstitucionesResponse")
    public DataContenedor listarDataInstituciones();

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataActividad
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarDataActividadRequest", output = "http://servidor/Publicador/listarDataActividadResponse")
    public DataActividad listarDataActividad(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataClase
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/obtenerDataClaseRequest", output = "http://servidor/Publicador/obtenerDataClaseResponse")
    public DataClase obtenerDataClase(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarDataClasesRequest", output = "http://servidor/Publicador/listarDataClasesResponse")
    public DataContenedor listarDataClases(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarCuponerasRequest", output = "http://servidor/Publicador/listarCuponerasResponse")
    public DataContenedor listarCuponeras();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/modificarDatosSocioRequest", output = "http://servidor/Publicador/modificarDatosSocioResponse")
    public void modificarDatosSocio(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        XMLGregorianCalendar arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/modificarDatosProfesorRequest", output = "http://servidor/Publicador/modificarDatosProfesorResponse")
    public void modificarDatosProfesor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        XMLGregorianCalendar arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataCuponera
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/consultaCuponeraRequest", output = "http://servidor/Publicador/consultaCuponeraResponse")
    public DataCuponera consultaCuponera(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarActividadesIngresadasRequest", output = "http://servidor/Publicador/listarActividadesIngresadasResponse")
    public DataContenedor listarActividadesIngresadas();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @throws CuposAgotadosException_Exception
     * @throws ClasesRestantesException_Exception
     * @throws SocioRegistradoException_Exception
     * @throws CuponeraVencidaException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/registrarSocioRequest", output = "http://servidor/Publicador/registrarSocioResponse", fault = {
        @FaultAction(className = CuposAgotadosException_Exception.class, value = "http://servidor/Publicador/registrarSocio/Fault/CuposAgotadosException"),
        @FaultAction(className = SocioRegistradoException_Exception.class, value = "http://servidor/Publicador/registrarSocio/Fault/SocioRegistradoException"),
        @FaultAction(className = ClasesRestantesException_Exception.class, value = "http://servidor/Publicador/registrarSocio/Fault/ClasesRestantesException"),
        @FaultAction(className = CuponeraVencidaException_Exception.class, value = "http://servidor/Publicador/registrarSocio/Fault/CuponeraVencidaException")
    })
    public void registrarSocio(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        boolean arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        XMLGregorianCalendar arg5)
        throws ClasesRestantesException_Exception, CuponeraVencidaException_Exception, CuposAgotadosException_Exception, SocioRegistradoException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns servidor.DataContenedor
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/Publicador/listarCuponerasActividadRequest", output = "http://servidor/Publicador/listarCuponerasActividadResponse")
    public DataContenedor listarCuponerasActividad(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws ActividadDeCuponeraRepetidaException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/Publicador/agregarActividadACuponeraRequest", output = "http://servidor/Publicador/agregarActividadACuponeraResponse", fault = {
        @FaultAction(className = ActividadDeCuponeraRepetidaException_Exception.class, value = "http://servidor/Publicador/agregarActividadACuponera/Fault/ActividadDeCuponeraRepetidaException")
    })
    public void agregarActividadACuponera(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2)
        throws ActividadDeCuponeraRepetidaException_Exception
    ;

}
