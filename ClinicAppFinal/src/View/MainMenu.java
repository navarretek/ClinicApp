package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.FrontEnd;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	public static FrontEnd frontEnd = new FrontEnd();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 5;
		gbc_lblWelcome.gridy = 1;
		contentPane.add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblClickOnA = new JLabel("Click on a button that corresponds to you:");
		GridBagConstraints gbc_lblClickOnA = new GridBagConstraints();
		gbc_lblClickOnA.gridheight = 2;
		gbc_lblClickOnA.insets = new Insets(0, 0, 5, 5);
		gbc_lblClickOnA.gridx = 5;
		gbc_lblClickOnA.gridy = 2;
		contentPane.add(lblClickOnA, gbc_lblClickOnA);
		
		JButton btnExistingPatient = new JButton("Existing Patient");
		btnExistingPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//call check in window
				ExistingPatient ep = null;
				ExistingPatient.newWindow(frontEnd);
				
			}
		});
		GridBagConstraints gbc_btnExistingPatient = new GridBagConstraints();
		gbc_btnExistingPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnExistingPatient.gridx = 5;
		gbc_btnExistingPatient.gridy = 4;
		contentPane.add(btnExistingPatient, gbc_btnExistingPatient);
		
		JButton btnNewPatient = new JButton("New Patient");
		GridBagConstraints gbc_btnNewPatient = new GridBagConstraints();
		gbc_btnNewPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewPatient.gridx = 5;
		gbc_btnNewPatient.gridy = 5;
		contentPane.add(btnNewPatient, gbc_btnNewPatient);
		
		JButton btnDoctorView = new JButton("Doctor View");
		GridBagConstraints gbc_btnDoctorView = new GridBagConstraints();
		gbc_btnDoctorView.insets = new Insets(0, 0, 5, 5);
		gbc_btnDoctorView.gridx = 6;
		gbc_btnDoctorView.gridy = 7;
		contentPane.add(btnDoctorView, gbc_btnDoctorView);
	}

}
