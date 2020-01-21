import java.rmi.RemoteException;

import UASI.WS_GRAL_wsdl.ClaseAlojamiento;
import UASI.WS_GRAL_wsdl.ClaseNoticias;
import UASI.WS_GRAL_wsdl.Pub_gralSoapProxy;

public class ListadoAlojamientos {
	
	public static void main(String[] args) throws RemoteException {
		
		
		System.out.println("Listado de alojamientos de la Universidad de Alicante");
		
		// crear cliente para consumir el servicio
		
		Pub_gralSoapProxy cliente = new Pub_gralSoapProxy();
		
		ClaseAlojamiento[] alojamientos = cliente.wsalojamientos();
		
		for (ClaseAlojamiento alojamiento : alojamientos) {
			System.out.println(alojamiento.getIdalojamiento());
		}
		
		System.out.println("------------------------------------------------------------");
		System.out.println("         NOTICIAS CASTELLANO TODAS");
		System.out.println("------------------------------------------------------------");
		
		ClaseNoticias[] noticiasCastelloTodas = cliente.wsnoticias("C", "");
		
		for (ClaseNoticias noticia : noticiasCastelloTodas) {
			System.out.println(noticia.getFechapublicacion() + noticia.getContenido());
		}
		
		System.out.println("------------------------------------------------------------");
		System.out.println("         NOTICIAS CASTELLANO A PARTIR DEL MES 9");
		System.out.println("------------------------------------------------------------");
		
		ClaseNoticias[] noticiasCastellanosOctubre = cliente.wsnoticias("C", "2015-10-01");
		
		for (ClaseNoticias noticia : noticiasCastellanosOctubre) {
			System.out.println(noticia.getFechapublicacion() + noticia.getContenido());
		}
		
	}

}
