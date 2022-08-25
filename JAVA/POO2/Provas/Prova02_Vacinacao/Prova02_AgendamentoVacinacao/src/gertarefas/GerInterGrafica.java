package gertarefas;

import dominio.Paciente;
import dominio.Vacina;
import intergraf.FrmCadastroVacinacao;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author jean_
 */
public class GerInterGrafica {

    private FrmCadastroVacinacao frmPrinc = null;
    private GerenciadorDominio gerDom;
    
    public GerInterGrafica() throws ClassNotFoundException, SQLException  {

            gerDom = new GerenciadorDominio();

    }

    public GerenciadorDominio getGerDominio() {
        return gerDom;
    }
    
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe){
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerInterGrafica.class ).newInstance(parent,true,this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(frmPrinc, "Erro ao abrir a janela " + classe.getName() );
            }
        }        
        dlg.setVisible(true);  
        return dlg;
    }
    
    public void abrirJanPrincipal(){
        if ( frmPrinc == null) {
            frmPrinc = new FrmCadastroVacinacao(this);
        }
        frmPrinc.setVisible(true);
        
    }
       
    
       /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroVacinacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroVacinacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroVacinacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroVacinacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        GerInterGrafica gerIG = new GerInterGrafica();
        gerIG.abrirJanPrincipal();
    }
    
    // VACINACAO 
    public void pesquisarPorVacina(int tipo, JComboBox comboVacinas)
    {
        List<Vacina> vacinas;
        try {
            vacinas = gerDom.pesquisarPorVacina(tipo);
            comboVacinas.setModel(new DefaultComboBoxModel(vacinas.toArray()));
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(frmPrinc, e);
        } 
    }
    
    // PACIENTE
    
    public Paciente pesquisarPacientePorID(Long id) throws ClassNotFoundException, SQLException
     {
         return gerDom.pesquisarPacientePorID(id);
     }
    
    public List<Paciente> listarPacientes() throws ClassNotFoundException, SQLException {
         return gerDom.listarPacientes();
     }
    public List<Paciente> pesquisarPorVacina(Vacina vacina) throws ClassNotFoundException, SQLException{
         return gerDom.pesquisarPorVacina(vacina);
     }
    public List<Paciente> pesquisarSegundaDose()  throws ClassNotFoundException, SQLException{
         return gerDom.pesquisarSegundaDose();
     }
}
