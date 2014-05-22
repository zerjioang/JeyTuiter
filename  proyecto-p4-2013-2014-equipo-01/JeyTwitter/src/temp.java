import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;

import view.elementos.paneles.PanelEstadistica;
import view.parents.CustomJFrame;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class temp extends CustomJFrame {
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp frame = new temp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public temp() {
		super(600, 700);
		
		PanelEstadistica pe = new PanelEstadistica();
		getMainPanel().add(pe);
	}
}
