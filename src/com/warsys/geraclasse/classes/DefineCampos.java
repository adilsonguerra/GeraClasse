
package com.warsys.geraclasse.classes;

//import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DefineCampos extends JFrame {

	public boolean botao_ok=false;

	JButton b1 = new JButton("OK");
	JTextField txtAlias = new JTextField(40);

	JLabel lblNomeBean = new JLabel("Bean: ");
	
	public DefineCampos(){
	}

   public DefineCampos(String s){
		super(s);
		this.setSize(200,200);
		Container c = getContentPane();
		Panel pTxts = new Panel();
		Panel pLabels = new Panel();
		Panel pBotoes = new Panel();

		c.setLayout(new BorderLayout());		

		pLabels.setLayout(new GridLayout(1,1));
		pLabels.add(lblNomeBean);

		pTxts.setLayout(new GridLayout(1,1));
		pTxts.add(txtAlias);
		
		pBotoes.add(b1);
		
      c.add(pTxts, BorderLayout.CENTER);
		c.add(pLabels, BorderLayout.WEST);
		c.add(pBotoes, BorderLayout.SOUTH);
		
		b1.addActionListener(b1Click);

		this.pack();
		this.show();
   
	   }
      /******  LISTENERS  *********/
	 
		private ActionListener b1Click = new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				
				//reg[1].setNomeColuna(txtAlias.getText());
				//CarregaCampos(reg);
            botao_ok=true;

				System.out.println("Funcionou!!");
		   }
		};

     /****** FIM DOS LISTENERS  *********/
		
		public void setAlias(String alias){
			txtAlias.setText(alias);
		}
		
		public String getAlias(){
			return txtAlias.getText();
		}


}//class
	