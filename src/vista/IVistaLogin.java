package vista;

import java.awt.event.ActionListener;

public interface IVistaLogin {
	String getUsername();
	String getPassword();
	void addActionListener(ActionListener listener);
}
