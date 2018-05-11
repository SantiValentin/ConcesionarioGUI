package concesionarioGUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class Help extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Help() {
		setAlwaysOnTop(true);
		setTitle("Help");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 374, 403);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(
				"Concesionario\r\n\r\nVersion: (1.8.2)\r\n\r\nCar:" + "\r\n\r\n\t-Add: Adds a car to the list(Ctrl+C)"
						+ "\r\n\r\t-Delete: Deletes a car from the list(Ctrl+D)"
						+ "\r\n\r\t-Show List: Prints the entire list(Ctrl+P)" + "\r\n\r\nSearch:"
						+ "\r\n\r\n\t-Plate: Searches a car by plate"
						+ "\r\n\r\t-Color: Searches a car by color"
						+ "\r\n\r\nHelp:"
						+ "\r\n\r\n\t-Help: Displays this message"
						+ "\r\n\r\t-About: Displays info about the program");
		textArea.setBounds(0, 0, 382, 153);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 368, 329);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(267, 340, 91, 23);

		getContentPane().setLayout(null);
		getContentPane().add(scrollPane);
		getContentPane().add(btnOk);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}