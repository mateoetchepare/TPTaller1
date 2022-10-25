package persistencia;

import java.io.IOException;

public class Persistir {

	public static void escribirSistema() {
		IPersistencia persistencia=new PersistenciaSistema();
		
		try {
			persistencia.abrirOutput("Sistema.bin");
			SistemaDTO sistemaDTO=UtilSistema.sistemaDTOfromSistema();
			persistencia.escribir(sistemaDTO);
			persistencia.cerrarOutput();
			System.out.println("Sistema guardado exitosamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void leerSistema() {
		IPersistencia persistencia=new PersistenciaSistema();
		
		try {
			persistencia.abrirInput("Sistema.bin");
			SistemaDTO sistemaDTO=(SistemaDTO)persistencia.leer();
			UtilSistema.sistemaFromSistemaDTO(sistemaDTO);
			persistencia.cerrarInput();
			System.out.println("Sistema recuperado exitosamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
