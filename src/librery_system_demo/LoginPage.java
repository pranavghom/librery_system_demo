package librery_system_demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginPage {
	 int i =0;
	private JFrame frame;
	private JTextField txtuser;
	private JTextField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(80, 00, 1138, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 11, 1105, 161);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setBounds(464, 11, 320, 37);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 37));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 74, 1071, 76);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Librariy manegement system");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 37));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(233, 150, 122));
		panel_2.setBounds(20, 185, 1077, 438);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(273, 132, 79, 20);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(273, 206, 112, 33);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtuser = new JTextField();
		txtuser.setBounds(391, 128, 259, 33);
		panel_2.add(txtuser);
		txtuser.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setBounds(391, 208, 259, 33);
		panel_2.add(txtpass);
		txtpass.setColumns(10);
		
	
		
		JLabel lbleror = new JLabel("");
		lbleror.setForeground(Color.RED);
		lbleror.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbleror.setBackground(new Color(255, 0, 0));
		lbleror.setBounds(166, 149, 214, 26);
		panel_2.add(lbleror);
		
		JButton btnlogin = new JButton("LogIn");
		btnlogin.setBounds(352, 295, 112, 45);
		panel_2.add(btnlogin);
		
		JComboBox combo = new JComboBox();
		combo.setToolTipText("Select");
		combo.setModel(new DefaultComboBoxModel(new String[] {"Select", "Student", "Admin"}));
		combo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		combo.setBounds(391, 67, 106, 26);
		panel_2.add(combo);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpass.setText(null);
				txtuser.setText(null);
			}
		});
		btnClear.setBounds(512, 295, 112, 45);
		panel_2.add(btnClear);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(combo.getSelectedItem()=="Admin") {
				
			         	if(txtuser.getText().equals("admin")& txtpass.getText().equals("1")) 
				               {
				                	frame.setVisible(false);
				                	Adnim2 frame2 = new Adnim2();
									frame2.setVisible(true);
				               }
				
									
				        else{
					
			                  i++;
			
			                	switch(i) {
				                            case 1:
					                               lbleror.setText("try again");
					                               break;
				                            case 2:
					                               lbleror.setText("try again later");
					                               break;
				                            case 3:
					                               lbleror.setText("try again after some time");
					                               break;
				                            case 4:
					
					                         
					                             frame.setVisible(false);
				                             }
				
		        	          }
				}
				else {
					
				}
				
			}

		

			
		});
	
	}
}
