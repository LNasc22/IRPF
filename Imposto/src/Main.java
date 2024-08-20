package br.pucpr.POO.Imposto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel pnlMain;
    private JPanel pnl2;
    private JTextField IRPFtxtNome;
    private JTextField IRPFtxtSalario;
    private JTextField IRPFtxtNasc;
    private JTextField IRPFtxtPensao;
    private JButton btnCriar;
    private JTextField DEPtxtNome;
    private JTextField DEPtxtNasc;
    private JTextField DESPtxtDesc;
    private JTextField DESPtxtValor;
    private JTextField PREVtxtDesc;
    private JTextField PREVtxtValor;
    private JButton btnADD1;
    private JButton btnADD2;
    private JButton btnADD3;
    private JList lstDep;
    private JList lstDesp;
    private JList lstPrev;
    private JButton btnCalc;

    public IRPF previdencias = new IRPF();
    public IRPF despesas = new IRPF();
    public IRPF dependentes = new IRPF();
    private IRPF irpf = null;


    public Main() {
        btnADD1.setEnabled(false);
        btnADD2.setEnabled(false);
        btnADD3.setEnabled(false);
        btnCalc.setEnabled(false);
        
        btnCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnADD1.setEnabled(true);
                btnCriar.setEnabled(false);
                String nome = IRPFtxtNome.getText();
                float salario = Float.parseFloat(IRPFtxtSalario.getText());
                String dataNasc = IRPFtxtNasc.getText();
                float pensao = Float.parseFloat(IRPFtxtPensao.getText());

                irpf = new IRPF(nome, salario, dataNasc, pensao);

                IRPFtxtNome.setText("");
                IRPFtxtSalario.setText("");
                IRPFtxtNasc.setText("");
                IRPFtxtPensao.setText("");
            }
        });
        btnADD1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnADD2.setEnabled(true);
                Dependente dependente = new Dependente(DEPtxtNome.getText(),DEPtxtNasc.getText());

                dependentes.InserirDependentes(dependente);

                DEPtxtNome.setText("");
                DEPtxtNasc.setText("");

                lstDep.setListData(dependentes.getDependente());
            }
        });
        btnADD2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnADD3.setEnabled(true);
                DespesaMedica despesaMedica = new DespesaMedica(DESPtxtDesc.getText(), Float.parseFloat(DESPtxtValor.getText()));

                despesas.InserirDespesaMedica(despesaMedica);

                DESPtxtDesc.setText("");
                DESPtxtValor.setText("");

                lstDesp.setListData(despesas.getDespesaMedica());
            }
        });
        btnADD3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalc.setEnabled(true);
                PrevidenciaPrivada previdencia = new PrevidenciaPrivada(PREVtxtDesc.getText(), Float.parseFloat(PREVtxtValor.getText()));

                previdencias.InserirPrevidenciaPrivada(previdencia);

                PREVtxtDesc.setText("");
                PREVtxtValor.setText("");

                lstPrev.setListData(previdencias.getPrevidenciaPrivada());
            }
        });
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCriar.setEnabled(true);
                btnADD1.setEnabled(false);
                btnADD2.setEnabled(false);
                btnADD3.setEnabled(false);
                btnCalc.setEnabled(false);

                float impostoCalc = irpf.calculateImposto();
                JOptionPane.showMessageDialog(null, "Valor do imposto de renda: R$ " + impostoCalc);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
