
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JScrollBar;

@SuppressWarnings("unused")
public class te {

	private JFrame frmSistemaSapien;
	private JTextField CampoCPF;
	private JPasswordField Camposenha;
	private Connection connection = null;
	private static final te banco = null;
	//intermedio intermedioconectionjava = new intermedio();
	gerandosenhs senhasgerasr = new gerandosenhs();
	private Statement statement;
	private JTextField CampoconsultaCasas;
	private JTextField CampoNomeCadastro;
	private JTextField CampoCpFCadastro;
	private JPasswordField CampopassworCadastro;
	public String calculadohash;
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
		frmSistemaSapien.setBounds(100, 100, 910, 872);
		frmSistemaSapien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaSapien.getContentPane().setLayout(null);
		
		JPanel telainicio = new JPanel();
		telainicio.setBorder(UIManager.getBorder("Button.border"));
		telainicio.setBackground(new Color(255, 255, 255));
		telainicio.setBounds(0, 0, 894, 840);
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
		AVISOS.setBackground(new Color(255, 255, 255));
		AVISOS.getContentPane().setBackground(new Color(255, 255, 255));
		AVISOS.setEnabled(false);
		AVISOS.setClosable(true);
		AVISOS.setBounds(359, 302, 182, 135);
		telainicio.add(AVISOS);
		AVISOS.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
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
		PainelLoginSistema.setBounds(0, 0, 894, 829);
		telainicio.add(PainelLoginSistema);
		PainelLoginSistema.setEnabled(false);
		PainelLoginSistema.setVisible(false);
		PainelLoginSistema.setLayout(null);
		
		
		JLabel BemVindo = new JLabel("Bem Vindo");
		BemVindo.setBounds(366, 5, 162, 42);
		BemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		BemVindo.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		PainelLoginSistema.add(BemVindo);
		BemVindo.setEnabled(false);
		
		JLabel nomeusuario = new JLabel("");
		nomeusuario.setHorizontalAlignment(SwingConstants.CENTER);
		nomeusuario.setBounds(343, 76, 222, 14);
		PainelLoginSistema.add(nomeusuario);
		
		CampoconsultaCasas = new JTextField();
		CampoconsultaCasas.setBounds(24, 100, 215, 20);
		PainelLoginSistema.add(CampoconsultaCasas);
		CampoconsultaCasas.setColumns(10);
		
		JLabel TextoInfomativoPosLogin = new JLabel("Infome o ID da Casa");
		TextoInfomativoPosLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TextoInfomativoPosLogin.setBounds(27, 76, 212, 14);
		PainelLoginSistema.add(TextoInfomativoPosLogin);
		
		JLabel ImgsCasa = new JLabel("");
		ImgsCasa.setHorizontalAlignment(SwingConstants.CENTER);
		ImgsCasa.setBounds(24, 165, 516, 125);
		PainelLoginSistema.add(ImgsCasa);
		
		JLabel recebiValores = new JLabel("");
		recebiValores.setBounds(24, 301, 516, 30);
		PainelLoginSistema.add(recebiValores);
		
		JLabel RecebeEdereco = new JLabel("");
		RecebeEdereco.setBounds(24, 342, 516, 23);
		PainelLoginSistema.add(RecebeEdereco);
		
		JLabel RecebiNomeDono = new JLabel("");
		RecebiNomeDono.setBounds(24, 376, 516, 20);
		PainelLoginSistema.add(RecebiNomeDono);
		nomeusuario.setVisible(false);
		
