package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.CambioObligatorioContraseniaException;
import excepciones.ContraseniaIncorrectaException;
import excepciones.LoginIncorrectoException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioIncorrectoException;
import modelo.Operario;
import modelo.Sistema;
import vista.IVistaLogin;
import vista.VentanaLogin;
import vista.VentanaOperario;

public class ControladorLogin implements ActionListener {
	private IVistaLogin vista = null;
	
	public ControladorLogin(IVistaLogin vista) {
		this.vista = vista;
		this.vista.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Ingresar")) {
			
			try {
				Operario operario=null;
				operario=Sistema.getInstancia().loginOperario(this.vista.getUsername(), this.vista.getPassword());
				VentanaLogin v=(VentanaLogin)this.vista;
				v.setVisible(false);
				VentanaOperario vistaOperario=new VentanaOperario();
				ControladorOperario controladorOperario=new ControladorOperario(vistaOperario,operario);
				vistaOperario.completarTitulo(operario.getNombreUsuario());
				vistaOperario.setVisible(true);
			} catch (UsuarioIncorrectoException e1) {
				//e1.printStackTrace();
				this.vista.emergenteUsuarioIncorecto();
			} 
			catch (ContraseniaIncorrectaException e1) {
				//e1.printStackTrace();
				this.vista.emergetneContraseniaIncorrecta();
			}
			catch (UsuarioInactivoException e1) {
				//e1.printStackTrace();
				this.vista.emergenteUsuarioInactivo();
			}catch (CambioObligatorioContraseniaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}catch (LoginIncorrectoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				//NUNCA LLEGA A ESTA EXCEPTION
			}
			/*System.out.println("se presiono el boton ingresar");
			Iterator it= Sistema.getInstancia().getOperarios().iterator();
			boolean esta=false;
			Operario operario=null;
			while(it.hasNext() && !esta) {
				operario=(Operario)it.next();
				if(operario.getNombreUsuario().equals(this.vista.getUsername()))
					esta=true;
			}
			if(esta) {
				System.out.println("se encontro el operario");
				if(operario.getPassword().equals(this.vista.getPassword())) {
					//se logea
					//se oculta ventana login y se abre ventana operario
					VentanaLogin v=(VentanaLogin)this.vista;
					v.setVisible(false);
					VentanaOperario vistaOperario=new VentanaOperario();
					ControladorOperario controladorOperario=new ControladorOperario(vistaOperario,operario);
					vistaOperario.completarTitulo(operario.getNombreUsuario());
					vistaOperario.setVisible(true);
				}
				else {
					//throws contraseniaIncorrectaExcption()
					System.out.println("contrasenia incorrecta");
				}
			}
			else {
				//throws usuarioIncorrectoException()
				System.out.println("no se encontro al usuario");
			}*/ 
			//vista.actualizaBotones();
			//vista.actualizaCampos();
		}
	}
}
