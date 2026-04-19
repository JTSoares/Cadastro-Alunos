package View;

import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import Controller.Sistema;
import Model.Usuario;

public class TelaLogin extends JFrame{
	private JTextField txtMatricula;
	private JPasswordField txtSenha; 
	private JButton btnEntrar; 

	public TelaLogin() {
		setTitle("Sistema Acadêmico - Login");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel lbUser = new javax.swing.JLabel("Matrícula");
		lbUser.setBounds(20,30,80,25);
		add(lbUser);
		
		txtMatricula = new javax.swing.JTextField();
		txtMatricula.setBounds(100,30,160,25);
		add(txtMatricula); 
		
		JLabel lbPass = new javax.swing.JLabel("CPF (Senha)");
		lbPass.setBounds(20,70,80,25);
		add(lbPass);
		
		txtSenha = new javax.swing.JPasswordField();
		txtSenha.setBounds(100,70,160,25);
		add(txtSenha);
		
		btnEntrar = new javax.swing.JButton("Entrar"); 
		btnEntrar.setBounds(100,110,80,25);
		add(btnEntrar); 
		
		
		btnEntrar.addActionListener(new java.awt.event.ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String matricula = txtMatricula.getText();
				String senha = new java.lang.String(txtSenha.getPassword());
				
				Usuario user = Sistema.autenticar(matricula, senha);
				
				if (user != null) {
				    JOptionPane.showMessageDialog(null, "Bem-vindo, " + user.getNome());
				    
				    // O "Roteamento": Descobre quem é e abre a tela certa
				    if (user instanceof Model.Aluno) {
				        TelaAluno tela = new TelaAluno((Model.Aluno) user); // Passa o aluno logado para a tela
				        tela.setVisible(true);
				    } 
				    else if (user instanceof Model.Professor) {
				        TelaProfessor tela = new TelaProfessor((Model.Professor) user);
				        tela.setVisible(true);
				    }
				    
				    dispose(); // Fecha a janela de Login
				    
				} else {
				    JOptionPane.showMessageDialog(null, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
								
			}
		});
		
	}
	
	
	
	
	
}

