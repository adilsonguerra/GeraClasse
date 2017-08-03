package com.warsys.geraclasse.classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Sample application using Frame.
 *
 * @author 
 * @version 1.00 06/03/06
 */
public class LeXMLFrm extends JFrame {
    
  JTextField txtCaminhoXml = new JTextField(40);
  
 public LeXMLFrm() {
  
  ImageIcon iconXML = new ImageIcon("F:/sony/Guerra/prjs_java/GeraClasse/img/dir.gif");
  JButton btnLerXml = new JButton("OK");
  JButton btnOpenFile = new JButton(iconXML);
  JLabel lblCaminhoXml = new JLabel("Arquivo Xml:");
                

  JPanel pTxts = new JPanel();
  JPanel pBotoes = new JPanel();
  JPanel pLabels = new JPanel();
  JPanel pBotoes2 = new JPanel();

  Container c = getContentPane();
  
  c.setLayout(new BorderLayout());

  pTxts.setLayout(new GridLayout(1,1));
  pTxts.add(txtCaminhoXml);
 
  pBotoes2.add(btnOpenFile);
     

  pLabels.setLayout(new GridLayout(1,1));
  pLabels.add(lblCaminhoXml);

  pBotoes.add(btnLerXml);
  
  c.add(pBotoes2, BorderLayout.EAST);
  c.add(pLabels, BorderLayout.NORTH);
  c.add(pTxts, BorderLayout.WEST);
  c.add(pBotoes, BorderLayout.SOUTH);
  
//  btnLerXml.addActionListener(btnLerXmlClick);
  btnOpenFile.addActionListener(btnOpenFileClick);
  btnLerXml.addActionListener(btnLerXmlClick);

  
  setTitle("Pesquisar XML");
  //setSize(new Dimension(400, 400));
         
  this.pack();
  this.show();
  
  // Add window listener.
  this.addWindowListener
        (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    LeXMLFrm.this.windowClosed();
                }
            }
        );  
 }
    
    /**
     * Shutdown procedure when run as an application.
     */
    protected void windowClosed() {
        
       this.disable();

    }
    
  private ActionListener btnOpenFileClick = new ActionListener(){         
         public void actionPerformed(ActionEvent ae){
         
            try{
                FileDialog fileDialog=null;
                
                Frame frame = new Frame("Procura o XML...");
                
                center(frame);
                
                if (fileDialog == null) {
                  fileDialog = new FileDialog(frame, "Informe o arquivo XML");
                }
                fileDialog.setMode(FileDialog.LOAD);
                fileDialog.show();
         
                String dir = fileDialog.getDirectory();
                String file = fileDialog.getFile();
                if (dir!=null){
                  txtCaminhoXml.setText(dir + file);
                }

            }
            catch (Exception e) {
               System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
            }
         }
      };

  private ActionListener btnLerXmlClick = new ActionListener(){         
         public void actionPerformed(ActionEvent ae){
         
            try{

              //GeraClasse.txtCaminhoXml.setText(txtCaminhoXml.getText());
              GeraClasse.LerXml(txtCaminhoXml.getText());
               
            }
            catch (Exception e) {
               System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
            }
         }
      };
      
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