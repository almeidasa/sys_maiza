package Telas;

import DAO.BD;
import static Principal.CadastroRedmine.verificaConexao;
import Principal.Redmine;
import Uteis.ValidaCPF;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @Autor Winder Rezende <windergt@gmail.com>
 * @Data 07/06/2018
 */
public class TelaGerenciarUsr extends javax.swing.JFrame {

    public TelaGerenciarUsr() {
        initComponents();

        verificaCadastros();

        setMinimumSize(new Dimension(586, 205));

        URL CaminhoIcone = getClass().getResource("/Imagens/up.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(CaminhoIcone);
        this.setIconImage(iconeTitulo);

        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        txtCPF = new javax.swing.JFormattedTextField();
        jPanel21 = new javax.swing.JPanel();
        txtApiKey = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        txtIdRedmine = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CR - Gerência de Usuários");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(61, 128, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Gerenciar.png"))); // NOI18N
        jLabel1.setText("Gerenciar Usuário");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 128, 204)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 128, 204)));
        jPanel3.setPreferredSize(new java.awt.Dimension(1048, 675));

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnExcluir.setPreferredSize(new java.awt.Dimension(83, 43));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/AlterarUsr.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/home.png"))); // NOI18N
        btnVoltar.setText("Tela Inicial");
        btnVoltar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnVoltar.setPreferredSize(new java.awt.Dimension(103, 43));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Confirm.png"))); // NOI18N
        btnSalvar.setText("Cadastar");
        btnSalvar.setEnabled(false);
        btnSalvar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnSalvar.setPreferredSize(new java.awt.Dimension(97, 43));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Usuário"));
        jPanel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N
        jPanel20.setPreferredSize(new java.awt.Dimension(175, 54));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCPF.setText("");
        txtCPF.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txtCPF.setEnabled(false);
        txtCPF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPFFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ApiKey Redmine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        txtApiKey.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtApiKey.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txtApiKey.setEnabled(false);
        txtApiKey.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApiKeyFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtApiKey)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(txtApiKey, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID Redmine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        txtIdRedmine.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtIdRedmine.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txtIdRedmine.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtIdRedmine, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtIdRedmine, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        txtNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txtNome.setEnabled(false);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        txtAviso.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAviso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Icon icoSair = new ImageIcon(TelaGerenciarUsr.class.getResource("/Imagens/Sair.png"));
    Icon icoVoltar = new ImageIcon(TelaGerenciarUsr.class.getResource("/Imagens/TelaIni.png"));

    public void verificaCadastros() {
        try {
            String cpf;
            BD app = new BD();
            cpf = app.buscarCPF();

            if (cpf.equals("0")) {
                camposInicio();
            } else {
                carregarDados();
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        }
    }

    public void carregarDados() {
        BD app = new BD(txtCPF, txtApiKey, txtIdRedmine, txtNome, txtAviso);
        app.preencherTelaGerencia();
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if (btnVoltar.getText().equals("Sair")) {
            System.exit(0);
        } else {
            dispose();
            new TelaCadastro().setVisible(true);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!txtCPF.getText().equals("   .   .   -  ") && !txtApiKey.getText().trim().equals("") && !txtIdRedmine.getText().trim().equals("")) {
            if (btnSalvar.getText().equals("Salvar")) {
                int i = JOptionPane.showConfirmDialog(this, "Deseja Confirmar a Alteração?\n" + "<html><b><span style=\"color:RED\">OBS: Essa operação irá apagar o usuário e os lançamentos antigos!!!</span></b></hmtl>", "Confirme", JOptionPane.YES_NO_OPTION);

                if (i == JOptionPane.YES_OPTION) {
                    txtAviso.setText("Salvando...");
                    BD app = new BD(txtCPF, txtApiKey, txtIdRedmine, txtNome, txtAviso);
                    app.updateUser();
                    desativarCampos();
                    setAlterar();
                    carregarDados();
                } else if (i == JOptionPane.NO_OPTION) {
                    txtAviso.setText("");
                    JOptionPane.showMessageDialog(this, "Operação Cancelada!!!", "Alerta!", 0);
                }
            } else {
                int j = JOptionPane.showConfirmDialog(this, "Confirmar a inclusão desse usuário?\n", "Confirme", JOptionPane.YES_NO_OPTION);

                if (j == JOptionPane.YES_OPTION) {
                    txtAviso.setText("Incluindo usuário...");
                    BD app = new BD(txtCPF, txtApiKey, txtIdRedmine, txtNome, txtAviso);
                    app.insertUser();
                    desativarCampos();
                    btnAlterar.setEnabled(true);
                    setAlterar();
                    carregarDados();
                    btnVoltar.setText("Tela Inicial");
                    btnVoltar.setIcon(icoVoltar);
                } else if (j == JOptionPane.NO_OPTION) {
                    txtAviso.setText("");
                    JOptionPane.showMessageDialog(this, "Operação Cancelada!!!", "Alerta!", 0);
                }
            }
        } else {
            txtAviso.setText("<html><b><span style=\\\"color:RED\\\">Preencha todos os campos!</span></b></hmtl>");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o Usuário?\n" + "<html><b><span style=\"color:RED\">OBS: Essa operação irá apagar todos os registros<br>do usuário e não poderá ser desfeita!!!</span></b></hmtl>", "Confirme", JOptionPane.YES_NO_OPTION);

        if (i == JOptionPane.YES_OPTION) {
            BD app = new BD(txtCPF, txtApiKey, txtIdRedmine, txtNome, txtAviso);
            app.deletarUser();
            app.deletarLancamentos();
            app.deletarSequencia();
            camposInicio();

            txtCPF.setText("");
            txtApiKey.setText("");
            txtIdRedmine.setText("");
            txtNome.setText("");
        } else if (i == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Operação Cancelada!!!", "Alerta!", 0);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public void camposInicio() {
        btnSalvar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnVoltar.setText("Sair");
        btnVoltar.setIcon(icoSair);
        ativarCampos();
    }

    public void ativarCampos() {
        txtCPF.setEnabled(true);
        txtNome.setEnabled(true);
        txtApiKey.setEnabled(true);
    }

    public void desativarCampos() {
        txtCPF.setEnabled(false);
        txtNome.setEnabled(false);
        txtApiKey.setEnabled(false);
    }

    public void setAlterar() {
        btnAlterar.setText("Alterar");
        btnSalvar.setText("Cadastrar");
        btnExcluir.setEnabled(true);
        btnVoltar.setEnabled(true);
        btnSalvar.setEnabled(false);
        alterar = true;
        btnAlterar.setIcon(icoAlt);
        desativarCampos();
    }

    public void setCancelar() {
        btnAlterar.setText("Cancelar");
        btnSalvar.setText("Salvar");
        btnExcluir.setEnabled(false);
        btnVoltar.setEnabled(false);
        btnSalvar.setEnabled(true);
        alterar = false;
        btnAlterar.setIcon(icoCan);
        ativarCampos();
    }

    Icon icoAlt = new ImageIcon(TelaGerenciarUsr.class.getResource("/Imagens/AlterarUsr.png"));
    Icon icoCan = new ImageIcon(TelaGerenciarUsr.class.getResource("/Imagens/Cancelar.png"));

    public static String cpfAntigo;

    boolean alterar = true;
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        cpfAntigo = txtCPF.getText().replace(".", "").replace("-", "");
        if (alterar) {
            setCancelar();
        } else {
            setAlterar();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusLost
        String cpf = txtCPF.getText().replaceAll("[\\- | ^.]", "");

        if (ValidaCPF.isCPF(cpf) == false) {
            JOptionPane.showMessageDialog(this, "CPF Inválido", "Atenção!", 0);
        } else {
            txtCPF.setText(ValidaCPF.imprimeCPF(cpf));
        }
    }//GEN-LAST:event_txtCPFFocusLost

    private void txtApiKeyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApiKeyFocusLost
        Redmine.buscarUsuario(txtApiKey.getText(), txtCPF, txtNome, txtIdRedmine);
    }//GEN-LAST:event_txtApiKeyFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtApiKey;
    private javax.swing.JLabel txtAviso;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtIdRedmine;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

}
