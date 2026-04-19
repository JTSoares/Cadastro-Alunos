package View;

import javax.swing.*;
import Model.Professor;

public class TelaProfessor extends JFrame {
    
    private Professor profLogado;

    public TelaProfessor(Professor professor) {
        this.profLogado = professor;
        
        setTitle("Painel do Professor - " + profLogado.getNome());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Área do Docente: " + profLogado.getNome());
        lblTitulo.setBounds(20, 20, 300, 25);
        add(lblTitulo);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(450, 20, 100, 25);
        add(btnSair);

        btnSair.addActionListener(e -> {
            new TelaLogin().setVisible(true);
            dispose();
        });
        
        // Futuramente: Combobox com as disciplinas e formulário de notas
    }
}
