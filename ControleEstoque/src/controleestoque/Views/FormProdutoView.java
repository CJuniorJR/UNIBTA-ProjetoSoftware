/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Views;
import controleestoque.Controllers.ProdutoController;
import controleestoque.Controllers.CategoriaController;
import controleestoque.Controllers.TipoController;
import controleestoque.Models.Produto;
import controleestoque.Models.Categoria;
import controleestoque.Models.TipoProduto;
import controleestoque.Views.CategoriaView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilhermemarques
 */
public class FormProdutoView extends javax.swing.JFrame {
    ProdutoController produtoController = new ProdutoController();
    ProdutoView produtoView = null;
    Produto produtoEdit = null;
    CategoriaController categoriaController = new CategoriaController();
    TipoController tipoController = new TipoController();
    FormVendaView formVendaView = null;
    boolean isEditing = false;
    
    
    /**
     * Creates new form ProdutoView
     */
    public FormProdutoView(FormVendaView formVendaview) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.formVendaView = formVendaview;
    }
    
    public FormProdutoView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    //Contrutor para salvar um produto
    public FormProdutoView(ProdutoView produtoView) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.produtoView = produtoView;
    }

    //Construtor para editar um produto
    public FormProdutoView(Produto produto, ProdutoView produtoView) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.produtoView = produtoView;
        this.produtoEdit = produto;
        this.isEditing = true;
        //label.setText("Editar Categoria");
    }
    
    public void VerificarProdutoCarregado() {
        if(this.produtoEdit != null) {
            txtNome.setText(this.produtoEdit.getNome());
            dpdCategoria.setSelectedItem(this.produtoEdit.getCategoria().getDescricao());
            dpdTipo.setSelectedItem(this.produtoEdit.getTipoProduto().getDescricao());
            txtDescricao.setText(this.produtoEdit.getDescricao());
            txtPreco.setText(Double.toString(this.produtoEdit.getPreco()));
        }
    }
    
    public void ConsultarCategorias(){
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        try {
            categorias = categoriaController.Consultar();
            for (Categoria categoria : categorias){
                dpdCategoria.addItem(categoria.getDescricao());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ConsultarTipos(){
        ArrayList<TipoProduto> tipos = new ArrayList<TipoProduto>();
        try{
            tipos = tipoController.Consultar();
            for(TipoProduto tipoProduto : tipos){
                dpdTipo.addItem(tipoProduto.getDescricao());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormProdutoView.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblPreco1 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        dpdCategoria = new javax.swing.JComboBox<>();
        btnCategoria = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        dpdTipo = new javax.swing.JComboBox<>();
        btnTipo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNome.setText("Nome");

        lblDescricao.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        lblPreco.setText("Preço:");

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        lblPreco1.setText("R$");

        lblCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCategoria.setText("Categoria");

        dpdCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpdCategoriaActionPerformed(evt);
            }
        });

        btnCategoria.setText("+");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        lblTipo.setText("Tipo");

        btnTipo.setText("+");
        btnTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoActionPerformed(evt);
            }
        });

        jLabel1.setText("Produto");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDescricao)
                                            .addComponent(lblPreco))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblPreco1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTipo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dpdTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCategoria)
                                        .addGap(2, 2, 2)
                                        .addComponent(dpdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblDescricao)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco1)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(dpdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(dpdTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void dpdCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpdCategoriaActionPerformed
    }//GEN-LAST:event_dpdCategoriaActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        FormCategoriaView formCategoria = new FormCategoriaView(this);
        formCategoria.setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoActionPerformed
        FormTipoProdutoView formTipoProduto = new FormTipoProdutoView(this);
        formTipoProduto.setVisible(true);
    }//GEN-LAST:event_btnTipoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ConsultarCategorias();
        ConsultarTipos();
        VerificarProdutoCarregado();
    }//GEN-LAST:event_formWindowOpened

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Produto produto = new Produto();

        if(!isEditing) {
            try {
                produto.setCategoria(new Categoria(dpdCategoria.getSelectedItem().toString()));
                produto.setTipoProduto(new TipoProduto(dpdTipo.getSelectedItem().toString()));
                produto.setNome(txtNome.getText());
                produto.setDescricao(txtDescricao.getText());
                produto.setPreco(Double.parseDouble(txtPreco.getText()));
                
                produtoController.Salvar(produto);

                
                
                if(produtoView != null) 
                    produtoView.ConsultarProdutos();
                
                if(formVendaView != null)
                    formVendaView.ConsultarProdutos();
                
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(FormProdutoView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.produtoEdit.setCategoria(new Categoria(dpdCategoria.getSelectedItem().toString()));
                this.produtoEdit.setTipoProduto(new TipoProduto(dpdTipo.getSelectedItem().toString()));
                this.produtoEdit.setNome(txtNome.getText());
                this.produtoEdit.setDescricao(txtDescricao.getText());
                this.produtoEdit.setPreco(Double.parseDouble(txtPreco.getText()));
                
                produtoController.Editar(this.produtoEdit);

                this.setVisible(false);
                produtoView.ConsultarProdutos();
                
            } catch (SQLException ex) {
                Logger.getLogger(FormProdutoView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProdutoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTipo;
    private javax.swing.JComboBox<String> dpdCategoria;
    private javax.swing.JComboBox<String> dpdTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblPreco1;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
