
package ProyectoPrincipal_Anyelina.Formulario;

import ProyectoPrincipal_Anyelina.DAO.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioArt extends javax.swing.JFrame {

    Conexion con1 = new Conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    
    public FormularioArt() {
        initComponents();
        setLocationRelativeTo(null);
        consultar();
    }

    private void bttnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarActionPerformed

        AgregarArticulos();
        consultar();
    }//GEN-LAST:event_bttnAgregarActionPerformed

    private void tableArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableArticulosMouseClicked

        int fila = tableArticulos.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
        }else{
            idc = Integer.parseInt((String) tableArticulos.getValueAt(fila,0) .toString());
            String art = (String) tableArticulos.getValueAt(fila,1);
            double precio = Double.parseDouble((String) tableArticulos.getValueAt(fila,2) .toString());
            int cantidad = Integer.parseInt((String) tableArticulos.getValueAt(fila,3) .toString());
        
            id_Articulo.setText(""+idc);
            txtArticulo.setText(art);
            txtPrecio.setText(""+precio);
            txtCantidad.setText(""+cantidad);
        
        }
    }//GEN-LAST:event_tableArticulosMouseClicked

    private void bttnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModificarActionPerformed

        Modificar();
        consultar();
        Nuevo();
    }//GEN-LAST:event_bttnModificarActionPerformed

    private void bttnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEliminarActionPerformed

        Eliminar();
        consultar();
        Nuevo();
    }//GEN-LAST:event_bttnEliminarActionPerformed

    private void bttnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnNuevoActionPerformed
        Nuevo();
    }//GEN-LAST:event_bttnNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioArt().setVisible(true);
            }
        });
    }
    
    
    
    void consultar(){
        String sql = "select * from Articulos";
        
        try{
            conet = con1.Conectar();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object [] Articulos = new Object[4];
            modelo = (DefaultTableModel) tableArticulos.getModel();
            while (rs.next()){
                Articulos[0]= rs.getInt("id_Articulo");
                Articulos[1]= rs.getString("Articulo");
                Articulos[2]= rs.getDouble("precio");
                Articulos[3]= rs.getInt("Cant_en_Stock");
                
                modelo.addRow(Articulos);
            }
            tableArticulos.setModel(modelo);
        } catch(Exception e){
        }
    }
    
    void AgregarArticulos(){
        String art = txtArticulo.getText();
        String precio = txtPrecio.getText();
        String cant = txtCantidad.getText();
        
        try{
            if (art.equals("") || precio.equals("") || cant.equals("")){
                
                JOptionPane.showMessageDialog(null, "Falta ingresar datos");
                limpiarTabla();
            } else {
                String sql = "insert into Articulos (Articulo, Precio, Cant_en_Stock) values ('"+art+"','"+precio+"','"+cant+"')";
            conet = con1.Conectar();
            st =conet.createStatement();
            st.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Nuevo articulo agregado.");
            limpiarTabla();
            } 
        } catch(Exception e){
        }
    }
    
    void limpiarTabla(){
        for(int i = 0; i<= tableArticulos.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    void Modificar(){
        String art = txtArticulo.getText();
        String precio = txtPrecio.getText();
        String cant = txtCantidad.getText();
        
        try{
            if (art.equals("") || precio.equals("") || cant.equals("")){
                
                JOptionPane.showMessageDialog(null, "Falta ingresar datos");
                limpiarTabla();
            } else {
            String sql = "Update Articulos set id_Articulo='"+idc+"',Articulo='" +art+ "', Precio='" +precio+ "', Cant_en_Stock='" +cant+ "' where id_Articulo=" +idc;
            conet = con1.Conectar();
            st =conet.createStatement();
            st.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Articulo modificado.");
            limpiarTabla();
            } 
        } catch(Exception e){
        }
    }
    
    void Eliminar(){
        int fila =tableArticulos.getSelectedRow();
        try{
            if(fila<0){
                JOptionPane.showMessageDialog(null, "Articulo no seleccionado.");
                limpiarTabla();
            }else{
                String sql = "delete from Articulos where id_Articulo="+idc;
                conet = con1.Conectar();
            st = conet.createStatement();
            st.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Articulo eliminado.");
            limpiarTabla();
            }
        } catch(Exception e){
            
        }
    }
    
    void Nuevo(){
        id_Articulo.setText("");
        txtArticulo.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        id_Articulo.requestFocus();
                
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnEliminar;
    private javax.swing.JButton bttnModificar;
    private javax.swing.JButton bttnNuevo;
    private javax.swing.JTextField id_Articulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableArticulos;
    private javax.swing.JTextField txtArticulo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

}