		JButton botaoConsultaCasa = new JButton("Consultar");
		botaoConsultaCasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conectar();
				
				
				Statement s = null;
				try {
					
					
					
					s = (Statement) connection.createStatement();
				      ResultSet r = null;
				      r = s.executeQuery("Select * from casas WHERE id_casa = " +CampoconsultaCasas.getText());
				      
				      if (!r.isBeforeFirst() ) {   
				    	  TextoInfomativoPosLogin.setText("Imovem não encontrado");
				    	  
				      }
				      else {
				    	  TextoInfomativoPosLogin.setText("Infome o ID da Casa");
				      }
				      
				      while (r.next()) {
				    	  URL urlImg = new URL(r.getString("imgs"));
				          ImageIcon imgIcon = new ImageIcon(urlImg);
				          // faz o preload da imagem
				          while(imgIcon.getImageLoadStatus() == MediaTracker.LOADING); 
				         
				          
				    	  
				    	  recebiValores.setText("R$: " +r.getString("valor"));
				    	  RecebeEdereco.setText("Indereço do Imovel :" +r.getString("idereco"));
				    	  RecebiNomeDono.setText("Responsavel Pelo Imovel :"+r.getString("NomeDono"));
				    	  ImgsCasa.setIcon(imgIcon);
				    	  ImgsCasa.setSize(100, 70);
				    	  
				        }
				     
				      r.close();
				      //s.close;
				      fecharconeccao();
				    } catch (SQLException e1) {
				      e1.printStackTrace();
				    } catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		botaoConsultaCasa.setBounds(24, 131, 215, 23);
		PainelLoginSistema.add(botaoConsultaCasa);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setMinimum(1);

		scrollBar.setBounds(867, 0, 17, 829);
		scrollBar.setPreferredSize(new Dimension(464, 439));
		PainelLoginSistema.add(scrollBar);
		
		JLabel StatusdacriacaodoUser = new JLabel("");
		StatusdacriacaodoUser.setHorizontalAlignment(SwingConstants.CENTER);
		StatusdacriacaodoUser.setBounds(589, 301, 268, 14);
		telainicio.add(StatusdacriacaodoUser);
		
		JLabel TextoCadastroInfo = new JLabel("Nome Completo");
		TextoCadastroInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TextoCadastroInfo.setBounds(548, 76, 309, 30);
		telainicio.add(TextoCadastroInfo);
		TextoCadastroInfo.setVisible(false);
		
		CampoNomeCadastro = new JTextField();
		CampoNomeCadastro.setBounds(548, 101, 309, 20);
		telainicio.add(CampoNomeCadastro);
		CampoNomeCadastro.setColumns(10);
		CampoNomeCadastro.setVisible(false);
		
		JLabel InofomeCPF = new JLabel("CPF Apenas Numero");
		InofomeCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		InofomeCPF.setBounds(548, 135, 309, 30);
		telainicio.add(InofomeCPF);
		InofomeCPF.setVisible(false);
		
		CampoCpFCadastro = new JTextField();
		CampoCpFCadastro.setBounds(550, 165, 307, 20);
		telainicio.add(CampoCpFCadastro);
		CampoCpFCadastro.setColumns(10);
		CampoCpFCadastro.setVisible(false);
		
		JLabel inforSenha = new JLabel("Senha");
		inforSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inforSenha.setBounds(550, 196, 307, 30);
		telainicio.add(inforSenha);
		inforSenha.setVisible(false);
		
		CampopassworCadastro = new JPasswordField();
		CampopassworCadastro.setBounds(550, 224, 307, 20);
		telainicio.add(CampopassworCadastro);
		CampopassworCadastro.setVisible(false);
		
		JButton BotaoCadastroUser = new JButton("Cadastrar");
		BotaoCadastroUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conectar();
				
				try {
					calculadohash = senhasgerasr.criptografare(CampopassworCadastro.getText());
					//System.out.println(calculadohash);
					
			String sql = "INSERT INTO usuarioSapien (Nome, CPF, SENHA) VALUES  ("+ "'"+ CampoNomeCadastro.getText() + "'" +"," + CampoCpFCadastro.getText()+"," +"'"+calculadohash+"')";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.execute(); //executa comando   
		      stmt.close();    
		      fecharconeccao();
		    } catch (SQLException u) {    
		      throw new RuntimeException(u);    
		    }
				
