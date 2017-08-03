package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.bean.Registros;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Sample application using Frame.
 *
 * @author 
 * @version 1.00 21/07/07
 */
public class EditColunaFrm extends JFrame {
		
    
  //TextFields
  JTextField txtColuna = new JTextField(40);
  JTextField txtAliasColuna = new JTextField(40);
  JTextField txtTipo = new JTextField(40);
  JTextField txtTamanho = new JTextField(40);
  JTextField txtPrecisao = new JTextField(40);
  JTextField txtObrigatorio = new JTextField(40);
  JTextField txtChave = new JTextField(40);
  JTextField txtIni = new JTextField(40);
  JTextField txtRepositorio = new JTextField(40);
  JTextField txtTabRepos = new JTextField(40);
  JTextField txtChaveRepos = new JTextField(40); 
  
  //Labels
  JLabel lblColuna = new JLabel("Coluna");
  JLabel lblAliasColuna = new JLabel("Alias");
  JLabel lblTipo = new JLabel("Tipo");
  JLabel lblTamanho = new JLabel("Tamanho");
  JLabel lblPrecisao = new JLabel("Precisão");
  JLabel lblObrigatorio = new JLabel("Obrigatório");
  JLabel lblChave = new JLabel("Chave");
  JLabel lblIni = new JLabel("Inicialização");
  JLabel lblRepositorio = new JLabel("Repositório");
  JLabel lblTabRepos = new JLabel("Tab. Repositório:");
  JLabel lblChaveRepos = new JLabel("Chave Repositório");
  
  //Panels
  JPanel pTxts = new JPanel();
  JPanel pBotoes = new JPanel();
  JPanel pLabels = new JPanel();
 
 public EditColunaFrm() {
 	
  setTitle("Editar Colunas");
  //setSize(new Dimension(400, 400));

  Container c = getContentPane();
  
  c.setLayout(new BorderLayout());

  pTxts.setLayout(new GridLayout(11,1));
  pTxts.add(txtColuna);
  pTxts.add(txtAliasColuna);
  pTxts.add(txtTipo);
  pTxts.add(txtTamanho);
  pTxts.add(txtPrecisao);
  pTxts.add(txtObrigatorio);
  pTxts.add(txtChave);
  pTxts.add(txtIni);
  pTxts.add(txtRepositorio);
  pTxts.add(txtTabRepos);
  pTxts.add(txtChaveRepos);   

  pLabels.setLayout(new GridLayout(11,1));
  pLabels.add(lblColuna);
  pLabels.add(lblAliasColuna);
  pLabels.add(lblTipo);
  pLabels.add(lblTamanho);
  pLabels.add(lblPrecisao);
  pLabels.add(lblObrigatorio);
  pLabels.add(lblChave);
  pLabels.add(lblIni);
  pLabels.add(lblRepositorio);
  pLabels.add(lblTabRepos);
  pLabels.add(lblChaveRepos);
  
  c.add(pLabels, BorderLayout.WEST);
  c.add(pTxts, BorderLayout.EAST);
  c.add(pBotoes, BorderLayout.SOUTH);
  
//  btnLerXml.addActionListener(btnLerXmlClick);

         
  this.pack();
  this.show();
  
  // Add window listener.
  this.addWindowListener
        (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    EditColunaFrm.this.windowClosed();
                }
            }
        );  
 }
    
    protected void windowClosed() {
       this.disable();
    }
    

//  private ActionListener btnLerXmlClick = new ActionListener(){         
//         public void actionPerformed(ActionEvent ae){
//         
//            try{
//
//              //GeraClasse.txtCaminhoXml.setText(txtCaminhoXml.getText());
//              GeraClasse.LerXml(txtCaminhoXml.getText());
//               
//            }
//            catch (Exception e) {
//               System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
//            }
//         }
//      };
      
   
   public Registros getRegistro(){
   		
   	Registros r = new Registros (txtColuna.getText(),
   	                             txtTipo.getText(),
   	                             txtTamanho.getText(),
   	                             txtPrecisao.getText(), 
   	                             txtObrigatorio.getText(), 
   	                             txtChave.getText(),
   	                             txtIni.getText(),
   	                             txtAliasColuna.getText(),
   	                             txtRepositorio.getText(), 
   	                             txtTabRepos.getText(), 
   	                             txtChaveRepos.getText());	
   	return r;
   }

   public void setRegistro(Registros r){
   	
		 txtColuna.setText(r.getColuna()); 
		 txtTipo.setText(r.getTipo()); 
		 txtTamanho.setText(r.getTamanho()); 
		 txtPrecisao.setText(r.getPrecisao()); 
		 txtObrigatorio.setText(r.getObrigatorio()); 
		 txtChave.setText(r.getChave()); 
		 txtIni.setText(r.getIni()); 
		 txtAliasColuna.setText(r.getNomeColuna()); 
		 txtRepositorio.setText(r.getRepositorio()); 
		 txtTabRepos.setText(r.getTabRepos());
		 txtChaveRepos.setText(r.getChaveRepos());	

   }
   
   public static void center(Component componente) 
   { 
      // Centraliza a janela de abertura no centro do desktop. 
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); 
        Rectangle r      = componente.getBounds(); 
      // Dimensões da janela 
        int widthSplash = r.width ; 
        int heightSplash = r.height; 

      // calculo para encontrar as cooredenadas X e Y para a centralização da janela. 
        int posX = (screen.width / 2) - ( widthSplash / 2 ); 
        int posY = (screen.height / 2) - ( heightSplash / 2 ); 

        componente.setBounds(posX,posY,widthSplash,heightSplash); 
   } 
}