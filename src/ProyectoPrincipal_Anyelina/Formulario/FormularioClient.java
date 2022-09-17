/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProyectoPrincipal_Anyelina.Formulario;

import ProyectoPrincipal_Anyelina.DAO.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angie
 */
public class FormularioClient extends javax.swing.JFrame {
    
    Conexion con1 = new Conexion();
    Connection conet;
    DefaultTableModel modelo2;
    Statement st;
    ResultSet rs;
    int idc;

    /**
     * Creates new form FormularioClient
     */
    public FormularioClient() {
        initComponents();
        setLocationRelativeTo(null);
        consultar();
    }


    private void bttnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEliminarActionPerformed

        Eliminar();
        consultar();
        Nuevo();
    }//GEN-LAST:event_bttnEliminarActionPerformed

    private void bttnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarActionPerformed

        AgregarClientes();
        consultar();
        Nuevo();
    }//GEN-LAST:event_bttnAgregarActionPerformed

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientesMouseClicked
       
        int fila = tableClientes.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
        }else{
            idc = Integer.parseInt((String) tableClientes.getValueAt(fila,0) .toString());
            String user = (String) tableClientes.getValueAt(fila,1);
            int cont = Integer.parseInt((String) tableClientes.getValueAt(fila,2) .toString());
            String direc = (String) tableClientes.getValueAt(fila,3) .toString();
        
            txtID.setText(""+idc);
            txtUsuario.setText(user);
            txtContacto.setText(""+cont);
            txtDireccion.setText(direc);
        }
    }//GEN-LAST:event_tableClientesMouseClicked

    private void bttnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModificarActionPerformed
        Modificar();
        consultar();
        Nuevo();
    }//GEN-LAST:event_bttnModificarActionPerformed

    private void bttnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnNuevoActionPerformed
        Nuevo();
    }//GEN-LAST:event_bttnNuevoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(FormularioClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioClient().setVisible(true);
            }
        });
    }
    
    void consultar(){
        String sql = "select * from Cliente";
        
        try{
            conet = con1.Conectar();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object [] Cliente = new Object[4];
            modelo2 = (DefaultTableModel) tableClientes.getModel();
            while (rs.next()){
                Cliente[0]= rs.getInt("id_Cliente");
                Cliente[1]= rs.getString("Usuario");
                Cliente[2]= rs.getInt("Contacto");
                Cliente[3]= rs.getString("Direccion");
                
                modelo2.addRow(Cliente);
            }
            tableClientes.setModel(modelo2);
        } catch(Exception e){
        }
    }
    
    void AgregarClientes(){
        String user = txtUsuario.getText();
        String cont = txtContacto.getText();
        String direc = txtDireccion.getText();
        
        try{
            if (user.equals("") || cont.equals("") || direc.equals("")){
                
                JOptionPane.showMessageDialog(null, "Falta ingresar datos");
                limpiarTabla();
            } else {
                String sql = "insert into Cliente (Usuario, Contacto, Direccion) values ('"+user+"','"+cont+"','"+direc+"')";
            conet = con1.Conectar();
            st =conet.createStatement();
            st.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Nuevo cliente agregado.");
            limpiarTabla();
            } 
        } catch(Exception e){
        }
    }
    
    void limpiarTabla(){
        for(int i = 0; i<= tableClientes.getRowCount(); i++){
            modelo2.removeRow(i);
            i = i-1;
        }
    }
    
    void Modificar(){
        String user = txtUsuario.getText();
        String cont = txtContacto.getText();
        String direc = txtDireccion.getText();
        
        try{
            if (user.equals("") || cont.equals("") || direc.equals("")){
                
                JOptionPane.showMessageDialog(null, "Falta ingresar datos");
                limpiarTabla();
            } else {
            String sql = "Update Cliente set id_Cliente='"+idc+"',Usuario='" +user+ "', Contacto='" +cont+ "', Direccion='" +direc+ "' where id_Cliente=" +idc;
            conet = con1.Conectar();
            st =conet.createStatement();
            st.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Cliente modificado.");
            limpiarTabla();
            } 
        } catch(Exception e){
        }
    }
    
    void Eliminar(){
        int fila =tableClientes.getSelectedRow();
        try{
            if(fila<0){
                JOptionPane.showMessageDialog(null, "Cliente no seleccionado.");
                limpiarTabla();
            }else{
                String sql = "delete from Cliente where id_Cliente="+idc;
                conet = con1.Conectar();
            st = conet.createStatement();
            st.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Cliente eliminado.");
            limpiarTabla();
            }
        } catch(Exception e){
            
        }
    }
    
    void Nuevo(){

        txtID.setText("");
        txtUsuario.setText("");
        txtContacto.setText("");
        txtDireccion.setText("");
        txtID.requestFocus();
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnEliminar;
    private javax.swing.JButton bttnModificar;
    private javax.swing.JButton bttnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
