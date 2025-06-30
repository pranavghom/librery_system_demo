package librery_system_demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Upadateform extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txttitle;
	private JTextField txtauthor;
	private JTextField txtpublisher;
	private JTextField txtyear;
	private JTextField txtlang;
	private JTextField txtgenre;
	private JTextField txtQuan;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upadateform updateframe = new Upadateform();
					updateframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Upadateform() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,0, 670, 689);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 11, 636, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddNewBook = new JLabel("Update Book");
		lblAddNewBook.setBounds(215, 0, 269, 101);
		lblAddNewBook.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		panel.add(lblAddNewBook);
		
		JLabel lblNewLabel = new JLabel("Titale :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(127, 214, 137, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAuthor.setBounds(127, 265, 137, 50);
		contentPane.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher :");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPublisher.setBounds(127, 316, 137, 50);
		contentPane.add(lblPublisher);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYear.setBounds(127, 372, 137, 40);
		contentPane.add(lblYear);
		
		txttitle = new JTextField();
		txttitle.setBounds(274, 222, 261, 40);
		contentPane.add(txttitle);
		txttitle.setColumns(10);
		
		txtauthor = new JTextField();
		txtauthor.setColumns(10);
		txtauthor.setBounds(274, 273, 261, 40);
		contentPane.add(txtauthor);
		
		txtpublisher = new JTextField();
		txtpublisher.setColumns(10);
		txtpublisher.setBounds(274, 324, 261, 40);
		contentPane.add(txtpublisher);
		
		txtyear = new JTextField();
		txtyear.setColumns(10);
		txtyear.setBounds(274, 375, 261, 40);
		contentPane.add(txtyear);
		
		txtlang = new JTextField();
		txtlang.setColumns(10);
		txtlang.setBounds(274, 426, 261, 40);
		contentPane.add(txtlang);
		
		txtQuan = new JTextField();
		txtQuan.setText("12");
		txtQuan.setBounds(405, 171, 130, 40);
		contentPane.add(txtQuan);
		txtQuan.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(296, 161, 99, 50);
		contentPane.add(lblQuantity);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(68, 109, 130, 40);
		contentPane.add(txtid);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(20, 109, 38, 50);
		contentPane.add(lblId);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLanguage.setBounds(127, 418, 137, 50);
		contentPane.add(lblLanguage);
		
		txtgenre = new JTextField();
		txtgenre.setColumns(10);
		txtgenre.setBounds(274, 477, 261, 40);
		contentPane.add(txtgenre);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGenre.setBounds(127, 474, 137, 40);
		contentPane.add(lblGenre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(10, 528, 636, 106);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/librariy manegemnet system", "root", "root");
				
				
				PreparedStatement ps = con.prepareStatement("update books2 set bookname =?,author=?,years=?,publisher=?,Language=?,Genre=?,Quantity=? where id = ?");
				ps.setString(1, txttitle.getText());
				ps.setString(2, txtauthor.getText());
				ps.setString(3, txtyear.getText());
				ps.setString(4, txtpublisher.getText());
				ps.setString(5, txtlang.getText());
				ps.setString(6, txtgenre.getText());
				ps.setString(7, txtQuan.getText());
				ps.setString(8,txtid.getText());
				
				  int rowsUpdated = ps.executeUpdate();
	                if (rowsUpdated > 0) {
	                    JOptionPane.showMessageDialog(Upadateform.this, 
	                        "Book updated successfully!");
	                } else {
	                    JOptionPane.showMessageDialog(Upadateform.this, 
	                        "No book found with ID: " + txtid.getText());
	                    clearFields();
	                }
	            
	        } catch (ClassNotFoundException e1) {
	            JOptionPane.showMessageDialog(Upadateform.this, 
	                "Database driver not found!", "Error", JOptionPane.ERROR_MESSAGE);
	            e1.printStackTrace();
	        } catch (SQLException e1) {
	            JOptionPane.showMessageDialog(Upadateform.this, 
	                "Database error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            e1.printStackTrace();
	        }
			}
		
			
		
		});
		
		btnNewButton.setBounds(244, 35, 137, 40);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnCancle = new JButton("Find");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				findBookById(txtid.getText());
				
				
				
			}
		});
		btnCancle.setBounds(231, 109, 137, 40);
		contentPane.add(btnCancle);
		btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
			}
		});
		btnNewButton_1.setBounds(557, 109, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Previes");
		btnNewButton_1_1.setBounds(440, 109, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		
	
	}






private void findBookById( String bookId1 ) {

    
    if (bookId1.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a book ID", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
	
  
    
    if (bookId1.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a book ID", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/librariy manegemnet system", 
                "root", "root");
             PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM books2 WHERE id = ?")) {
            
            ps.setString(1, bookId1);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Populate the text fields with retrieved data
                txttitle.setText(rs.getString("bookname"));
                txtauthor.setText(rs.getString("author"));
                txtyear.setText(rs.getString("years"));
                txtpublisher.setText(rs.getString("publisher"));
                txtlang.setText(rs.getString("Language"));
                txtgenre.setText(rs.getString("Genre"));
                txtQuan.setText(rs.getString("Quantity"));
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No book found with ID: " + bookId1, 
                    "Not Found", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            }
        }
    } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, 
            "Database driver not found!", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, 
            "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

private void clearFields() {
    txttitle.setText("");
    txtauthor.setText("");
    txtyear.setText("");
    txtpublisher.setText("");
    txtlang.setText("");
    txtgenre.setText("");
    txtQuan.setText("");
}	
}