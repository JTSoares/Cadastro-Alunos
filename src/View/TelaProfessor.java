package View;

import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color; 

import Model.*;

public class TelaProfessor extends JFrame {
    
    private Professor profLogado;

    public TelaProfessor(Professor professor) {
        this.profLogado = professor;
        
        setTitle("Painel do Professor - " + profLogado.getNome());
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //*************CABECALHO********************
        JLabel lblTitulo = new JLabel("Lançamento de notas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setBounds(20,15,300,35);
        add(lblTitulo);
        
        JButton btnSair = new JButton("Sair"); 
        btnSair.setBounds(310, 20, 100, 25);
        add(btnSair);
        
        btnSair.addActionListener(e -> { ;
        	new TelaLogin().setVisible(true);
        	dispose();
        });
        
        //******************** DISCIPLINAS ********************
        JLabel lblDisciplina = new JLabel("Disciplinas");
        lblDisciplina.setBounds(20, 70, 150, 25);
        add(lblDisciplina);
        
        List<Disciplina> listaDisc = profLogado.getDisciplinas();	//Armazena os nomes das disciplinas em que o professor pertence
        String[] nomeDisciplinas = new String[listaDisc.size()]; 
        for(int i = 0; i< listaDisc.size(); i++) {
        	nomeDisciplinas[i] = listaDisc.get(i).getNome(); 
        }
        
        //******************** ABAS ********************
        JTabbedPane painelAbas = new JTabbedPane();
        painelAbas.setBounds(20, 70, 440, 270);
        add(painelAbas);
        
        
        JPanel abaNotas = new JPanel();
        abaNotas.setLayout(null);
        
        JComboBox<String> cbxDisciplina = new JComboBox<>(nomeDisciplinas); 
        cbxDisciplina.setBounds(150, 70, 200, 25);
        abaNotas.add(cbxDisciplina);
        
        //******************** FORMULÁRIO DE NOTAS ********************
        JLabel lblMatriicula = new JLabel("Matrícula do aluno"); 
        lblMatriicula.setBounds(20,150,150,25);
        abaNotas.add(lblMatriicula);
        
        JTextField textoMatricula = new JTextField();
        textoMatricula.setBounds(150,150,200,25);
        abaNotas.add(textoMatricula); 
        
        JLabel lblTipoAvaliacao = new JLabel("Tipo de Avaliação");
        lblTipoAvaliacao.setBounds(20, 110, 150, 25);
        abaNotas.add(lblTipoAvaliacao);
        
        String[] tiposAvaliacao = {"A1", "A2", "P1", "P2"}; 
        JComboBox<String> cbxTipoAvaliacao = new JComboBox<String>(tiposAvaliacao); 
        cbxTipoAvaliacao.setBounds(150, 110, 200, 25);
        abaNotas.add(cbxTipoAvaliacao); 
        
     
        JLabel lblNota = new JLabel("Nota do Aluno"); 
        lblNota.setBounds(20,190,150,25);
        abaNotas.add(lblNota);
        
        JTextField textoNota = new JTextField();
        textoNota.setBounds(150,190,200,25);
        abaNotas.add(textoNota);
        
        JButton btnSalvar = new JButton("Salvar Nota");
        btnSalvar.setBounds(150, 240, 200, 30);
        abaNotas.add(btnSalvar);
        
        btnSalvar.addActionListener(e -> {
        	try {
				String matricula = textoMatricula.getText();
				String txtNota = textoNota.getText().replace(",", ".");
				txtNota = txtNota.replaceAll("[^0-9.]", ".");
				//double valorNota = Double.parseDouble(textoMatricula.getText().replace(",", ".").trim()); 
				double valorNota = Double.parseDouble(txtNota);
				
				int indexSelecionado = cbxDisciplina.getSelectedIndex();	//Descobre a disciplina selecioanada na caixinha
				Disciplina disciplinaSelecionada = listaDisc.get(indexSelecionado);
				
				String tipoSelecionado = cbxTipoAvaliacao.getSelectedItem().toString(); 
				
				Aluno alunoEncontrado = null;
				for(Aluno a: disciplinaSelecionada.getAlunos()) {
					if(a.getMatricula().equals(matricula)) {
						alunoEncontrado = a; 
						break;
					}
				}
				
				if (alunoEncontrado != null) {
					Avaliacao novaNota = new Avaliacao(tipoSelecionado, valorNota, 1.0);
                    profLogado.lancarAvaliacao(novaNota, alunoEncontrado, disciplinaSelecionada);
                    
                    JOptionPane.showMessageDialog(null, "Nota lançada com sucesso para " + alunoEncontrado.getNome() + "!");
                    
                    //Limpa os campos para o próximo lançamento
                    textoMatricula.setText("");
                    textoNota.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "ALuno não matriculado nessa disciplina", "Aviso", JOptionPane.WARNING_MESSAGE);

				}
				
			} catch (NumberFormatException ex) {
                // Vamos imprimir no console exatamente o que o Java está lendo
                System.out.println("ERRO: O Java tentou converter o texto: '" + textoNota.getText() + "'");
                
                JOptionPane.showMessageDialog(null, "Digite um valor numérico válido para a nota.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                // Caso seja OUTRO erro (como NullPointerException)
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Aconteceu um erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
