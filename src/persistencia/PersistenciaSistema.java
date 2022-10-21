package persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenciaSistema<Sistema> implements IPersistencia<Sistema> {
	private FileOutputStream fileOut;
	private FileInputStream fileIn;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	@Override
	public void abrirInput(String nombre) throws IOException {
		this.fileIn = new FileInputStream(nombre);
		this.input = new ObjectInputStream(fileIn);
	}

	@Override
	public void abrirOutput(String nombre) throws IOException {
		this.fileOut = new FileOutputStream(nombre);
		this.output = new ObjectOutputStream(fileOut);
	}

	@Override
	public void cerrarInput() throws IOException {
		if (input != null)
			input.close();
	}

	@Override
	public void cerrarOutput() throws IOException {
		if (output != null)
			output.close();
	}

	@Override
	public void escribir(Sistema sistema) throws IOException {
		if (output != null)
			output.writeObject(sistema);
	}

	//averiguar como persisistir un singleton
	
	@Override
	public Sistema leer() throws IOException, ClassNotFoundException {
		Sistema sistema = null;
		if (input != null) {

			try {
				sistema = (Sistema) input.readObject();
			} catch (EOFException eof) {
				// TODO Auto-generated catch block
				System.out.println("EOF Exception");
			}
		}

		return sistema;
	}

}
