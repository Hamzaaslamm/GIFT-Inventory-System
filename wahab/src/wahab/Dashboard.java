package wahab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import net.proteanit.sql.DbUtils;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTree;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.JPasswordField;
import java.sql.*;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class Dashboard {

	private JFrame MainFrame;
	private JTextField textName;
	private JTextField textDec;
	private JTextField textPrice;
	private JTextField textQ;
	private JTextField textSearch;
	private JTextField textBID;
	private JTextField textDate;
	private JTextField textCName;
	private JTextField textAddress;
	private JTextField textPID;
	private JTextField textPName;
	private JTextField textPDec;
	private JTextField textPRate;
	private JTextField textPQuantity;
	private JTextField textStock;
	private JTextField textPPrice;
	private JTextField textTotal;
	private JTextField textCash;
	private JTextField textChange;
	private JTextField textSearchBID;
	private JPasswordField textOld;
	private JPasswordField textPin;
	private JPasswordField textNewP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
		connectionDB();
		loadProducts();
		loadBills();
	}

	Connection con;
	PreparedStatement stmt;
	PreparedStatement stmt1;
	
	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gift", "root", ""); 
	
		}catch(Exception ex) {
			
		}
	}
	
	
	public void loadProducts() {
		try {
			stmt = con.prepareStatement("Select pId, Product_Name, pQuantity, pprice, pDescription from product");
			ResultSet rs = stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			
		}
	}
	public void loadBills() {
		try {
			stmt = con.prepareStatement("Select bId, cName, Amount, date from bill");
			ResultSet rs = stmt.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			
		}
	}

	public void loadOrderLine(String id) {
		try {
			stmt = con.prepareStatement("SELECT pName, pQuantity, pPrice,pAmount from orderline WHERE Fk_bId = '"+id+"'");
			ResultSet rs = stmt.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			
		}
	}
	
	public void loadOrder(String name, String qua, String price, String amount) {
		try {
			stmt = con.prepareStatement("INSERT INTO orderline(pName, pQuantity, pPrice, pAmount) VALUES ('"+name+"', '"+qua+"', '"+price+"', '"+amount+"')");
			ResultSet rs = stmt.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			
		}
	}
	
	public void clearField() {
		textName.setText("");
		textDec.setText("");
		textQ.setText("");
		textPrice.setText("");
		textID.setText("");					
		textID.requestFocus();
	}
	
	public void sales() {
//		String total = 
	}
	
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textID;
	private JTextField textDiscount;
	private JTextField textAmount;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainFrame = new JFrame();
		MainFrame.setBounds(100, 100, 1030, 600);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(50);
		MainFrame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblGujranwalaInventoryFuturistic = new JLabel("Gujranwala Inventory Futuristic Trade (GIFT) System");
		lblGujranwalaInventoryFuturistic.setForeground(Color.WHITE);
		lblGujranwalaInventoryFuturistic.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lblGujranwalaInventoryFuturistic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		MainFrame.getContentPane().add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{121, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
//				FormB formB = new FormB();
//			    formB.setVisible(true);
//			    this.setVisible(false); 
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 1;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		MainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel inventory = new JPanel();
		tabbedPane.addTab("Inventory", null, inventory, null);
		inventory.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(160, 70, 109, 14);
		inventory.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setBounds(160, 107, 109, 14);
		inventory.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(160, 149, 109, 14);
		inventory.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setBounds(162, 193, 107, 14);
		inventory.add(lblNewLabel_3);
		
		textName = new JTextField();
		textName.setBounds(279, 67, 232, 20);
		inventory.add(textName);
		textName.setColumns(10);
		
		textDec = new JTextField();
		textDec.setColumns(10);
		textDec.setBounds(279, 104, 232, 20);
		inventory.add(textDec);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(279, 146, 232, 20);
		inventory.add(textPrice);
		
		textQ = new JTextField();
		textQ.setColumns(10);
		textQ.setBounds(279, 190, 232, 20);
		inventory.add(textQ);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearField();
			}
		});
		btnNewButton_5.setBounds(444, 219, 67, 23);
		inventory.add(btnNewButton_5);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name, dec, quantity, price, id, fk;
				id = textID.getText();
				name = textName.getText();
				dec = textDec.getText();
				quantity = textQ.getText();
				price = textPrice.getText();
				fk = "Ahsan Ali";
				
				try {
					
					if(name.isEmpty() == false && dec.isEmpty() == false && quantity.isEmpty() == false && price.isEmpty() == false) {
					
						stmt = con.prepareStatement("INSERT INTO product(pId, Product_Name, pQuantity, pprice, pDescription, FkP_User_Name) VALUES(?,?,?,?,?,?)");
						stmt.setString(1,id);
						stmt.setString(2,name);
						stmt.setString(3,quantity);
						stmt.setString(4,price);
						stmt.setString(5,dec);
						stmt.setString(6, fk);
					
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Prduct added successfully!");

					}else {
						JOptionPane.showMessageDialog(null, "Please fill all the fields!");

					}
					
					clearField();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnAdd.setBounds(323, 259, 89, 23);
		inventory.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String id = textID.getText();
					stmt = con.prepareStatement("DELETE from product WHERE pId = '"+ id +"'");
				
					clearField();
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Prduct DELETED successfully!");

			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			}
		});
		btnDelete.setBounds(224, 259, 89, 23);
		inventory.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String name, dec, quantity, price, id;
				
				id = textID.getText();
				
				name = textName.getText();
				dec = textDec.getText();
				quantity = textQ.getText();
				price = textPrice.getText();
				
				
				try {
					
					stmt = con.prepareStatement("UPDATE product SET Product_Name = ?, pQuantity = ?, pprice = ?, pDescription = ? WHERE pId = '"+ id +"'");
				
					stmt.setString(1,name);
					stmt.setString(2,quantity);
					stmt.setString(3,price);
					stmt.setString(4,dec);
					
					clearField();
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Prduct updated successfully!");

			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
				
			}
		});
		btnUpdate.setBounds(422, 259, 89, 23);
		inventory.add(btnUpdate);
		
		JLabel ID = new JLabel("Product id");
		ID.setBounds(160, 31, 89, 14);
		inventory.add(ID);
		
		textID = new JTextField();
		textID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				try {
					String id  = textID.getText();
					
					stmt= con.prepareStatement("Select Product_Name, pQuantity, pprice, pDescription, FkP_User_Name from product where pId = '"+textID.getText()+"'");
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next() == true){
						String name = rs.getString(1);
						String quantity = rs.getString(2);
						String price = rs.getString(3);
						String Dec = rs.getString(4);
						
						textName.setText(name);
						textQ.setText(quantity);
						textPrice.setText(price);
						textDec.setText(Dec);
						
					}else {
						textName.setText("");
						textDec.setText("");
						textQ.setText("");
						textPrice.setText("");
						
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		textID.setBounds(279, 28, 232, 20);
		inventory.add(textID);
		textID.setColumns(10);
		
		JPanel view_inventory = new JPanel();
		tabbedPane.addTab("View Inventory", null, view_inventory, null);
		view_inventory.setLayout(null);
		
		JLabel lblProductId = new JLabel("Product Name");
		lblProductId.setBounds(10, 29, 90, 14);
		view_inventory.add(lblProductId);
		
		textSearch = new JTextField();
		textSearch.setBounds(110, 26, 199, 20);
		view_inventory.add(textSearch);
		textSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					stmt = con.prepareStatement("Select pId, Product_Name, pQuantity, pprice, pDescription from product where product_Name = '"+textSearch.getText()+"'");
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception ex) {
					
				}
			}
		});
		btnSearch.setBounds(396, 25, 89, 23);
		view_inventory.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 627, 320);
		view_inventory.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton reloadB = new JButton("Reload");
		reloadB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadProducts();
			}
		});
		reloadB.setBounds(548, 25, 89, 23);
		view_inventory.add(reloadB);
		
		JPanel sell_product = new JPanel();
		tabbedPane.addTab("Sell Products", null, sell_product, null);
		sell_product.setLayout(null);
		
		JLabel lblBillId = new JLabel("Bill ID");
		lblBillId.setBounds(10, 11, 46, 14);
		sell_product.add(lblBillId);
		
		textBID = new JTextField();
		textBID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String id  = textBID.getText();
					loadOrderLine(id);
					
					stmt= con.prepareStatement("Select cName, Amount, Discount, date from bill where bId = '"+ id + "' ");
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next() == true){
						String name = rs.getString(1);
						String amount = rs.getString(2);
						String dis = rs.getString(3);
						String date = rs.getString(4);
						
						textCName.setText(name);
						textAmount.setText(amount);
						textDiscount.setText(dis);
						textDate.setText(date);
						
					}else {
						textCName.setText("");
						textAmount.setText("");
						textDiscount.setText("");
						textDate.setText("");
						
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		textBID.setBounds(10, 32, 86, 20);
		sell_product.add(textBID);
		textBID.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(125, 11, 92, 14);
		sell_product.add(lblDate);
		
		textDate = new JTextField();
		textDate.setBounds(125, 32, 109, 20);
		sell_product.add(textDate);
		textDate.setColumns(10);
		
		JLabel lblCName = new JLabel("Customer Name");
		lblCName.setBounds(271, 11, 109, 14);
		sell_product.add(lblCName);
		
		textCName = new JTextField();
		textCName.setBounds(271, 32, 137, 20);
		sell_product.add(textCName);
		textCName.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone Number");
		lblPhoneNo.setBounds(448, 11, 80, 14);
		sell_product.add(lblPhoneNo);
		
		textAddress = new JTextField();
		textAddress.setBounds(448, 32, 157, 20);
		sell_product.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblProductId_1 = new JLabel("product ID");
		lblProductId_1.setBounds(10, 63, 92, 14);
		sell_product.add(lblProductId_1);
		
		textPID = new JTextField();
		textPID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String id  = textPID.getText();
					
					String name;
					String quantity;
					String price;
					String Dec;
					
					stmt= con.prepareStatement("Select Product_Name, pQuantity, pprice, pDescription from product where pId = '"+ id + "' ");
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next() == true){
						name = rs.getString(1);
						quantity = rs.getString(2);
						price = rs.getString(3);
						Dec = rs.getString(4);
					
						textPName.setText(name);
						textPDec.setText(Dec);
						textStock.setText(quantity);
						textPRate.setText(price);
						
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
						
						
					}else {
						textPName.setText("");
						textPDec.setText("");
						textStock.setText("");
						textPRate.setText("");
						
					}
