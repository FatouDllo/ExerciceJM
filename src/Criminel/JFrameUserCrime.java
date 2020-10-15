package Criminel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import utilisateur.user; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Criminel.connexion;


import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameUserCrime extends JFrame {

	private JPanel contentPane;
	private JTable tableUser;
	private JLabel lblID;
	private JTextField textFieldID;
	private JLabel lblNom;
	private JTextField textFieldNom;
	private JLabel lblPrenom;
	private JTextField textFieldPrenom;
	private JLabel lblAge;
	private JTextField textFieldAge;
	private JLabel lblCrime;
	private JTextField textFieldCrime;
	private JLabel lblAnnee;
	private JTextField textFieldAnnee;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	
	
	private connexion userDao=new connexion();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameUserCrime frame = new JFrameUserCrime();
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
	public JFrameUserCrime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableUser = new JTable();
		this.tableUser.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tableUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne=tableUser.getSelectedRow();
				int id=Integer.parseInt(tableUser.getValueAt(ligne, 0).toString());
				user user= userDao.rechercherById(id);
				textFieldID.setText(String.valueOf(user.getId()));
				textFieldNom.setText(String.valueOf(user.getNom()));
				textFieldPrenom.setText(String.valueOf(user.getPrenom()));
				textFieldAge.setText(String.valueOf(user.getAge()));
				textFieldCrime.setText(String.valueOf(user.getCrime()));
				textFieldAnnee.setText(String.valueOf(user.getAnneeEmprisonnement()));
				
			}
		});
		/*tableUser.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));*/ 
		tableUser.setForeground(new Color(0, 0, 0));
		tableUser.setBounds(10, 11, 471, 128);
		contentPane.add(tableUser);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Information ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(240, 240, 240));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 150, 471, 219);
		contentPane.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblID = new JLabel("ID : ");
		panel.add(lblID, "2, 2");
		
		textFieldID = new JTextField();
		panel.add(textFieldID, "10, 2, fill, default");
		textFieldID.setColumns(10);
		
		lblNom = new JLabel("Nom :");
		panel.add(lblNom, "2, 4");
		
		textFieldNom = new JTextField();
		panel.add(textFieldNom, "10, 4, fill, default");
		textFieldNom.setColumns(10);
		
		lblPrenom = new JLabel("Pr\u00E9nom : ");
		panel.add(lblPrenom, "2, 6");
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setText("");
		panel.add(textFieldPrenom, "10, 6, fill, default");
		textFieldPrenom.setColumns(10);
		
		lblAge = new JLabel("Age : ");
		panel.add(lblAge, "2, 8");
		
		textFieldAge = new JTextField();
		textFieldAge.setText("");
		panel.add(textFieldAge, "10, 8, fill, default");
		textFieldAge.setColumns(10);
		
		lblCrime = new JLabel("Crime : ");
		panel.add(lblCrime, "2, 10");
		
		textFieldCrime = new JTextField();
		textFieldCrime.setText("");
		panel.add(textFieldCrime, "10, 10, fill, default");
		textFieldCrime.setColumns(10);
		
		lblAnnee = new JLabel("Ann\u00E9e Emprisonnement : ");
		panel.add(lblAnnee, "2, 12");
		
		textFieldAnnee = new JTextField();
		textFieldAnnee.setText("");
		panel.add(textFieldAnnee, "10, 12, fill, default");
		textFieldAnnee.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					user user=new user();
					var vn= textFieldNom.getText(); 
					var vp = textFieldPrenom.getText(); 
					var va = textFieldAge.getText(); 
					var vc = textFieldCrime.getText(); 
					var van = textFieldAnnee.getText(); 
					if ((!vn.isEmpty()) && (!vp.isEmpty()) && (!va.isEmpty()) && (!vc.isEmpty()) && (!van.isEmpty())) {
						user.setNom(textFieldNom.getText());
						user.setPrenom(textFieldPrenom.getText());
						user.setAge(textFieldAge.getText());
						user.setCrime(textFieldCrime.getText());
						user.setAnneeEmprisonnement(textFieldAnnee.getText());
						
						if(userDao.ajouter(user)) {
							JOptionPane.showMessageDialog(null, "Ajout reussi avec success");
							remplir();
							
						}
					} else { 
						JOptionPane.showMessageDialog(null, "Renseignez des valeurs"); 
						}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		panel.add(btnAjouter, "2, 14");
		remplir(); 
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ligne=tableUser.getSelectedRow();
					int id=Integer.parseInt(tableUser.getValueAt(ligne, 0).toString());
					if (JOptionPane.showConfirmDialog (null,"Voulez-vous supprimer cet utilisateur ?", "Suppression",
							JOptionPane.YES_NO_OPTION ) == JOptionPane.OK_OPTION) {
						if (userDao.supprimerByID(id)) {
						JOptionPane.showMessageDialog(null, "Suppresion reussi avec success");
						remplir();
						}else 
							JOptionPane.showMessageDialog(null, "Suppresion non reussi");
						}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Choississez une ligne");
					
				}
			
			}
		});
		panel.add(btnSupprimer, "10, 14");
	}
	private void remplir() {
		DefaultTableModel dtm=new DefaultTableModel();
		// DefaulttableModel classe graphique colonnes et lignes 
		dtm.addColumn("ID");
		dtm.addColumn("Nom");
		dtm.addColumn("Prenom");
		dtm.addColumn("Age");
		dtm.addColumn("Crime");
		dtm.addColumn("AnneeEmprisonnement");
		for(user user : userDao.listerUsers()) {
			dtm.addRow(new Object[] {user.getId(), user.getNom(), user.getPrenom(), user.getAge(), user.getCrime(), 
					user.getAnneeEmprisonnement() });
		}
		this.tableUser.setModel(dtm);
	}
}
