package librery_system_demo;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				AdminPanel adminframe = new AdminPanel();
				adminframe.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public AdminPanel()
	{
		setTitle("Library Management System");
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(new BorderLayout());

		// ------------------ Header Panel ------------------
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.PINK);
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));

		JLabel lblTitle = new JLabel("Library Management System");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		headerPanel.add(lblTitle);

		getContentPane().add(headerPanel, BorderLayout.NORTH);

		// ------------------ Tabbed Pane ------------------
		JTabbedPane tabbedPane = new JTabbedPane();
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// ------------------ Books Panel ------------------
		JPanel booksPanel = new JPanel(new BorderLayout());

		// Table
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		booksPanel.add(scrollPane, BorderLayout.CENTER);

		// Buttons at bottom
		JPanel buttonPanel = new JPanel();
		JButton btnAdd = new JButton("Add Student");
		btnAdd.addActionListener(e -> {
			Add_book add = new Add_book(); // Assuming your Add_book.java exists
			add.setVisible(true);
		});
		JButton btnEdit = new JButton("Edit Student");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Upadateform updateframe = new Upadateform();
				updateframe.setVisible(true);
			}
		});
		JButton btnDelete = new JButton("Delete Student");
		
				JButton btnLoadBooks = new JButton("Load Student");
				buttonPanel.add(btnLoadBooks);
				btnLoadBooks.addActionListener(e -> loadBooksFromDB());

		buttonPanel.add(btnAdd);
		buttonPanel.add(btnEdit);
		buttonPanel.add(btnDelete);
		booksPanel.add(buttonPanel, BorderLayout.SOUTH);

		tabbedPane.addTab("Books", booksPanel);

		// ------------------ User Panel ------------------
		JPanel Student = new JPanel();
		Student.setBackground(Color.WHITE);
		tabbedPane.addTab("User", Student);
		Student.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(685, 16, 0, 0);
		Student.add(table_1);
		
		JPanel buttonPanel_1 = new JPanel();
		buttonPanel_1.setBounds(0, 567, 1276, 33);
		Student.add(buttonPanel_1);
		
		JButton btnLoadBooks_1 = new JButton("Load Books");
		buttonPanel_1.add(btnLoadBooks_1);
		
		JButton btnAdd_1 = new JButton("Add Book");
		buttonPanel_1.add(btnAdd_1);
		
		JButton btnEdit_1 = new JButton("Edit Book");
		buttonPanel_1.add(btnEdit_1);
		
		JButton btnDelete_1 = new JButton("Delete Book");
		buttonPanel_1.add(btnDelete_1);
		loadBooksFromDB();
	}

	private void loadBooksFromDB() {
		String url = "jdbc:mysql://localhost:3306/librariy manegemnet system"; // 👈 Keeping your DB name as-is
		String user = "root";
		String pass = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM books2");
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
}
