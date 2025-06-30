package librery_system_demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Adnim2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtrollno;
	private JTextField txtfname;
	private JTextField txtemail;
	private JTextField txtlname;
	private JTextField txtaddress;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtauthor;
	private JTextField txtganre;
	private JTextField txtlang;
	private JTextField txtyear;
	private JTextField txtpulisher;
	private JTextField txttitale;
	private JTextField txtquantity;
	private JTextField txtid;
	private JTable table_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adnim2 frame2 = new Adnim2();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Adnim2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\prana\\OneDrive\\Pictures\\Screenshots\\Screenshot (285).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(00, 00, 1281, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(10, 83, 1281, 641);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadBooksFromDB();
			}
		});
		panel.setForeground(Color.WHITE);
		panel.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Books", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(637, 5, 1, 1);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Roll No");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(34, 72, 125, 34);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblName_2.setBounds(34, 120, 61, 34);
		panel_1_1.add(lblName_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Email");
		lblNewLabel_1_1_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(34, 215, 66, 34);
		panel_1_1.add(lblNewLabel_1_1_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 73, 198, 34);
		panel_1_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 121, 198, 34);
		panel_1_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 217, 198, 34);
		panel_1_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 25, 198, 37);
		panel_1_1.add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("UID");
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(34, 25, 125, 34);
		panel_1_1.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(10, 326, 348, 43);
		panel_1_1.add(btnNewButton_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(160, 169, 198, 34);
		panel_1_1.add(textField_6);
		
		JLabel lblName_1_1 = new JLabel("LastName");
		lblName_1_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblName_1_1.setBounds(34, 167, 89, 34);
		panel_1_1.add(lblName_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(160, 265, 198, 34);
		panel_1_1.add(textField_7);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Address");
		lblNewLabel_1_1_2_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1.setBounds(34, 265, 89, 34);
		panel_1_1.add(lblNewLabel_1_1_2_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBounds(10, 377, 348, 43);
		panel_1_1.add(btnUpdate_1);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(10, 431, 348, 43);
		panel_1_1.add(btnDelete_1);
		
		JButton btnNewButton_3_1 = new JButton("New button");
		btnNewButton_3_1.setBounds(40, 533, 119, 43);
		panel_1_1.add(btnNewButton_3_1);
		
		txtauthor = new JTextField();
		txtauthor.setColumns(10);
		txtauthor.setBounds(113, 114, 198, 37);
		panel.add(txtauthor);
		
		txtganre = new JTextField();
		txtganre.setColumns(10);
		txtganre.setBounds(113, 297, 198, 34);
		panel.add(txtganre);
		
		txtlang = new JTextField();
		txtlang.setColumns(10);
		txtlang.setBounds(113, 252, 198, 34);
		panel.add(txtlang);
		
		txtyear = new JTextField();
		txtyear.setColumns(10);
		txtyear.setBounds(113, 207, 198, 34);
		panel.add(txtyear);
		
		txtpulisher = new JTextField();
		txtpulisher.setColumns(10);
		txtpulisher.setBounds(113, 162, 198, 34);
		panel.add(txtpulisher);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Ganre");
		lblNewLabel_1_1_2_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_2_2.setBounds(20, 296, 89, 34);
		panel.add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Language");
		lblNewLabel_1_1_4.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_4.setBounds(20, 251, 108, 34);
		panel.add(lblNewLabel_1_1_4);
		
		JLabel lblName_1_2 = new JLabel("Year");
		lblName_1_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblName_1_2.setBounds(20, 206, 89, 34);
		panel.add(lblName_1_2);
		
		JLabel lblName_3 = new JLabel("Publisher");
		lblName_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblName_3.setBounds(20, 161, 108, 34);
		panel.add(lblName_3);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 114, 125, 34);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Titale");
		lblNewLabel_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(20, 66, 125, 34);
		panel.add(lblNewLabel_1_1_1_2);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection Con = DbConnction.dbcon();
					
					
					String author = txtauthor.getText();
				String bookname = txttitale.getText();
				String publisher = txtpulisher.getText();
				String year = txtyear.getText();
			
				
					
					PreparedStatement st;
					try {
						st = Con.prepareStatement("Insert into books2(bookname,author,years,publisher,Language,Genre,Quantity )values (?,?,?,?,?,?,?)");
					
						 st.setString(1, bookname);
						 st.setString(2, author);
						 st.setString(3, year);
						 st.setString(4, publisher);
						 st.setString(5, txtlang.getText());
						 st.setString(6,txtganre.getText()); 
						 st.setString(7,txtquantity.getText());	
								st.executeUpdate();
								Con.close();
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					loadBooksFromDB();
				JOptionPane.showMessageDialog(null, "Data saved successfully!");
			}
		});
		btnNewButton_2.setBounds(10, 392, 301, 43);
		panel.add(btnNewButton_2);
		
		JButton btnUpdate_2 = new JButton("Update");
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(txtid.getText().equals("")) {
	
				loadBooksFromDB();
			} else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/librariy manegemnet system", "root", "root");
			
			
			PreparedStatement ps = con.prepareStatement("update books2 set bookname =?,author=?,years=?,publisher=?,Language=?,Genre=?,Quantity=? where id = ?");
			ps.setString(1, txttitale.getText());
			ps.setString(2, txtauthor.getText());
			ps.setString(3, txtyear.getText());
			ps.setString(4, txtpulisher.getText());
			ps.setString(5, txtlang.getText());
			ps.setString(6, txtganre.getText());
			ps.setString(7, txtquantity.getText());
			ps.setString(8,txtid.getText());
			
			  int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, 
                        "Book updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null,
                        "No book found with ID: " + txtid.getText());
                    clearFields();
                }
            
        } catch (ClassNotFoundException e1) {
            JOptionPane.showMessageDialog(null, 
                "Database driver not found!", "Error", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, 
                "Database error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
		
	
				
				
				
				
				
			}	
			
			
			
			}
		});
		btnUpdate_2.setBounds(10, 446, 301, 43);
		panel.add(btnUpdate_2);
		
		JButton btnDelete_2 = new JButton("Delete");
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   String url = "jdbc:mysql://localhost:3306/librariy manegemnet system"; // your DB name
			        String user = "root";
			        String pass = "root";

			        try {
			            // Load JDBC driver
			            Class.forName("com.mysql.cj.jdbc.Driver");

			            // Connect to DB
			            Connection con = DriverManager.getConnection(url, user, pass);

			            // Prepare SQL delete query
			            String sql = "DELETE FROM books2 WHERE id = ?";
			            PreparedStatement ps = con.prepareStatement(sql);

			            // Set ID from text field
			            ps.setInt(1, Integer.parseInt(txtid.getText()));

			            // Execute delete
			            int rowsDeleted = ps.executeUpdate();

			            if (rowsDeleted > 0) {
			                JOptionPane.showMessageDialog(null, "Record deleted successfully!");
			            } else {
			                JOptionPane.showMessageDialog(null, "ID not found in database.");
			            }

			            // Close connection
			            ps.close();
			            con.close();

			        } catch (ClassNotFoundException | SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			        }
			    }
			});
		btnDelete_2.setBounds(10, 500, 301, 43);
		panel.add(btnDelete_2);
		
		txttitale = new JTextField();
		txttitale.setColumns(10);
		txttitale.setBounds(113, 65, 198, 37);
		panel.add(txttitale);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(113, 347, 198, 34);
		panel.add(txtquantity);
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Quantity");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_2_2_1.setBounds(20, 347, 89, 34);
		panel.add(lblNewLabel_1_1_2_2_1);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(113, 18, 108, 37);
		panel.add(txtid);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("id");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2_1.setBounds(20, 19, 125, 34);
		panel.add(lblNewLabel_1_1_1_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(351, 29, 893, 540);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Quantity", "Ganre", "Year", "Language", "Author", "Titale"
			}
		));
		scrollPane_1.setViewportView(table_1);
	

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Student", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll No");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 70, 125, 34);
		panel_1.add(lblNewLabel);
		
		JLabel lblName = new JLabel("FristName");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblName.setBounds(34, 120, 89, 34);
		panel_1.add(lblName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(34, 215, 66, 34);
		panel_1.add(lblNewLabel_1_1);
		
		txtrollno = new JTextField();
		txtrollno.setBounds(160, 86, 198, 34);
		panel_1.add(txtrollno);
		txtrollno.setColumns(10);
		JLabel imglbl = new JLabel("New label");
		imglbl.setBounds(169, 11, 80, 64);
		panel_1.add(imglbl);
		txtfname = new JTextField();
		txtfname.setColumns(10);
		txtfname.setBounds(160, 131, 198, 34);
		panel_1.add(txtfname);
		 JFileChooser fileChooser = new JFileChooser();
	        FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "Image Files", "jpg", "jpeg", "png", "gif");
	        fileChooser.setFileFilter(filter);
	        final File[] selectedImageFile = {null};
	        
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser chooser = new JFileChooser();
		            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "jpeg");
		            chooser.setFileFilter(filter);

		            int result = chooser.showOpenDialog(null);
		            if (result == JFileChooser.APPROVE_OPTION) {
		                selectedImageFile[0] = chooser.getSelectedFile();
		                ImageIcon icon = new ImageIcon(selectedImageFile[0].getAbsolutePath());
		                Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		                imglbl.setIcon(new ImageIcon(img));
		            }}
		});
		btnNewButton.setBounds(34, 32, 89, 23);
		panel_1.add(btnNewButton);
		
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(160, 217, 198, 34);
		panel_1.add(txtemail);
		  
	        
		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/librariy manegemnet system";
					Class.forName("com.mysql.cj.jdbc.Driver");
					
				
					Connection Con = DriverManager.getConnection(url ,"root","root");
					PreparedStatement st = Con.prepareStatement("Insert into student(fname,lname,rollno,email,address,ing) values(?,?,?,?,?,?)");
							st.setString(1, txtfname.getText());
					st.setString(2, txtlname.getText());
					st.setString(3, txtrollno.getText());
					st.setString(4, txtemail.getText());
					st.setString(5, txtaddress.getText());
					   FileInputStream fis = new FileInputStream(selectedImageFile[0]);
		             
		                st.setBinaryStream(6, fis, (int) selectedImageFile[0].length());
					
					
					
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Succesfully inserted Data In database");
					Con.close();	
					loadStudentFromDB();   	
				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException | HeadlessException ex  ) {
					JOptionPane.showMessageDialog(null,ex);
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnadd.setBounds(10, 326, 348, 43);
		panel_1.add(btnadd);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(160, 172, 198, 34);
		panel_1.add(txtlname);
		
		JLabel lblName_1 = new JLabel("LastName");
		lblName_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblName_1.setBounds(34, 167, 89, 34);
		panel_1.add(lblName_1);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(160, 265, 198, 34);
		panel_1.add(txtaddress);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Address");
		lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(34, 265, 89, 34);
		panel_1.add(lblNewLabel_1_1_2);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librariy manegemnet system","root","root");
					PreparedStatement ps = con.prepareStatement("update student set fname =?,lname=?,address=?,email=? WHERE rollno = ?");
			
					ps.setString(1, txtfname.getText());
					ps.setString(2, txtlname.getText());
					ps.setString(3, txtaddress.getText());
					ps.setString(4, txtemail.getText());
					ps.setString(5, txtrollno.getText());
				
					  int rowsUpdated = ps.executeUpdate();
		                if (rowsUpdated > 0) {
		                	JOptionPane.showMessageDialog(null, "Data saved successfully!");
		                   
		                } else {
		                	JOptionPane.showMessageDialog(null, "No Student found with RollNumber: " + txtrollno.getText());
		                    clearFields();
		                }
		            	loadStudentFromDB();   
		            
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnupdate.setBounds(10, 377, 348, 43);
		panel_1.add(btnupdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				
				
				 String url = "jdbc:mysql://localhost:3306/librariy manegemnet system"; // your DB name
			        String user = "root";
			        String pass = "root";

			        try {
			            // Load JDBC driver
			            Class.forName("com.mysql.cj.jdbc.Driver");

			            // Connect to DB
			            Connection con = DriverManager.getConnection(url, user, pass);

			            // Prepare SQL delete query
			            String sql = "DELETE FROM student WHERE rollno = ?";
			            PreparedStatement ps = con.prepareStatement(sql);

			            // Set ID from text field
			            ps.setInt(1, Integer.parseInt(txtrollno.getText()));

			            // Execute delete
			            int rowsDeleted = ps.executeUpdate();

			            if (rowsDeleted > 0) {
			                JOptionPane.showMessageDialog(null, "Record deleted successfully!");
			            } else {
			                JOptionPane.showMessageDialog(null, "Roll Number not found in database.");
			            }

			            // Close connection
			            ps.close();
			            con.close();
			        	loadStudentFromDB();   
			        } catch (ClassNotFoundException | SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			        }
			    }
			});
		
		
		
		
		
		
		
		
		
		
		
		
		
		loadBooksFromDB();
	
		btnDelete.setBounds(10, 431, 348, 43);
		panel_1.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(416, 11, 834, 463);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Address", "Email", "RollNumber ", "LastName", "Name"
			}
			
		));
		
	
		
		

		loadStudentFromDB();   
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.PINK);
		headerPanel.setBounds(0, 0, 1281, 72);
		contentPane.add(headerPanel);
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
		
		JLabel lblTitle = new JLabel("Library Management System");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		headerPanel.add(lblTitle);
		
	
	}

	private void loadStudentFromDB() {
		String url = "jdbc:mysql://localhost:3306/librariy manegemnet system"; // 👈 Keeping your DB name as-is
		String user = "root";
		String pass = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM student");
			ResultSetMetaData meta = rs.getMetaData();

			DefaultTableModel model = new DefaultTableModel();
			int cols = meta.getColumnCount();

			// Add columns
			for (int i = 1; i <= cols; i++) {
				model.addColumn(meta.getColumnName(i));
			}

			// Add rows
			while (rs.next()) {
				Object[] row = new Object[cols];
				for (int i = 1; i <= cols; i++) {
					row[i - 1] = rs.getObject(i);
				}
				model.addRow(row);
			}
			
			 table.setModel(model); 
			rs.close();
			st.close();
			con.close();
		

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
		}
	}
	

	
	
	

	
	
	
	private void loadBooksFromDB() {
	    String url = "jdbc:mysql://localhost:3306/librariy manegemnet system"; // DB नाव जसं आहे तसंच ठेवलंय
	    String user = "root";
	    String pass = "root";

	    try {
	        // JDBC driver load
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Connection create
	        Connection con = DriverManager.getConnection(url, user, pass);

	        // Query execute
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM books2");

	        // MetaData वापरून columns count
	        ResultSetMetaData meta = rs.getMetaData();
	        int cols = meta.getColumnCount();

	        // TableModel तयार करा
	        DefaultTableModel model = new DefaultTableModel();

	        // Columns add करा
	        for (int i = 1; i <= cols; i++) {
	            model.addColumn(meta.getColumnName(i));
	        }

	        // Rows add करा
	        while (rs.next()) {
	            Object[] row = new Object[cols];
	            for (int i = 1; i <= cols; i++) {
	                row[i - 1] = rs.getObject(i);
	            }
	            model.addRow(row);
	        }

	        // Table ला model सेट करा ✅
	        table_1.setModel(model);

	        // Clean up
	        rs.close();
	        st.close();
	        con.close();

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
	    }
	   
	}

	
	


	
	private void clearFields() {
	    txtaddress.setText("");
	    txtemail.setText("");
	    txtfname.setText("");
	    txtlname.setText("");
	    txtrollno.setText("");
}	
}