				conectar();
				Statement s = null;
				try {
					s = (Statement) connection.createStatement();
				      ResultSet r = null;
				      r = s.executeQuery("Select * from usuarioSapien WHERE CPF = " + CampoCpFCadastro.getText());
				      
				      
				      if (!r.isBeforeFirst() ) {   
				    	  
				    	  StatusdacriacaodoUser.setText("Usuario não cadastrado");
				    	  StatusdacriacaodoUser.setForeground(Color.red);
				      }
				      
				      else {
				    	  StatusdacriacaodoUser.setText("Usuario Cadastrado com sucesso");
				    	  StatusdacriacaodoUser.setForeground(Color.green);
				      }
				     
				      r.close();
				      //s.close;
				      fecharconeccao();
				    } catch (SQLException e1) {
				      e1.printStackTrace();
				    }
				
				
			}
		});
		BotaoCadastroUser.setBounds(629, 255, 141, 23);
		telainicio.add(BotaoCadastroUser);
		BotaoCadastroUser.setVisible(false);
		
		JButton BotaoEntrar = new JButton("ENTRAR");
		
		JButton BotaoCadastro = new JButton("CADASTRAR USUARIO");
		BotaoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
					TextoCadastroInfo.setVisible(true);
					CampoNomeCadastro.setVisible(true);
					InofomeCPF.setVisible(true);
					CampoCpFCadastro.setVisible(true);
					inforSenha.setVisible(true);
					CampopassworCadastro.setVisible(true);	
					BotaoCadastroUser.setVisible(true);
					BotaoCadastro.setVisible(false);
					AVISOS.setVisible(false);
			    	  AVISOS.setEnabled(false);
			    	  BotaoEntrar.setVisible(false);
			    	  informeLogin.setText("");
			    	  TextoCpf.setVisible(false);
			    	  TextoSenha.setVisible(false);
			    	  lblNewLabel.setVisible(false);
			    	  TituloSistema.setVisible(false);
			    	  CampoCPF.setVisible(false);
			    	  Camposenha.setVisible(false);
			    	  
			    	      
				  }
				
				
			
		});
		BotaoCadastro.setBounds(363, 263, 176, 23);
		telainicio.add(BotaoCadastro);
		
		//inicio do login
		
		
		BotaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//estanciando a conecção do banco de dados/
				
				conectar();
				Statement s = null;
				try {
					calculadohash = senhasgerasr.criptografare(Camposenha.getText());
					//System.out.println(calculadohash);
					s = (Statement) connection.createStatement();
				      ResultSet r = null;
				      r = s.executeQuery("Select * from usuarioSapien WHERE CPF = " + CampoCPF.getText() + " and SENHA = " + "'" + calculadohash +"'" );
				      
				      
				      if (!r.isBeforeFirst() ) {   
				    	  AVISOS.setEnabled(true);
				    	  informeLogin.setText("LOGIN INVALIDO!");
				    	  informeLogin.setForeground(Color.red);
				    	  panel.setVisible(true);
				    	  //StatusLogin.setText("login invalido"); 
				    	  //StatusLogin.setForeground(Color.red);;
				    	  
				      }
				      
				      else {
				    	  BotaoCadastro.setVisible(false);
				    	  AVISOS.setVisible(false);
				    	  AVISOS.setEnabled(false);
				    	  BotaoEntrar.setVisible(false);
				    	  informeLogin.setText("");
				    	  PainelLoginSistema.setEnabled(true);
				    	  PainelLoginSistema.setVisible(true);
				    	  BemVindo.setEnabled(true);
				    	  TextoCpf.setVisible(false);
				    	  BemVindo.setVisible(true);
				    	  TextoSenha.setVisible(false);
				    	  lblNewLabel.setVisible(false);
				    	  TituloSistema.setVisible(false);
				    	  CampoCPF.setVisible(false);
				    	  Camposenha.setVisible(false);
				    	  nomeusuario.setVisible(true);
				      }
				      
				      while (r.next()) {
				    	  AVISOS.setVisible(false);
				    	  nomeusuario.setText(r.getString("Nome"));
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
		

		
		
		
		
	}
}
