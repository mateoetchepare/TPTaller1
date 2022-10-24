package persistencia;

import modelo.Sistema;

public class UtilSistema {
	
	public static SistemaDTO sistemaDTOfromSistema() {
		SistemaDTO sistemaDTO = new SistemaDTO();
		
		sistemaDTO.setOperarios(Sistema.getInstancia().getOperarios());
		sistemaDTO.setMozos(Sistema.getInstancia().getMozos());
		sistemaDTO.setProductos(Sistema.getInstancia().getProductos());
		sistemaDTO.setMesas(Sistema.getInstancia().getMesas());
		sistemaDTO.setPromociones(Sistema.getInstancia().getPromociones());
		sistemaDTO.setComandas(Sistema.getInstancia().getComandas());
		sistemaDTO.setFacturas(Sistema.getInstancia().getFacturas());
		sistemaDTO.setNombre(Sistema.getInstancia().getNombre());
		sistemaDTO.setSueldo(Sistema.getInstancia().getSueldo());
		
		return sistemaDTO;
		
	}
	
	public static Sistema sistemaFromSistemaDTO(SistemaDTO sistemaDTO) {
		Sistema sistema= Sistema.getInstancia();
		
		sistema.setOperarios(sistemaDTO.getOperarios());
		sistema.setMozos(sistemaDTO.getMozos());
		sistema.setProductos(sistemaDTO.getProductos());
		sistema.setMesas(sistemaDTO.getMesas());
		sistema.setPromociones(sistemaDTO.getPromociones());
		sistema.setComandas(sistemaDTO.getComandas());
		sistema.setFacturas(sistemaDTO.getFacturas());
		sistema.setNombre(sistemaDTO.getNombre());
		sistema.setSueldo(sistemaDTO.getSueldo());
		
		return sistema;
	}
}
