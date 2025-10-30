package InterfaceGrafica;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.*;

import Alunos.Aluno;
import Alunos.SistemaCadastro;

public class TelaInicial {
	static SistemaCadastro sistema = new SistemaCadastro();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Cadastro de Alunos");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        
        //Criacao de botoes
        JButton botaoCadastrar = new JButton("Cadastrar Aluno");	//Botao de Cadastro
        panel.add(botaoCadastrar);
        
        JButton mostrarAlunos = new JButton("Alunos Cadastrados");
        panel.add(mostrarAlunos);
        
        JButton removerAlunos = new JButton("Remover aluno");
        panel.add(removerAlunos);
         
        // Aqui você conecta o botão à sua lógica
        botaoCadastrar.addActionListener(e -> abrirFormularioCadastro());
        mostrarAlunos.addActionListener(e -> mostrarAlunos());
        removerAlunos.addActionListener(e->removerAluno());
        frame.setVisible(true);
    }
    
	public static void abrirFormularioCadastro() {
		
		//Nova janela para preencher os dados
		JFrame janelaCadastro = new JFrame("Cadastrar Aluno");
		janelaCadastro.setSize(300,250);
		janelaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Fecha apenas essa janela quando o usuario clica no botao para fechar
		
		//Criacao do painel
		JPanel painelCadasto = new JPanel();
		painelCadasto.setLayout(new BoxLayout(painelCadasto, BoxLayout.Y_AXIS)); //Define que os componentes vao se organizar no painel na vertical, de cima para baixo
		janelaCadastro.add(painelCadasto); //Adiciona o painel na janela
		
		
		//Campos para o usuario digitar o texto
		JTextField campoNome = new JTextField(30);
		JTextField campoMatricula = new JTextField(20);
		JTextField campoIdade = new JTextField(20);
		
		painelCadasto.add(new JLabel("Nome do aluno"));
		painelCadasto.add(campoNome);
		
		painelCadasto.add(new JLabel("Idade do aluno"));
		painelCadasto.add(campoIdade);
		
		painelCadasto.add(new JLabel("Matricula do aluno"));
		painelCadasto.add(campoMatricula);
		
		//Botao para salvar
		JButton botaoSalvar = new JButton("Salvar");
		painelCadasto.add(botaoSalvar);
		
		//Logica para armazenar valores
		botaoSalvar.addActionListener(e ->{
			String nome = campoNome.getText();
			String matricula = campoMatricula.getText();
			String idadeString = campoIdade.getText();
			
			//Validacao dos campos
			if (nome.isEmpty() || matricula.isEmpty() || idadeString.isEmpty()) {
				JOptionPane.showMessageDialog(janelaCadastro, "Preencha todos os campos!"); //Mensagem para preenchimento dos campos
				return; //Interrompe o codigo
			}
			
			//Transforma a idade string para inteiro
			int idade;
			try {
                idade = Integer.parseInt(idadeString);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janelaCadastro, "Idade inválida.");
                return;
            }
			
			//Adiciona o aluno
			
			sistema.cadastrarAlunoIg(nome, matricula, idade);
			JOptionPane.showMessageDialog(janelaCadastro,
	                "Aluno cadastrado:\nNome: " + nome + "\nMatrícula: " + matricula + "\nIdade: " + idade);

	            janelaCadastro.dispose(); //Fecha a janela após salvar
	        });
			
			janelaCadastro.setVisible(true);
		};
		
	public static void mostrarAlunos() {
		//Criando a janela
		JFrame janelaLista = new JFrame("Lista de alunos");
		janelaLista.setSize(500,300);
		janelaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
		
		
		//Cabecalho da tabela
		String [] colunas = {"Nome", "Matricula", "Idade"};
		
		//Recebendo a lista de alunos
		ArrayList<Aluno> alunos = sistema.getListaAlunos();
		alunos.sort(Comparator.comparing(Aluno::getNome)); //Ordena em ordem alfabetica
		
		String[][] dados = new String[alunos.size()][3];
		
		for(int i=0; i< alunos.size(); i++) {
			Aluno a = alunos.get(i);
			dados[i][0] = a.getNome();
			dados[i][1] = a.getMatricula();
			dados[i][2] = String.valueOf(a.getIdade());
			
		}
		
	    //Criando a tabela
		JTable tabela = new JTable(dados, colunas);
		JScrollPane scroll = new JScrollPane(tabela); //Menu de rolagem caso precise
		
		janelaLista.add(scroll);
		janelaLista.setVisible(true);
		
	}
		
	public static void removerAluno() {
		//Nova janela para preencher os dados
		JFrame janelaRemocao = new JFrame("Remover aluno");
		janelaRemocao.setSize(300,250);
		janelaRemocao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Fecha apenas essa janela quando o usuario clica no botao para fechar
		
		//Painel para remocao
		JPanel painelRemocao = new JPanel();
		painelRemocao.setLayout(new BoxLayout(painelRemocao, BoxLayout.Y_AXIS)); //Define que os componentes vao se organizar no painel na vertical, de cima para baixo
		janelaRemocao.add(painelRemocao); //Adiciona o
		
		//Campos para o usuario digitar o texto
		JTextField campoMatricula = new JTextField(30);
		
		painelRemocao.add(new JLabel("Matrícula para remoção"));
		painelRemocao.add(campoMatricula);
		
		//Botao para salvar
		JButton botaoSalvar = new JButton("Salvar");
		painelRemocao.add(botaoSalvar);
		
		botaoSalvar.addActionListener(e->{
			String matricula = campoMatricula.getText();
			
			
			//Validacao dos campos
			if (matricula.isEmpty() ) {
				JOptionPane.showMessageDialog(janelaRemocao, "É necessário inserir a matricula para a remoção"); //Mensagem para preenchimento dos campos
				return; //Interrompe o codigo
			}
			sistema.removerAlunoIG(matricula);
			
			
		});
				
	            
				
		}
		
		
		
		
		
	}




