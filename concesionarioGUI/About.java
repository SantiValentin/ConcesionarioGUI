package concesionarioGUI;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("About");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 372, 158);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		textArea.setEditable(false);
		textArea.setText("Concesionario\r\n\r\nVersion: (1.8.2)\r\n\r\nMade By:\r\n\tSantiago Valentin Serrano");
		textArea.setBounds(10, 5, 362, 153);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(286, 169, 71, 23);
		getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
}