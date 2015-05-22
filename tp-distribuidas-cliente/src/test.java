import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dto.ClienteDto;
import dto.HabilitadoDto;
import rmi.IAdministradorVarios;
import rmi.IAdministradorViaje;

public class test {


	private IAdministradorVarios administradorV;
	
	public test() {
		this.administradorV = obtenerStub();
	}
	
	//Obtener STUB
	private IAdministradorVarios obtenerStub(){
		try {
			//Para ejecutarlo, primero hay que ejecutar el servidor. 
			//Busca el servicio con en el nombre calcular. 
			return (IAdministradorVarios) (Naming.lookup("AdministradorVarios"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
	
		System.out.println("Prueba RMI");
		ClienteDto cliente = new ClienteDto("dni", 34000000);
		IAdministradorVarios admin = new test().obtenerStub();
		try {
			admin.altaCliente(cliente);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