//					loadOrder(name, quantity, price, Dec);
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		textPID.setBounds(10, 86, 86, 20);
		sell_product.add(textPID);
		textPID.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(125, 63, 109, 14);
		sell_product.add(lblProductName);
		
		textPName = new JTextField();
		textPName.setBounds(125, 86, 109, 20);
		sell_product.add(textPName);
		textPName.setColumns(10);
		
		textPDec = new JTextField();
		textPDec.setBounds(271, 86, 137, 20);
		sell_product.add(textPDec);
		textPDec.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(271, 63, 86, 14);
		sell_product.add(lblDescription);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(448, 63, 46, 14);
		sell_product.add(lblRate);
		
		textPRate = new JTextField();
		textPRate.setBounds(448, 86, 70, 20);
		sell_product.add(textPRate);
		textPRate.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(546, 63, 59, 14);
		sell_product.add(lblQuantity);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(795, 63, 46, 14);
		sell_product.add(lblStock);
		
		textPQuantity = new JTextField();
		textPQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(textPQuantity.getText().isEmpty() == false && textPRate.getText().isEmpty() == false) {
						int p = Integer.parseInt(textPQuantity.getText()) *  Integer.parseInt(textPRate.getText());
						String price = Integer.toString(p);
						textPPrice.setText(price);	
					}else {
						textPPrice.setText("");	
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		textPQuantity.setBounds(546, 86, 59, 20);
		sell_product.add(textPQuantity);
		textPQuantity.setColumns(10);
		
		textStock = new JTextField();
		textStock.setBounds(795, 86, 59, 20);
		sell_product.add(textStock);
		textStock.setColumns(10);
		
		textPPrice = new JTextField();
		textPPrice.setBounds(628, 86, 92, 20);
		sell_product.add(textPPrice);
		textPPrice.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(628, 63, 46, 14);
		sell_product.add(lblPrice);
		
		JButton AddB = new JButton("Add");
		AddB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quantity = textPQuantity.getText();
				String name = textPName.getText();
				String Dec = textPDec.getText();
				String stock = textStock.getText();
				String price = textPPrice.getText();
				
				int lastID = 0;
				try {
				
					
//					stmt= con.prepareStatement("insert into orderline(pName, pQuantity, pPrice)values(?,?,?)");
//					ResultSet rs = stmt.executeQuery();
//					
//					stmt.setString(1, name);
//					stmt.setString(2, quantity);
//					stmt.setString(3, price);
////					stmt.setString(4, amount);
//					stmt.executeUpdate();
//					rs = stmt.getGeneratedKeys();
//					
//					if(rs.next()) {
//						lastID = rs.getInt(1);
//					}
//					
//					int rows = table2.getRowCount();
					stmt1 = con.prepareStatement("");
					
				}catch(Exception ex) {
					
				}
				
			}
		});
		AddB.setBounds(768, 117, 86, 29);
		sell_product.add(AddB);
		
		textTotal = new JTextField();
		textTotal.setBounds(695, 183, 85, 20);
		sell_product.add(textTotal);
		textTotal.setColumns(10);
		
		textCash = new JTextField();
		textCash.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(textTotal.getText().isEmpty() == false && textDiscount.getText().isEmpty() == false) {
						
						int test = Integer.parseInt(textDiscount.getText());
						double decimal = Integer.parseInt(textDiscount.getText()) / 100;
						double discounted = (Integer.parseInt(textTotal.getText()) - (Integer.parseInt(textTotal.getText()) *  decimal));
						textAmount.setText(Double.toString(discounted));
						double ch = (Integer.parseInt(textCash.getText()) - discounted);
						String change = Double.toString(ch);
						textChange.setText(change);
						
						
						
					}else {
						textChange.setText("");	
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		textCash.setBounds(695, 271, 158, 20);
		sell_product.add(textCash);
		textCash.setColumns(10);
		
		textChange = new JTextField();
		textChange.setBounds(695, 317, 159, 20);
		sell_product.add(textChange);
		textChange.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(628, 186, 57, 14);
		sell_product.add(lblTotal);
		
		JLabel lblCash = new JLabel("Cash");
		lblCash.setBounds(628, 274, 46, 14);
		sell_product.add(lblCash);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setBounds(628, 320, 46, 14);
		sell_product.add(lblChange);
		
		JButton SaveB = new JButton("Save");
		SaveB.setBounds(716, 364, 64, 23);
		sell_product.add(SaveB);
		
		JButton PrintB = new JButton("Print");
		PrintB.setBounds(795, 364, 62, 23);
		sell_product.add(PrintB);
		
		JScrollPane table2 = new JScrollPane();
		table2.setBounds(10, 117, 596, 270);
		sell_product.add(table2);
		
		table_1 = new JTable();
		table2.setViewportView(table_1);
		
		textDiscount = new JTextField();
		textDiscount.setBounds(794, 183, 60, 20);
		sell_product.add(textDiscount);
		textDiscount.setColumns(10);
		
		JLabel Discount = new JLabel("Discount");
		Discount.setBounds(797, 157, 57, 14);
		sell_product.add(Discount);
		
		textAmount = new JTextField();
		textAmount.setBounds(695, 227, 159, 20);
		sell_product.add(textAmount);
		textAmount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(628, 230, 46, 14);
		sell_product.add(lblAmount);
		
		JPanel view_bills = new JPanel();
		tabbedPane.addTab("View Bills", null, view_bills, null);
		view_bills.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Bill Id");
		lblNewLabel_4.setBounds(83, 36, 46, 14);
		view_bills.add(lblNewLabel_4);
		
		textSearchBID = new JTextField();
		textSearchBID.setBounds(159, 33, 129, 20);
		view_bills.add(textSearchBID);
		textSearchBID.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Search");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					stmt = con.prepareStatement("Select bId, cName, Amount, date from bill where bID = '"+textSearchBID.getText()+"'");
					ResultSet rs = stmt.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception ex) {
					
				}
			}
		});
		btnNewButton_9.setBounds(328, 32, 89, 23);
		view_bills.add(btnNewButton_9);
		
		JScrollPane billTB = new JScrollPane();
		billTB.setBounds(10, 65, 704, 322);
		view_bills.add(billTB);
		
		table_2 = new JTable();
		billTB.setViewportView(table_2);
		
		JButton reloadB_1 = new JButton("Reload");
		reloadB_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBills();
			}
		});
		reloadB_1.setBounds(625, 32, 89, 23);
		view_bills.add(reloadB_1);
		
		JPanel change_password = new JPanel();
		tabbedPane.addTab("Change Password", null, change_password, null);
		change_password.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Old Password");
		lblNewLabel_5.setBounds(69, 61, 100, 14);
		change_password.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pin Code");
		lblNewLabel_6.setBounds(69, 110, 100, 14);
		change_password.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New Password");
		lblNewLabel_7.setBounds(69, 159, 100, 14);
		change_password.add(lblNewLabel_7);
		
		JButton btnNewButton_10 = new JButton("Change Password");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String password = textNewP.getText();
				String pin = textPin.getText();
				String old = textOld.getText();
				
//				try {
//					stmt = con.prepareStatement("select password from computer_operator");
//				}catch(Exception ex) {
//					
//				}
//				if(old == ) {
//					
//				}
				try {
					
					stmt = con.prepareStatement("UPDATE computer_operator SET User_Name = ?, password = ?, pin = ?");
				
//					stmt.setString(1,name);
//					stmt.setString(2,quantity);
//					stmt.setString(3,price);
//					stmt.setString(4,dec);
//					
					clearField();
				
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Prduct updated successfully!");

				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}	
			}
		});
		btnNewButton_10.setBounds(243, 200, 144, 23);
		change_password.add(btnNewButton_10);
		
		textOld = new JPasswordField();
		textOld.setBounds(179, 58, 208, 20);
		change_password.add(textOld);
		
		textPin = new JPasswordField();
		textPin.setBounds(179, 107, 208, 20);
		change_password.add(textPin);
		
		textNewP = new JPasswordField();
		textNewP.setBounds(179, 156, 208, 20);
		change_password.add(textNewP);
	}
}
