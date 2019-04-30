package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.SliderUI;

import Controller.FrontEnd;
import Controller.PatientHelper;
import Model.Patient;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;

public class ExistingPatient extends JFrame {

	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtLName;
	private static FrontEnd frontEnd;

	/**
	 * Launch the application.
	 */
	public static void newWindow(FrontEnd fe) {
		frontEnd = fe;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ExistingPatient frame = new ExistingPatient();
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
	public ExistingPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEnterFirstName = new JLabel("Enter first name:");
		GridBagConstraints gbc_lblEnterFirstName = new GridBagConstraints();
		gbc_lblEnterFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblEnterFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterFirstName.gridx = 1;
		gbc_lblEnterFirstName.gridy = 1;
		contentPane.add(lblEnterFirstName, gbc_lblEnterFirstName);
		
		txtFName = new JTextField();
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.anchor = GridBagConstraints.WEST;
		gbc_txtFName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 1;
		contentPane.add(txtFName, gbc_txtFName);
		txtFName.setColumns(10);
		
		JLabel lblEnterLastName = new JLabel("Enter last name:");
		GridBagConstraints gbc_lblEnterLastName = new GridBagConstraints();
		gbc_lblEnterLastName.anchor = GridBagConstraints.EAST;
		gbc_lblEnterLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterLastName.gridx = 1;
		gbc_lblEnterLastName.gridy = 2;
		contentPane.add(lblEnterLastName, gbc_lblEnterLastName);
		
		txtLName = new JTextField();
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLName.anchor = GridBagConstraints.WEST;
		gbc_txtLName.gridx = 2;
		gbc_txtLName.gridy = 2;
		contentPane.add(txtLName, gbc_txtLName);
		txtLName.setColumns(10);
		
		JSlider sliderPriority = new JSlider();
		sliderPriority.setSnapToTicks(true);
		sliderPriority.setPaintTicks(true);
		sliderPriority.setMajorTickSpacing(10);
		GridBagConstraints gbc_sliderPriority = new GridBagConstraints();
		gbc_sliderPriority.insets = new Insets(0, 0, 5, 5);
		gbc_sliderPriority.gridx = 2;
		gbc_sliderPriority.gridy = 4;
		contentPane.add(sliderPriority, gbc_sliderPriority);
		
		JLabel labelWarning = new JLabel("");
		labelWarning.setForeground(Color.RED);
		labelWarning.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_labelWarning = new GridBagConstraints();
		gbc_labelWarning.insets = new Insets(0, 0, 5, 5);
		gbc_labelWarning.gridx = 2;
		gbc_labelWarning.gridy = 3;
		contentPane.add(labelWarning, gbc_labelWarning);
		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Search for the patient
				PatientHelper ph = new PatientHelper();
				Patient found = ph.searchForPatientByName(txtFName.getText() , txtLName.getText());
				
				//Check in patient into queue
				if(found != null) {
					int priority = sliderPriority.getValue();
					frontEnd.addToQ(found, priority);
					JOptionPane.showMessageDialog(null, "Checked in!");
					
				}
				// if not found print out invalidd user patient
				else labelWarning.setText("Unregistered Patient");
			}
		});
		
		JLabel lblEmergeny = new JLabel("Emergeny:");
		GridBagConstraints gbc_lblEmergeny = new GridBagConstraints();
		gbc_lblEmergeny.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmergeny.gridx = 1;
		gbc_lblEmergeny.gridy = 4;
		contentPane.add(lblEmergeny, gbc_lblEmergeny);
		
		
		
		
		GridBagConstraints gbc_btnCheckIn = new GridBagConstraints();
		gbc_btnCheckIn.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheckIn.gridx = 1;
		gbc_btnCheckIn.gridy = 5;
		contentPane.add(btnCheckIn, gbc_btnCheckIn);
		
		JButton btnEdit = new JButton("Edit");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 5;
		contentPane.add(btnEdit, gbc_btnEdit);
	}

}
