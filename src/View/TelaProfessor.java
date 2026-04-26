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
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //*************CABECALHO********************
        JLabel lblTitulo = new JLabel("Área do Docente");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setBounds(20,15,300,35);
        add(lblTitulo);
        
        JButton btnSair = new JButton("Sair"); 
        btnSair.setBounds(360, 20, 100, 25);
        add(btnSair);
        
        btnSair.addActionListener(e -> { ;
        	new TelaLogin().setVisible(true);
        	dispose();
        });
        
        //******************** DISCIPLINAS ********************
        //JLabel lblDisciplina = new JLabel("Disciplinas");
        //lblDisciplina.setBounds(20, 70, 150, 25);
        //add(lblDisciplina);
        
        List<Disciplina> listaDisc = profLogado.getDisciplinas();	//Armazena os nomes das disciplinas em que o professor pertence
        String[] nomeDisciplinas = new String[listaDisc.size()]; 
        for(int i = 0; i< listaDisc.size(); i++) {
        	nomeDisciplinas[i] = listaDisc.get(i).getNome(); 
        }
        
        //******************** ABAS ********************
        JTabbedPane painelAbas = new JTabbedPane();
        painelAbas.setBounds(20, 70, 440, 270);
        add(painelAbas);
        
      //******************** ABA LANCAMENTO DE NOTAS ********************
        JPanel abaNotas = new JPanel();
        abaNotas.setLayout(null);
       
        JLabel lblDisciplinas1 = new JLabel("Disciplina:"); 
        lblDisciplinas1.setBounds(20,20,150, 25);
        abaNotas.add(lblDisciplinas1); 
        
        JComboBox<String> cbxDisciplina = new JComboBox<>(nomeDisciplinas); 
        cbxDisciplina.setBounds(150, 20, 200, 25);
        abaNotas.add(cbxDisciplina);
        
        JLabel lblTipoAvaliacao = new JLabel("Tipo de Avaliação");
        lblTipoAvaliacao.setBounds(20, 60, 150, 25);
        abaNotas.add(lblTipoAvaliacao);
        
        String[] tiposAvaliacao = {"A1", "A2", "P1", "P2"}; 
        JComboBox<String> cbxTipoAvaliacao = new JComboBox<String>(tiposAvaliacao); 
        cbxTipoAvaliacao.setBounds(150, 60, 200, 25);
        abaNotas.add(cbxTipoAvaliacao); 
        
        //******************** FORMULÁRIO DE NOTAS ********************
        JLabel lblMatricula1 = new JLabel("Matrícula do aluno"); 
        lblMatricula1.setBounds(20,100,150,25);
        abaNotas.add(lblMatricula1);
        
        JTextField textoMatriculaNotas = new JTextField();
        textoMatriculaNotas.setBounds(150,100,200,25);
        abaNotas.add(textoMatriculaNotas);     
     
        JLabel lblNota = new JLabel("Nota do Aluno"); 
        lblNota.setBounds(20,140,150,25);
        abaNotas.add(lblNota);
        
        JTextField textoNota = new JTextField();
        textoNota.setBounds(150,140,200,25);
        abaNotas.add(textoNota);
        
        JButton btnSalvar = new JButton("Salvar Nota");
        btnSalvar.setBounds(150, 0, 200, 30);
        abaNotas.add(btnSalvar);
        
        btnSalvar.addActionListener(e -> {
            try {
                if (listaDisc.isEmpty()) return;
                String matricula = textoMatriculaNotas.getText();
                double valorNota = Double.parseDouble(textoNota.getText().replace(",", ".").replaceAll("[^0-9.]", "")); 
                int indexSelecionado = cbxDisciplina.getSelectedIndex();
                Disciplina disciplinaSelecionada = listaDisc.get(indexSelecionado);
                String tipoSelecionado = cbxTipoAvaliacao.getSelectedItem().toString();

                Aluno alunoEncontrado = null;
                for (Aluno a : disciplinaSelecionada.getAlunos()) {
                    if (a.getMatricula().equals(matricula)) { alunoEncontrado = a; break; }
                }

                if (alunoEncontrado != null) {
                    profLogado.lancarAvaliacao(new Avaliacao(tipoSelecionado, valorNota, 1.0), alunoEncontrado, disciplinaSelecionada);
                    JOptionPane.showMessageDialog(null, "Nota lançada com sucesso!");
                    textoMatriculaNotas.setText(""); textoNota.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro: Aluno não encontrado na disciplina.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao processar a nota.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        //********************ABA: LANÇAMENTO DE FALTAS********************
        JPanel abaFaltas = new JPanel();
        abaFaltas.setLayout(null);

        JLabel lblDisciplina2 = new JLabel("Disciplina:");
        lblDisciplina2.setBounds(20, 20, 150, 25);
        abaFaltas.add(lblDisciplina2);

        JComboBox<String> cbxDisciplinasFaltas = new JComboBox<>(nomeDisciplinas);
        cbxDisciplinasFaltas.setBounds(150, 20, 200, 25);
        abaFaltas.add(cbxDisciplinasFaltas);

        JLabel lblMatricula2 = new JLabel("Matrícula do Aluno:");
        lblMatricula2.setBounds(20, 60, 150, 25);
        abaFaltas.add(lblMatricula2);

        JTextField txtMatriculaFaltas = new JTextField();
        txtMatriculaFaltas.setBounds(150, 60, 200, 25);
        abaFaltas.add(txtMatriculaFaltas);
        
        JLabel lblDataFalta = new JLabel("Data (dd/mm/aaaa):");
        lblDataFalta.setBounds(20, 100, 150, 25);
        abaFaltas.add(lblDataFalta);

        JFormattedTextField txtDataFalta = new JFormattedTextField(criarMascaraData()); 
        
        txtDataFalta.setBounds(150, 100, 200, 25);
        abaFaltas.add(txtDataFalta);

        JLabel lblQtdFaltas = new JLabel("Qtd. de Faltas:");
        lblQtdFaltas.setBounds(20, 140, 150, 25);
        abaFaltas.add(lblQtdFaltas);

        JTextField txtQtdFaltas = new JTextField();
        txtQtdFaltas.setBounds(150, 140, 200, 25);
        abaFaltas.add(txtQtdFaltas);

        JButton btnSalvarFalta = new JButton("Registrar Falta(s)");
        btnSalvarFalta.setBounds(150, 190, 200, 30);
        abaFaltas.add(btnSalvarFalta);
       
        btnSalvarFalta.addActionListener(e -> {
            try {
                if (listaDisc.isEmpty()) return;
                String matricula = txtMatriculaFaltas.getText();
                int qtdFaltas = Integer.parseInt(txtQtdFaltas.getText().replaceAll("[^0-9]", ""));
                String dataDigitada = txtDataFalta.getText(); 

                int indexSelecionado = cbxDisciplinasFaltas.getSelectedIndex();
                Disciplina disciplinaSelecionada = listaDisc.get(indexSelecionado);

                Aluno alunoEncontrado = null;
                for (Aluno a : disciplinaSelecionada.getAlunos()) {
                    if (a.getMatricula().equals(matricula)) { alunoEncontrado = a; break; }
                }

                if (alunoEncontrado != null) {
                    profLogado.lancarFaltas(alunoEncontrado, disciplinaSelecionada, dataDigitada,  qtdFaltas);
                    JOptionPane.showMessageDialog(null, qtdFaltas + " falta(s) registrada(s) com sucesso!");
                    txtMatriculaFaltas.setText(""); txtQtdFaltas.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro: Aluno não encontrado na disciplina.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Digite um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        painelAbas.addTab("Lançar Notas", abaNotas);
        painelAbas.addTab("Registrar Faltas", abaFaltas);
    }
    
    /**
     * Método auxiliar (Fábrica) para criar a máscara de data isoladamente.
     * Isso resolve o problema de escopo (Effectively Final) da Lambda.
     */
    private javax.swing.text.MaskFormatter criarMascaraData() {
        try {
            javax.swing.text.MaskFormatter mascara = new javax.swing.text.MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            return mascara;
        } catch (java.text.ParseException e) {
            System.err.println("Erro na máscara: " + e.getMessage());
            return null; 
        }
    }
}
