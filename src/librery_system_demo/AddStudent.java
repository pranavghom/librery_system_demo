package librery_system_demo;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class AddStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public AddStudent() {
		setLocation(-165, -547);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(10, 11, 636, 106);
		add(panel_2);
		
		JLabel lblAddNewBook_1 = new JLabel("ADD STUDENT");
		lblAddNewBook_1.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		lblAddNewBook_1.setBounds(183, 5, 269, 101);
		panel_2.add(lblAddNewBook_1);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(118, 155, 137, 33);
		add(lblNewLabel_1);
		
		JLabel lblAuthor_1 = new JLabel("Email Id");
		lblAuthor_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAuthor_1.setBounds(118, 199, 137, 33);
		add(lblAuthor_1);
		
		JLabel lblPublisher_1 = new JLabel("Publisher :");
		lblPublisher_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPublisher_1.setBounds(108, 255, 137, 33);
		add(lblPublisher_1);
		
		JLabel lblYear_1 = new JLabel("Year :");
		lblYear_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYear_1.setBounds(108, 306, 137, 27);
		add(lblYear_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(255, 151, 261, 33);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(255, 202, 261, 33);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 253, 261, 35);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(255, 305, 261, 33);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(255, 356, 261, 33);
		add(textField_4);
		
		JLabel lblLanguage_1 = new JLabel("Language");
		lblLanguage_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLanguage_1.setBounds(108, 344, 137, 33);
		add(lblLanguage_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(255, 407, 261, 33);
		add(textField_5);
		
		JLabel lblGenre_1 = new JLabel("Genre");
		lblGenre_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGenre_1.setBounds(108, 399, 137, 27);
		add(lblGenre_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.PINK);
		panel_1_1.setBounds(10, 550, 636, 106);
		add(panel_1_1);
		
		JButton btnCancle_1 = new JButton("Cancel");
		btnCancle_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancle_1.setBounds(379, 28, 137, 40);
		panel_1_1.add(btnCancle_1);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(133, 28, 137, 40);
		panel_1_1.add(btnNewButton_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(255, 458, 130, 33);
		add(textField_6);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity_1.setBounds(108, 450, 137, 33);
		add(lblQuantity_1);

	}

}
