package tete;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MediaTracker;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class te {

	private JFrame frmSistemaSapien;
	private JTextField CampoCPF;
	private JPasswordField Camposenha;
	private Connection connection = null;
	private static final te banco = null;
	intermedio intermedioconectionjava = new intermedio();
	private Statement statement;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					te window = new te();
					window.frmSistemaSapien.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//parametros de mysql	
	public void conectar(){

	    //Conectando ao banco de dados//
	  //tenho duas opções da banco de dados
	    String servidor = "jdbc:mysql://sql10.db4free.net:3306/projetinho";
	    String usuario = "brendofcghh";
	    String senha = "qwer1234";

	    try {

	      this.connection = DriverManager.getConnection(servidor, usuario, senha);
	      this.statement = this.connection.createStatement();
	    } catch (Exception e) {
	      System.out.println("Erro: " + e.getMessage());
	    }

}

public void fecharconeccao() throws SQLException {
    //parametro para fechar o conecção do banco de dados//
    this.connection.close();
  }
	//fim parametros
	
	
	/**
	 * Create the application.
	 */
	public te() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaSapien = new JFrame();
		frmSistemaSapien.setTitle("Sistema Sapien");
		frmSistemaSapien.setBounds(100, 100, 910, 562);
		frmSistemaSapien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaSapien.getContentPane().setLayout(null);
		
		JPanel telainicio = new JPanel();
		telainicio.setBorder(UIManager.getBorder("Button.border"));
		telainicio.setBackground(new Color(255, 255, 255));
		telainicio.setBounds(0, 0, 904, 523);
		frmSistemaSapien.getContentPane().add(telainicio);
		telainicio.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 142, 874, 14);
		telainicio.add(lblNewLabel);
		
		CampoCPF = new JTextField();
		CampoCPF.setBounds(363, 167, 176, 20);
		telainicio.add(CampoCPF);
		CampoCPF.setColumns(10);
		
		JLabel TituloSistema = new JLabel("Sistema Sapien");
		TituloSistema.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		TituloSistema.setHorizontalAlignment(SwingConstants.CENTER);
		TituloSistema.setBounds(10, 11, 874, 42);
		telainicio.add(TituloSistema);
		
		JLabel TextoCpf = new JLabel("CPF");
		TextoCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		TextoCpf.setBounds(307, 170, 46, 14);
		telainicio.add(TextoCpf);
		
		Camposenha = new JPasswordField();
		Camposenha.setBounds(363, 198, 176, 20);
		telainicio.add(Camposenha);
		
		JLabel TextoSenha = new JLabel("SENHA");
		TextoSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		TextoSenha.setBounds(307, 201, 46, 14);
		telainicio.add(TextoSenha);
		
		JInternalFrame AVISOS = new JInternalFrame("AVISOS");
		AVISOS.setEnabled(false);
		AVISOS.setClosable(true);
		AVISOS.setBounds(359, 302, 182, 135);
		telainicio.add(AVISOS);
		AVISOS.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(363, 322, 166, 105);
		telainicio.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel informeLogin = new JLabel("");
		informeLogin.setHorizontalAlignment(SwingConstants.CENTER);
		informeLogin.setBounds(10, 46, 146, 14);
		panel.add(informeLogin);
		
		
		JPanel PainelLoginSistema = new JPanel();
		PainelLoginSistema.setBackground(new Color(255, 255, 255));
		PainelLoginSistema.setBounds(0, 0, 894, 523);
		telainicio.add(PainelLoginSistema);
		PainelLoginSistema.setEnabled(false);
		PainelLoginSistema.setVisible(false);
		
		
		JLabel BemVindo = new JLabel("Bem Vindo");
		BemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		BemVindo.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		PainelLoginSistema.add(BemVindo);
		BemVindo.setEnabled(false);
		
		//inicio do login
		JButton BotaoEntrar = new JButton("ENTRAR");
		BotaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//estanciando a conecção do banco de dados/
				
				conectar();
				Statement s = null;
				try {
					s = (Statement) connection.createStatement();
				      ResultSet r = null;
				      r = s.executeQuery("Select * from usuarioSapien WHERE CPF = " + CampoCPF.getText() + " and SENHA = " + "'" + Camposenha.getText() +"'" );
				      
				
				      if (!r.isBeforeFirst() ) {   
				    	  AVISOS.setEnabled(true);
				    	  informeLogin.setText("LOGIN INVALIDO!");
				    	  informeLogin.setForeground(Color.red);
				    	  panel.setVisible(true);
				    	  //StatusLogin.setText("login invalido"); 
				    	  //StatusLogin.setForeground(Color.red);;
				    	  
				      }
				      else {
				    	  AVISOS.setEnabled(false);
				    	  informeLogin.setText("");
				    	 // panel.setVisible(false);
				    	  PainelLoginSistema.setEnabled(true);
				    	  PainelLoginSistema.setVisible(true);
				    	  //telainicio.setVisible(false);
				    	  BemVindo.setEnabled(true);
				    	  BemVindo.setVisible(true);
				    	  
				      }
				      r.close();
				      //s.close;
				      fecharconeccao();
				    } catch (SQLException e1) {
				      e1.printStackTrace();
				    }

			
			}
		});
		//fim do login
		
		BotaoEntrar.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		BotaoEntrar.setBounds(405, 229, 89, 23);
		telainicio.add(BotaoEntrar);
		
		JButton BotaoCadastro = new JButton("CADASTRAR USUARIO");
		BotaoCadastro.setBounds(363, 263, 176, 23);
		telainicio.add(BotaoCadastro);
		
		
		
		
	}
}
