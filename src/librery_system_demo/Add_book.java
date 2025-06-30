package librery_system_demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.awt.event.ActionEvent;

public class Add_book extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txttitle;
	private JTextField txtauthor;
	private JTextField txtpublisher;
	private JTextField txtyear;
	private JTextField txtlang;
	private JTextField txtgenre;
	private JTextField txtQuan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_book frame = new Add_book();
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
	public Add_book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,00, 670, 726);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 11, 636, 106);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddNewBook = new JLabel("📚 Add New Book");
		lblAddNewBook.setBounds(183, 5, 269, 101);
		lblAddNewBook.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		panel.add(lblAddNewBook);
		
		JLabel lblNewLabel = new JLabel("Titale :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(108, 143, 137, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAuthor.setBounds(108, 194, 137, 50);
		contentPane.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher :");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPublisher.setBounds(108, 255, 137, 50);
		contentPane.add(lblPublisher);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYear.setBounds(108, 306, 137, 40);
		contentPane.add(lblYear);
		
		txttitle = new JTextField();
		txttitle.setBounds(255, 151, 261, 40);
		contentPane.add(txttitle);
		txttitle.setColumns(10);
		
		txtauthor = new JTextField();
		txtauthor.setColumns(10);
		txtauthor.setBounds(255, 202, 261, 40);
		contentPane.add(txtauthor);
		
		txtpublisher = new JTextField();
		txtpublisher.setColumns(10);
		txtpublisher.setBounds(255, 253, 261, 40);
		contentPane.add(txtpublisher);
		
		txtyear = new JTextField();
		txtyear.setColumns(10);
		txtyear.setBounds(255, 305, 261, 40);
		contentPane.add(txtyear);
		
		txtlang = new JTextField();
		txtlang.setColumns(10);
		txtlang.setBounds(255, 356, 261, 40);
		contentPane.add(txtlang);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLanguage.setBounds(108, 348, 137, 50);
		contentPane.add(lblLanguage);
		
		txtgenre = new JTextField();
		txtgenre.setColumns(10);
		txtgenre.setBounds(255, 407, 261, 40);
		contentPane.add(txtgenre);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGenre.setBounds(108, 399, 137, 50);
		contentPane.add(lblGenre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(10, 550, 636, 106);
		contentPane.add(panel_1);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setBounds(379, 28, 137, 40);
		panel_1.add(btnCancle);
		btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					 
				Connection Con = DbConnction.dbcon();
 					
 					
 					String author = txtauthor.getText();
					String bookname = txttitle.getText();
					String publisher = txtpublisher.getText();
					String year = txtyear.getText();
				
					
 					
 					PreparedStatement st = Con.prepareStatement("Insert into books2(bookname,author,years,publisher,Language,Genre,Quantity )values (?,?,?,?,?,?,?)");
			 st.setString(1, bookname);
			 st.setString(2, author);
			 st.setString(3, year);
			 st.setString(4, publisher);
			 st.setString(5, txtlang.getText());
			 st.setString(6,txtgenre.getText()); 
			 st.setString(7,txtQuan.getText());	
					st.executeUpdate();
					Con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(133, 28, 137, 40);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtQuan = new JTextField();
		txtQuan.setColumns(10);
		txtQuan.setBounds(255, 458, 130, 40);
		contentPane.add(txtQuan);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setBounds(108, 450, 137, 50);
		contentPane.add(lblQuantity);
		
	
	}
}
