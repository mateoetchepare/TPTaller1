package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import excepciones.PrecioUnitarioInvalidoException;
import excepciones.PromoProdInvalidaException;
import modelo.Producto;
import modelo.Promocion;
import modelo.PromocionProd;
import modelo.PromocionTemp;
import modelo.Sistema;
import vista.IVistaOperario;
import vista.IVistaPromocion;
import vista.VentanaPromociones;

public class ControladorPromocion implements ActionListener {
	IVistaPromocion vista = null;
	IVistaOperario vistaOperario = null;

	public ControladorPromocion(IVistaPromocion vistaProm, IVistaOperario vistaOp) {
		this.vista = vistaProm;
		this.vistaOperario = vistaOp;
		this.vista.addActionListener(this);
		actualizarListas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int cantMinima, precioUnitario, descuento;

		if (e.getActionCommand().equals("Listo")) {
			VentanaPromociones v = (VentanaPromociones) this.vista;
			v.setVisible(false);
			this.vistaOperario.setVisible(true);
		} else if (e.getActionCommand().equals("Agregar dias")) {
			if (!this.vista.getDias().isEmpty()) {
				if (this.vista.getListPromProd().getSelectedValue() != null
						|| this.vista.getListPromTemp().getSelectedValue() != null) {
					if (this.vista.getListPromProd().getSelectedValue() != null) {
						for (JRadioButton rb : this.vista.getDias()) {
							this.vista.getListPromProd().getSelectedValue().agregarDiaPromo(rb.getText());
						}
					}
					if (this.vista.getListPromTemp().getSelectedValue() != null) {
						for (JRadioButton rb : this.vista.getDias()) {
							this.vista.getListPromTemp().getSelectedValue().agregarDiaPromo(rb.getText());
						}
					}
				} else
					this.vista.emergenteNoHaySeleccionPromocion();// emergente no hay seleccion de ninguna promo
			} else
				this.vista.emergenteNoHayDiasSeleccionados();// emergente no hay dias seleccionados
		} else if (e.getActionCommand().equals("Agregar")) {
			if (this.vista.getListProductos().getSelectedValue() != null) {
				if (this.vista.getTipo() != null) {
				
					if (this.vista.getCantidadMin().length() > 0 && this.vista.getPrecioUnitario().length() > 0) {
						try {
							cantMinima = Integer.parseInt(this.vista.getCantidadMin());
							precioUnitario = Integer.parseInt(this.vista.getPrecioUnitario());
							PromocionProd promProd = new PromocionProd();
							promProd.setProducto(this.vista.getListProductos().getSelectedValue());
							promProd.setActivo(false);
							promProd.setDtoPorCantidad_PrecioUnitario(precioUnitario);
							promProd.setDtoPorCantidad_CantMinima(cantMinima);
							
								if (this.vista.getTipo().getText().equals("2x1")) {
									promProd.setAplicaDosPorUno(true);
									promProd.setAplicaDtoPorCantidad(false);
								} else {
									promProd.setAplicaDosPorUno(false);
									promProd.setAplicaDtoPorCantidad(true);
								}
							
							
							System.out.println(this.vista.getListProductos().getSelectedValue());
							Sistema.getInstancia().agregarPromocion(promProd);
						} catch (NumberFormatException exc) {
							this.vista.emergenteNoEsNumero();// emergente ingrese valores numericos enteros
						} catch (PrecioUnitarioInvalidoException e2) {
							this.vista.emergentePrecioUnitario(e2.getMessage());
						}

					} else
						this.vista.emergenteCamposPromProdIncompletos();// emergente completarlos campos cantidad minima y precio unitario
				} else
					this.vista.emergenteNoHaySeleccionTipo();// emergente seleccione tipo de promocion por producto

			} else
				this.vista.emergenteNoHayProductoSeleccionado();// emergente seleccione producto a agregar a la promo
		} else if (e.getActionCommand().equals("Activar")) {
			if (this.vista.getListPromProd().getSelectedValue() != null) {
				this.vista.getListPromProd().getSelectedValue().setActivo(true);
			} else
				this.vista.emergenteNoHayPromProdSelecionado();// emergente seleccione promocion por producto a activar
		} else if (e.getActionCommand().equals("Desactivar")) {
			if (this.vista.getListPromProd().getSelectedValue() != null) {
				this.vista.getListPromProd().getSelectedValue().setActivo(false);
			} else
				this.vista.emergenteNoHayPromProdSelecionado();// emergente seleccione promocion por producto a desactivar
		} else if (e.getActionCommand().equals("Agregar1")) {
			System.out.println("BOTON AGREGAR PROMO TEMP");
			if (this.vista.getNombre().length() > 0) {
				if (this.vista.getDescuento().length() > 0) {
					try {
						int des = Integer.parseInt(this.vista.getDescuento());
						if (des < 0 || des > 100)
							this.vista.emergenteNoEsNumeroValido();// emergente formato de descuento incorrecto ingrese numero entre 1 y 100
						else {
							if (this.vista.getFormaPago() != null) {
								PromocionTemp promTemp=new PromocionTemp();
								promTemp.setActivo(false);
								promTemp.setFormaPago(this.vista.getFormaPago().getText());
								promTemp.setNombre(this.vista.getNombre());
								promTemp.setPorcentajeDescuento(des);
								if(this.vista.getAcumulable()!=null) 
									promTemp.setEsAcumulable(true);
								else
									promTemp.setEsAcumulable(false);
								Sistema.getInstancia().agregarPromocion(promTemp);
							} else
								this.vista.emergenteNoHayFormaPago();// emergente seleccione forma de pago
						}
					} catch (NumberFormatException exc) {
						this.vista.emergenteNoEsNumeroValido();// emergente formato de descuento incorrecto ingrese numero entre 1 y 100
					}
				} else
					this.vista.emergenteCampoDescuentoVacio();// emergente complete el campo descuento
			} else
				this.vista.emergenteCampoNombreVacio();// emergente complete el campo nombre

		} else if (e.getActionCommand().equals("Activar1")) {
			if (this.vista.getListPromTemp().getSelectedValue() != null) {
				this.vista.getListPromTemp().getSelectedValue().setActivo(true);
			} else
				this.vista.emergenteNoHayPromTempSelecionado();// emergente seleccione promocion temporal a activar

		} else if (e.getActionCommand().equals("Desactivar1")) {
			if (this.vista.getListPromTemp().getSelectedValue() != null) {
				this.vista.getListPromTemp().getSelectedValue().setActivo(false);
			} else
				this.vista.emergenteNoHayPromTempSelecionado();// emergente seleccione promocion temporal a desactivar

		}

		actualizarListas();

	}

	public void actualizarListas() {
		this.vista.getModeloListaProductos().clear();
		for (Producto producto : Sistema.getInstancia().getProductos()) {
			this.vista.getModeloListaProductos().addElement(producto);
		}
		this.vista.getModeloListaPromProd().clear();
		this.vista.getModeloListaPromTemp().clear();
		for (Promocion prom : Sistema.getInstancia().getPromociones()) {
			if (prom instanceof PromocionProd) {
				PromocionProd promProd = (PromocionProd) prom;
				this.vista.getModeloListaPromProd().addElement(promProd);
			} else if (prom instanceof PromocionTemp) {
				PromocionTemp promTemp = (PromocionTemp) prom;
				this.vista.getModeloListaPromTemp().addElement(promTemp);
			}
		}
	}

}
