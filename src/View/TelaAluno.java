package View;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;

import Model.*; 


public class TelaAluno extends JFrame{
	private Aluno alunoLogado; 
	private TableRowSorter<DefaultTableModel> sorter;
	
	public TelaAluno(Aluno aluno) {
		this.alunoLogado = aluno; 
		
		setTitle("Painel do Aluno - " + alunoLogado.getNome());
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        //Cabecalho
        JLabel lblTitulo = new JLabel("Boletim Academico");
        lblTitulo.setBounds(20, 20, 200, 25);
        add(lblTitulo);
        
        JLabel lblInfoNome = new JLabel("Aluno: " + alunoLogado.getNome() + " |  Matricula: " + aluno.getMatricula());
        lblTitulo.setBounds(20, 45, 400, 25);
        add(lblInfoNome);
        
        // O botão de sair para voltar pro Login
        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(460, 20, 100, 25);
        add(btnSair);

        btnSair.addActionListener(e -> {
            new TelaLogin().setVisible(true);
            dispose(); // Fecha o painel do aluno
        });
        
     // --- ÁREA DE FILTROS (A NOVIDADE!) ---
        JLabel lblFiltroDisc = new JLabel("Buscar Disciplina:");
        lblFiltroDisc.setBounds(20, 75, 120, 25);
        add(lblFiltroDisc);

        JTextField txtFiltroDisciplina = new JTextField();
        txtFiltroDisciplina.setBounds(130, 75, 150, 25);
        add(txtFiltroDisciplina);

        JLabel lblFiltroStatus = new JLabel("Filtrar Situação:");
        lblFiltroStatus.setBounds(300, 75, 100, 25);
        add(lblFiltroStatus);

        // JComboBox é a lista suspensa (Drop-down)
        String[] opcoesStatus = {"Todos", "Aprovado", "Exame", "Reprovado"};
        JComboBox<String> cbxFiltroStatus = new JComboBox<>(opcoesStatus);
        cbxFiltroStatus.setBounds(400, 75, 120, 25);
        add(cbxFiltroStatus);
        
		
        String [] colunas = {"Disciplinas", "Média Final", "Faltas", "Situação"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0); 
        
        if (alunoLogado.getHistorico() != null) {
			for (Boletim b : alunoLogado.getHistorico()) {
				String nomeDisciplina = b.getDisciplina().getNome(); 
				b.calcularMediaFinal();
				double media = b.getMediaFinal(); 
				int faltas = b.getFaltas(); 
				
				// Aplicando a Regra de Negócio Acadêmica
                String situacao = "Analisando...";
                if (media >= 7.0 && faltas < 10) {
                    situacao = "Aprovado";
                } else if (media >= 5.0 && media < 7.0) {
                    situacao = "Exame";
                } else {
                    situacao = "Reprovado";
                }
                
                Object[] linha = {nomeDisciplina, String.format("%.2f", media), faltas, situacao};
                modeloTabela.addRow(linha);
				
				
			}
		}
        
        JTable tabelaBoletim = new JTable(modeloTabela); 
        // --- ATIVANDO O FILTRO NA TABELA ---
        sorter = new TableRowSorter<>(modeloTabela);
        tabelaBoletim.setRowSorter(sorter); // Diz para a tabela usar o nosso motor de busca

        JScrollPane scrollPane = new JScrollPane(tabelaBoletim);
        scrollPane.setBounds(20, 115, 590, 250); // Desci a tabela para caber os filtros
        add(scrollPane);
        
        // --- LÓGICA DE FUNCIONAMENTO DOS FILTROS ---

        // Ação para quando o usuário digitar algo no campo de Disciplina
        txtFiltroDisciplina.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { aplicarFiltros(txtFiltroDisciplina, cbxFiltroStatus); }
            public void removeUpdate(DocumentEvent e) { aplicarFiltros(txtFiltroDisciplina, cbxFiltroStatus); }
            public void changedUpdate(DocumentEvent e) { aplicarFiltros(txtFiltroDisciplina, cbxFiltroStatus); }
        });

        // Ação para quando o usuário escolher uma opção na caixa de Situação
        cbxFiltroStatus.addActionListener(e -> aplicarFiltros(txtFiltroDisciplina, cbxFiltroStatus));
    }

    /**
     * Método que junta os dois filtros (Disciplina + Situação) e aplica na tabela.
     */
    private void aplicarFiltros(JTextField txtFiltroDisciplina, JComboBox<String> cbxFiltroStatus) {
        String textoDisc = txtFiltroDisciplina.getText();
        String textoStatus = cbxFiltroStatus.getSelectedItem().toString();

        List<RowFilter<Object, Object>> filtros = new ArrayList<>();

        // 1. Filtro de Disciplina (Ignora maiúsculas/minúsculas usando o (?i))
        // Busca na coluna 0 (A primeira coluna, que é "Disciplina")
        if (textoDisc.trim().length() > 0) {
            filtros.add(RowFilter.regexFilter("(?i)" + textoDisc, 0));
        }

        // 2. Filtro de Situação (Busca na coluna 3)
        if (!textoStatus.equals("Todos")) {
            // O "^" e "$" garantem que ele busque a palavra exata
            filtros.add(RowFilter.regexFilter("^" + textoStatus + "$", 3));
        }

        // Junta os dois filtros e manda o Sorter aplicar na tabela
        sorter.setRowFilter(RowFilter.andFilter(filtros));
        
        
	}
}
