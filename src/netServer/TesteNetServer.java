package netServer;

/**
 * Classe principal que conter� o m�todo main para inicializa��o do servidor.
 * 
 * 
 * @author SHOW13
 *
 */

public class TesteNetServer {

	private static INetServer iNet = new ControllerNetServer();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		iNet.initServer();

	}

}
