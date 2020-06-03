/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleestoque.Views;

import controleestoque.Controllers.ClienteController;
import controleestoque.Controllers.ProdutoController;
import controleestoque.Controllers.VendaController;
import controleestoque.Models.Cliente;
import controleestoque.Models.Produto;
import controleestoque.Models.ProdutoVenda;
import controleestoque.Models.Venda;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author guilhermemarques
 */
public class FormVendaView extends javax.swing.JFrame {
    ArrayList<Produto> produtosCarregados = new ArrayList<Produto>();
    ArrayList<ProdutoVenda> produtosVenda = new ArrayList<ProdutoVenda>();
    ClienteController clienteController = new ClienteController();
    ProdutoController produtoController = new ProdutoController();
    VendaController vendaController = new VendaController();
    Venda vendaVisualizacao = null;
    VendaView vendaView = null;
    Double total = 0.0;
    boolean isViewing = false;
    /**
     * Creates new form FormVendaView
     */
    public FormVendaView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    //Contrutor para salvar um funcionario pela tela de visualização de funcionarios.
    public FormVendaView(VendaView vendaView) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.vendaView = vendaView;
    }

    //Construtor para editar um funcionario
    public FormVendaView(int idVenda, VendaView vendaView) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.vendaView = vendaView;
        this.vendaVisualizacao = vendaController.Consultar(idVenda);
        this.isViewing = true;
        //label.setText("Editar Categoria");
    }
    
    public void ConsultarProdutosVenda(int id) {
        ArrayList<ProdutoVenda> produtosVendaConsulta = new ArrayList<ProdutoVenda>();
        DefaultTableModel model =(DefaultTableModel) tblItens.getModel();
        model.setNumRows(0);
        
        try {
            produtosVendaConsulta = vendaController.ConsultarProdutosVenda(id);
            
            for (ProdutoVenda produtoVenda : produtosVendaConsulta){
            model.addRow(new Object[] 
            { 
               //retorna os dados da tabela do BD, cada campo e um coluna.
               produtoVenda.getProduto().getNome(),
               produtoVenda.getQuantidade(),
               produtoVenda.getTotal()
            });
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VerificarVendaCarregada() {
        if(this.vendaVisualizacao != null) {
            ConsultarProdutosVenda(this.vendaVisualizacao.getID());
            txtTotal.setText(Double.toString(this.vendaVisualizacao.getTotal()));
            dpdFormaPagamento.setSelectedItem(this.vendaVisualizacao.getFormaPagamento());
            txtData.setText(this.vendaVisualizacao.getData());
            
            txtTotal.setEnabled(false);
            dpdFormaPagamento.setEnabled(false);
            txtData.setEditable(false);
            tblItens.setEnabled(false);
            dpdCliente.setEnabled(false);
            dpdProduto.setEnabled(false);
            txtQuantidade.setEnabled(false);
            btnSalvar.setEnabled(false);
            btnInserir.setEnabled(false);
            btnProduto.setEnabled(false);
            btnProduto1.setEnabled(false);
        }
    }
    
    public void ConsultarClientes(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            dpdCliente.removeAllItems();
            clientes = clienteController.Consultar();
            for (Cliente cliente : clientes){
                dpdCliente.addItem(cliente.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ConsultarProdutos(){
        try {
            dpdProduto.removeAllItems();    
            this.produtosCarregados = produtoController.Consultar();
            for (Produto produto : this.produtosCarregados){
                dpdProduto.addItem(produto.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void FormatarCampos() {
        try {
            MaskFormatter dataNascimentoMask = new MaskFormatter("##/##/####");
            dataNascimentoMask.install(txtData);
        } catch (ParseException ex) {
            Logger.getLogger(FormClienteView.class.getName()).log(Level.SEVERE, null, ex);
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

        lblPreco = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblPreco2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblProduto = new javax.swing.JLabel();
        dpdProduto = new javax.swing.JComboBox<>();
        btnProduto = new javax.swing.JButton();
        lblData = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        txtQuantidade = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        lblNome1 = new javax.swing.JLabel();
        btnProduto1 = new javax.swing.JButton();
        dpdCliente = new javax.swing.JComboBox<>();
        btnInserir = new javax.swing.JButton();
        dpdFormaPagamento = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblPreco.setText("Forma de Pagamento");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblPreco2.setText("R$");

        lblProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProduto.setText("Produto");

        dpdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpdProdutoActionPerformed(evt);
            }
        });

        btnProduto.setText("+");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        lblData.setText("Data");

        lblNome.setText("Quantidade");

        txtData.setText(" ");
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        txtQuantidade.setMinimumSize(new java.awt.Dimension(11, 30));

        lblDescricao.setText("Total");

        lblTitulo.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lblTitulo.setText("Venda");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblNome1.setText("Cliente");

        btnProduto1.setText("+");
        btnProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduto1ActionPerformed(evt);
            }
        });

        dpdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpdClienteActionPerformed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        dpdFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito", "Dinheiro" }));

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblItens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblData)
                        .addGap(18, 18, 18)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnInserir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPreco)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDescricao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPreco2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dpdFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProduto)
                                .addGap(2, 2, 2)
                                .addComponent(dpdProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(lblTitulo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(dpdCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome1)
                    .addComponent(dpdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto)
                    .addComponent(dpdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInserir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(lblPreco2)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(dpdFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void dpdProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpdProdutoActionPerformed

    }//GEN-LAST:event_dpdProdutoActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        FormProdutoView formProduto = new FormProdutoView(this);
        formProduto.setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Venda venda = new Venda();
        
        if(!isViewing) {
            venda.setCliente(new Cliente(dpdCliente.getSelectedItem().toString()));
            venda.setTotal(Double.parseDouble(txtTotal.getText()));
            venda.setCliente(new Cliente(dpdCliente.getSelectedItem().toString()));
            venda.setFormaPagamento(dpdFormaPagamento.getSelectedItem().toString());
            venda.setData(txtData.getText());

            try {
                vendaController.Salvar(venda, this.produtosVenda);

                if(this.vendaView != null) {
                    vendaView.ConsultarVendas();
                }
                
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(FormCategoriaView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
        }      
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void dpdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpdClienteActionPerformed

    private void btnProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduto1ActionPerformed
        FormClienteView formClienteView = new FormClienteView(this);
        
        formClienteView.setVisible(true);
    }//GEN-LAST:event_btnProduto1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.FormatarCampos();
        
        ConsultarClientes();
        ConsultarProdutos();
        VerificarVendaCarregada();
    }//GEN-LAST:event_formWindowOpened

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        DefaultTableModel model =(DefaultTableModel) tblItens.getModel();
        model.setNumRows(0);
        Double preco = 0.0;
        
        for (Produto produto : this.produtosCarregados) {
            if(produto.getNome().equals(dpdProduto.getSelectedItem())) {
                produtosVenda.add(new ProdutoVenda(produto, Integer.parseInt(txtQuantidade.getText()), produto.getPreco() * Integer.parseInt(txtQuantidade.getText())));
                preco = produto.getPreco();
                break;
            }
        }
        
        total+= preco * Integer.parseInt(txtQuantidade.getText());
        
        for (ProdutoVenda produtoVenda : this.produtosVenda) {
            model.addRow(new Object[] 
            { 
               //retorna os dados da tabela do BD, cada campo e um coluna.
               produtoVenda.getProduto().getNome(),
               produtoVenda.getQuantidade(),
               produtoVenda.getTotal()
            });
        }
        
        
        txtTotal.setText(total.toString());
    }//GEN-LAST:event_btnInserirActionPerformed

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
            java.util.logging.Logger.getLogger(FormVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVendaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnProduto1;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> dpdCliente;
    private javax.swing.JComboBox<String> dpdFormaPagamento;
    private javax.swing.JComboBox<String> dpdProduto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblPreco2;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblItens;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
