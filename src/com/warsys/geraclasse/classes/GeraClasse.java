package com.warsys.geraclasse.classes;

import com.warsys.geraclasse.db.*;
import com.warsys.geraclasse.bean.Registros;
import java.util.Vector;
import java.util.Hashtable;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class GeraClasse extends JFrame {
	
	//---------------------------
	//Definição de variáveis
	//---------------------------

	static String nomeEmpresaSistema; //Ex.comgas.dataentry
	static String nomeBean;
	static String nomeDB;
	static String nomeDAO;
	static String nomeServletAtualizacao;
	static String nomeServletConsulta;   
	static String nomeServletExclusao;  
	static String nomeServletInclusao; 
	static String nomeConsultaHtml; 
	static String nomeMenuPrincJsp;
	static String nomeMenu_princJsp;
	static String nomeGrid_Detalhe;
	static String nomeGrid_Campos;
	static String nomeTabela;
	
	static String nomeBanco;
	
	static String nomeArquivoBean;
	static String nomeArquivoDAO;
	static String nomeArquivoDB;
	static String nomeArquivoServletAtualizacao;
	static String nomeArquivoServletConsulta;
	static String nomeArquivoServletExclusao;
	static String nomeArquivoServletInclusao;
	static String nomeArquivoConsultaHtml;
	static String nomeArquivoMenuPrincJsp;
	static String nomeArquivoMenu_princJsp;
	static String nomeArquivoGrid_Detalhe;
	static String nomeArquivoGrid_Campos;
	static String nomeArquivoBuildFile;
	static String nomeArquivoWebXmlFile;
	
	static String arquivoXML;

	private Registros[] reg;
	private Registros[] regSelecionados;
	private Registros[] regConvertido;
	//Registros campos[];
	
   //Icones
    ImageIcon iconXML = new ImageIcon("C:prj/GeraClasse/img/dir.gif");
    ImageIcon iconAnalytica = new ImageIcon("C:prj/GeraClasse/img//analytica_pq.gif");
	   
	static List lsTabelas = new List(15,false);
	List lsColunas = new List(15,true);
	JButton btnGeraClasse = new JButton("Gerar Classe");
	JButton btnRenomear = new JButton("Renomear");
	JButton btnOk = new JButton("Ok");
	//JButton btnLerXml = new JButton("Ler XML");
  
	JTextField txtEmpresaSistema = new JTextField(40);
	JTextField txtAliasCampo = new JTextField(40);
	JTextField txtNomeClasse = new JTextField(40);
	JTextField txtNomeDB = new JTextField(40);
	JTextField txtNomeDAO = new JTextField(40);
	JTextField txtNomeServletInclusao = new JTextField(40);
	JTextField txtNomeServletExclusao = new JTextField(40);
	JTextField txtNomeServletAtualizacao = new JTextField(40);
	JTextField txtNomeServletConsulta = new JTextField(40);
	JTextField txtnomeConsultaHtml = new JTextField(40);
	JTextField txtnomeMenuPrincJsp = new JTextField(40);
	JTextField txtnomeMenu_princJsp = new JTextField(40);
	JTextField txtNomeGrid_Detalhe = new JTextField(40);
	JTextField txtNomeGrid_Campos = new JTextField(40);

	JLabel lblEmpresaSistema = new JLabel("(Ex. warsys.sistema):");
	JLabel lblAlias = new JLabel("  Alias do campo: ");

	JLabel lblNomeBean = new JLabel("  Bean: ");
	JLabel lblNomeDB = new JLabel("  DB: ");
	JLabel lblNomeDAO = new JLabel("  DAO: ");
	JLabel lblNomeServletInclusao = new JLabel("  Inclusão: ");
	JLabel lblNomeServletExclusao = new JLabel("  Exclusão: ");
	JLabel lblNomeServletAtualizacao = new JLabel("  Atualização: ");
	JLabel lblNomeServletConsulta = new JLabel("  Consulta Servlet: ");
	JLabel lblnomeConsultaHtml = new JLabel("  Consulta jsp: ");
	JLabel lblnomeMenuPrincJsp = new JLabel("  MenuPrinc jsp: ");
	JLabel lblnomeMenu_princJsp = new JLabel("  Menu_princ jsp: ");
	JLabel lblNomeGrid_Detalhe = new JLabel("  Grid Detalhe jsp: ");
	JLabel lblNomeGrid_Campos = new JLabel("  Grid Campos jsp: ");
    //JLabel lblCaminhoXml = new JLabel("Arquivo do Xml:");

	JCheckBox chkSelecionarTodos = new JCheckBox("Selecionar Todos",false);
	
			
	//---------------------------
	//Definição de métodos
	//---------------------------

	public static void main(String[] args) 
	{
		GeraClasse gc = new GeraClasse("Gera classe");
		center(gc);
		
		GeraClassePgsqlDB gcdb = new GeraClassePgsqlDB();
		
		nomeBanco = gcdb.getBanco();
	      
      try{

		   gc.CarregaList(gcdb.getTabelas(""));
		   
		}
		catch (SQLException e) {
			System.out.println("Throwing SQLException " + e.getMessage());
      }
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
   

   public GeraClasse(String s){
		super(s);
		this.setSize(200,200);
		Container c = getContentPane();
		JPanel pLists = new JPanel();
		JPanel pTxts = new JPanel();
		JPanel pLabels = new JPanel();
		JPanel pBotoes = new JPanel();
		//JPanel pArqXml = new JPanel();
		
      try{
         //UIManager.setLookAndFeel("javax.swing.plaf.metal.metallookandfeel");
         //UIManager.setLookAndFeel("javax.swing.plaf.windows.WindowsLookAndFeel");
         //UIManager.setLookAndFeel("javax.swing.plaf.motif.MotifLookAndFeel");
         //UIManager.setLookAndFeel("javax.swing.plaf.basic.BasicLookAndFeel");
      }catch(Exception e) {
         System.out.println("Erro: "+e.getMessage());
      }
   
//      SwingUtilities.updateComponentTreeUI(this); 

		//Monta a barra de menus
      MenuBar menuBar = new MenuBar();
      this.setMenuBar(menuBar);
      
      //Adiciona os menus
      Menu mnArquivos = (Menu) menuBar.add(new Menu("Arquivos"));
      MenuItem sbMnPesquisaXML = (MenuItem) mnArquivos.add(new MenuItem("Pesquisar XML"));
      MenuItem sbMnTeste1 = (MenuItem) mnArquivos.add(new MenuItem("teste1"));
      MenuItem sbMnTeste2 = (MenuItem) mnArquivos.add(new MenuItem("teste2")); 
      
      Menu mnFerramentas = (Menu) menuBar.add(new Menu("Ferramentas"));
      MenuItem sbMnContrXML = (MenuItem) mnFerramentas.add(new MenuItem("Construtor XML"));
      MenuItem sbMnGerArqAnalytica = (MenuItem) mnFerramentas.add(new MenuItem("Gerar Arquivos do Analytica"));
         
      setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lsColunas.setFont(new Font("Courrier New",0,12));

		c.setLayout(new BorderLayout());
      
		pLists.setLayout(new GridLayout(1,2,5,5));
		pLists.add(lsTabelas);
		pLists.add(lsColunas);
		
		pLabels.setLayout(new GridLayout(14,1));
		pLabels.add(lblEmpresaSistema);
		pLabels.add(lblAlias);
		pLabels.add(lblNomeBean);
		pLabels.add(lblNomeDB);
		pLabels.add(lblNomeDAO);
		pLabels.add(lblNomeServletInclusao);
		pLabels.add(lblNomeServletExclusao);
		pLabels.add(lblNomeServletAtualizacao);
		pLabels.add(lblNomeServletConsulta);
		pLabels.add(lblnomeConsultaHtml);
		pLabels.add(lblnomeMenuPrincJsp);
		pLabels.add(lblnomeMenu_princJsp);
		pLabels.add(lblNomeGrid_Detalhe);
		pLabels.add(lblNomeGrid_Campos);

		pTxts.setLayout(new GridLayout(14,1));
		pTxts.add(txtEmpresaSistema);
		pTxts.add(txtAliasCampo);
		pTxts.add(txtNomeClasse);
		pTxts.add(txtNomeDB);
		pTxts.add(txtNomeDAO);	
		pTxts.add(txtNomeServletInclusao);
		pTxts.add(txtNomeServletExclusao);
		pTxts.add(txtNomeServletAtualizacao);
		pTxts.add(txtNomeServletConsulta);
		pTxts.add(txtnomeConsultaHtml);
		pTxts.add(txtnomeMenuPrincJsp);
		pTxts.add(txtnomeMenu_princJsp);
		pTxts.add(txtNomeGrid_Detalhe);
		pTxts.add(txtNomeGrid_Campos);
	//	pTxts.add(txtCaminhoXml);
		
		//pArqXml.add(txtCaminhoXml);
		//pArqXml.add(btnOpenFile);
		//pTxts.add(pArqXml);
		
		pBotoes.add(chkSelecionarTodos);
		pBotoes.add(btnRenomear);
		pBotoes.add(btnGeraClasse);
		//pBotoes.add(btnLerXml);
		pBotoes.add(btnOk);		

		btnOk.setVisible(false);

		c.add(pLists, BorderLayout.NORTH);
        c.add(pTxts, BorderLayout.CENTER);
		c.add(pLabels, BorderLayout.WEST);
		c.add(pBotoes, BorderLayout.SOUTH);

        txtAliasCampo.setVisible(false);
		lblAlias.setVisible(false);
		btnGeraClasse.setEnabled(false);
		btnRenomear.setEnabled(false);

		lsTabelas.addActionListener(lsTabelasDoubleClick);
		lsColunas.addActionListener(lsColunasDoubleClick);

		btnGeraClasse.addActionListener(btnGeraClasseClick);		
		btnRenomear.addActionListener(btnRenomearClick);
		btnOk.addActionListener(btnOkClick);

		chkSelecionarTodos.addActionListener(chkSelTodosClick);
		
        sbMnPesquisaXML.addActionListener(sbMnPesquisaXMLClick); 
        sbMnGerArqAnalytica.addActionListener(btnAnalyticaClick); 
                   
		this.pack();
		this.show();
		
   } 

	public void CarregaList (String tb[]) {
	
		lsTabelas.removeAll();
		try{
			for (int i=0;tb!=null && i<tb.length;i++){
				lsTabelas.add(tb[i]);
				//System.out.println("==>"+tb[i]);
			}
		}catch(Exception e) {
			System.out.println(e);
			}
	}

	public void CarregaCampos (Registros cp[]) {
		
		lsColunas.removeAll();
		try{
			
			lsColunas.setFont(new Font("COURIER",1,11));
			
			lsColunas.add("Ord Coluna           Label     Tipo      Tm  Pr Obr Ch  "); 
				
			for (int i=0;cp!=null && i<cp.length;i++){
				
				//cp[i].getColuna()
				cp[i].setNomeColuna(cp[i].getColuna());
				
				 //ls2.add(i + "-" + (""+cp[i].getNomeColuna()!=""?cp[i].getColuna():cp[i].getNomeColuna()) + "  " + cp[i].getTipo() + "  " + cp[i].getTamanho() + "  " + cp[i].getPrecisao() + "  " + cp[i].getObrigatorio()+ "  " + cp[i].getChave());

				// if(cp[i].getNomeColuna()==null){
				//		lsColunas.add(i + "-" + ""+cp[i].getColuna() + "  " + cp[i].getTipo() + "  " + cp[i].getTamanho() + "  " + cp[i].getPrecisao() + "  " + cp[i].getObrigatorio()+ "  " + cp[i].getChave());	
				// }else{
				//		lsColunas.add(i + "-" + ""+cp[i].getNomeColuna() + "  " + cp[i].getTipo() + "  " + cp[i].getTamanho() + "  " + cp[i].getPrecisao() + "  " + cp[i].getObrigatorio()+ "  " + cp[i].getChave());					 
				// }				 

	//(String coluna, String tipo, String tamanho, String precisao, String obrigatorio, String chave, String ini) {
      
				
				lsColunas.add(concStr(Integer.toString(i+1)," ",2)  + "  " +
				strConc(cp[i].getColuna()," ",17) +
				strConc(cp[i].getNomeColuna()," ",10) +
				strConc(cp[i].getTipo()," ",10) +  
				strConc(cp[i].getTamanho()," ",4) + 
				strConc(cp[i].getPrecisao()," ",3) +  
				strConc(cp[i].getObrigatorio()," ",4) +  
				strConc(cp[i].getChave()," ",3));
				

			}
		}catch(Exception e) {
			System.out.println(e);
			}
		reg = cp;
	}

      /******  LISTENERS  *********/
      
      
      //Menu Ferramentas
      private ActionListener sbMnPesquisaXMLClick = new ActionListener(){         
         public void actionPerformed(ActionEvent ae){
            try{

                 // Create application frame.
                 LeXMLFrm frmXML = new LeXMLFrm();
                 center(frmXML);
                 // Show frame
                 frmXML.setVisible(true);      
            }
            catch (Exception e) {
               System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
            }
         }
      };
      
            
      
      //Botão GeraClasse
		private ActionListener btnGeraClasseClick = new ActionListener(){ 	
			public void actionPerformed(ActionEvent ae){
			   
            System.out.println("----------------------------------------------------");
            System.out.println("Estou no ActionListener btnGeraClasseClick...");
            System.out.println("");
				
			if(!txtEmpresaSistema.getText().equals("")){
				//Verifica se extrairá os dados de um arquivo XML
				//if(txtCaminhoXml.getText().equals("")){	          
	            //if(!arquivoXML){ 
	            //if(arquivoXML.equals("")){
	            if(arquivoXML==null){
	            	criar_xml();				
				}
				  
	        	extrair_xml();
					 		 
				JOptionPane.showMessageDialog(null, "Arquivos gerados com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		   
		    }else{
		   
		   		JOptionPane.showMessageDialog(null, "O campo empresa não está preenchido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }//if
            }//void
		
		};
		
		private void extrair_xml(){
          
          System.out.println("Estou no extrair_xml->" + lsTabelas.getItemCount());
          
          for(int i=0;i<lsTabelas.getItemCount();i++){
            
        	  if (lsTabelas.isIndexSelected(i)){  
                         	
            	Vector vCol = new Vector();
                String caminho ="";
                Arquivo pasta = new Arquivo("");
                
                //if(txtCaminhoXml.getText().equals("")){
                //if(!arquivoXML){ 
                //if(arquivoXML.equals("")){
                if(arquivoXML==null){	
                  //caminho ="../Arquivos/"+nomeTabela+".xml";
                	caminho = pasta.nomePasta + "/" + nomeTabela + ".xml";
                }else{
                  caminho = arquivoXML;//txtCaminhoXml.getText();
                }
                
                
                XmlReader xml= new XmlReader(caminho);
                try{          
                  vCol = xml.lerRegistros(lsTabelas.getItem(i));
                } catch (Exception e) {
                  System.out.println("Erro ao ler registros " + e.getMessage());
                }
                System.out.println("Leu "+vCol.size());
                //Cria array de registros com tamanho do vetor
                regConvertido = new Registros[vCol.size()];

                //Copia o conteúdo do vetor para o Array
                vCol.copyInto(regConvertido);
                  
                System.out.println("regConvertido=" +regConvertido.length );
                
                // Aqui carregamos as variáveis com os dados do XML
                  
                Hashtable h = new Hashtable();
                try{
                   h = xml.lerVariaveis(lsTabelas.getItem(i));
                }
                catch (Exception e) {
                   System.out.println("Erro ao ler as variaveis " + e.getMessage());      
                } 
                
             
                nomeEmpresaSistema=txtEmpresaSistema.getText();
                nomeTabela=lsTabelas.getItem(i);
                nomeBean = (String)h.get("nomeBean");
                nomeDAO = (String)h.get("nomeDAO");
                nomeDB = (String)h.get("nomeDB");
                nomeServletAtualizacao = (String)h.get("nomeServletAtualizacao");
                nomeServletConsulta = (String)h.get("nomeServletConsulta");
                nomeServletExclusao = (String)h.get("nomeServletExclusao");
                nomeServletInclusao = (String)h.get("nomeServletInclusao");
                nomeConsultaHtml = (String)h.get("nomeConsultaHtml");
                nomeMenuPrincJsp = (String)h.get("nomeMenuPrincJsp");
                nomeGrid_Detalhe = (String)h.get("nomeGrid_Detalhe");
                nomeGrid_Campos = (String)h.get("nomeGrid_Campos");
                nomeArquivoBean = (String)h.get("nomeArquivoBean");
                nomeArquivoDAO = (String)h.get("nomeArquivoDAO");
                nomeArquivoDB = (String)h.get("nomeArquivoDB");
                nomeArquivoServletAtualizacao = (String)h.get("nomeArquivoServletAtualizacao");
                nomeArquivoServletConsulta = (String)h.get("nomeArquivoServletConsulta");
                nomeArquivoServletExclusao = (String)h.get("nomeArquivoServletExclusao");
                nomeArquivoServletInclusao = (String)h.get("nomeArquivoServletInclusao");
                nomeArquivoConsultaHtml = (String)h.get("nomeArquivoConsultaHtml"); 
                nomeArquivoMenuPrincJsp = (String)h.get("nomeArquivoMenuPrincJsp"); 
                nomeArquivoMenu_princJsp =  (String)h.get("nomeArquivoMenu_princJsp"); 
                nomeArquivoGrid_Detalhe = (String)h.get("nomeArquivoGrid_Detalhe");
                nomeArquivoGrid_Campos = (String)h.get("nomeArquivoGrid_Campos");
                nomeArquivoBuildFile = (String)h.get("nomeArquivoBuildFile");
                nomeArquivoWebXmlFile = (String)h.get("nomeArquivoWebXmlFile");
                
                System.out.println("---------------------------------------------");
                System.out.println("Variáveis públicas carregadas do arq XML.");
                System.out.println("---------------------------------------------");
                System.out.println("nomeTab="+nomeTabela);
                System.out.println("nomeBean="+nomeBean);
                System.out.println("nomeDAO="+nomeDAO);
                System.out.println("nomeDB="+nomeDB);
                System.out.println("nomeServletAtualizacao="+nomeServletAtualizacao);
                System.out.println("nomeServletConsulta="+nomeServletConsulta);
                System.out.println("nomeServletExclusao="+nomeServletExclusao);
                System.out.println("nomeServletInclusao="+nomeServletInclusao);
                System.out.println("nomeConsultaHtml="+nomeConsultaHtml);
                System.out.println("nomeMenuPrincJsp="+nomeMenuPrincJsp);               
                System.out.println("nomeGrid_Detalhe="+nomeGrid_Detalhe);
                System.out.println("nomeGrid_Campos="+nomeGrid_Campos);
                System.out.println("nomeArquivoBean="+nomeArquivoBean);
                System.out.println("nomeArquivoDAO="+nomeArquivoDAO);
                System.out.println("nomeArquivoDB="+nomeArquivoDB);
                System.out.println("nomeArquivoServletAtualizacao="+nomeArquivoServletAtualizacao);
                System.out.println("nomeArquivoServletConsulta="+nomeArquivoServletConsulta);
                System.out.println("nomeArquivoServletExclusao="+nomeArquivoServletExclusao);
                System.out.println("nomeArquivoServletInclusao="+nomeArquivoServletInclusao);
                System.out.println("nomeArquivoConsultaHtml="+nomeArquivoConsultaHtml);
                System.out.println("nomeArquivoMenuPrincJsp="+ nomeArquivoMenuPrincJsp );  
                System.out.println("nomeArquivoMenu_princJsp="+ nomeArquivoMenu_princJsp );
                System.out.println("nomeArquivoGrid_Detalhe="+nomeArquivoGrid_Detalhe);
                System.out.println("nomeArquivoGrid_Campos="+nomeArquivoGrid_Campos);
                System.out.println("nomeArquivoBuildFile="+nomeArquivoBuildFile);
                System.out.println("nomeArquivoWebXmlFile="+nomeArquivoWebXmlFile);
                
                GeraArqBean geraArqBean = new GeraArqBean(nomeArquivoBean,nomeEmpresaSistema,regConvertido);
                GeraArqDAO geraArqDAO = new GeraArqDAO(nomeArquivoDAO,nomeEmpresaSistema,regConvertido);
                GeraArqDB geraArqDB = new GeraArqDB(nomeArquivoDB,nomeEmpresaSistema,nomeTabela,regConvertido);
                GeraArqServletCons geraArqServletCons = new GeraArqServletCons(nomeArquivoServletConsulta,nomeEmpresaSistema,regConvertido);                 
                GeraArqServletAtual geraArqServletAtual = new GeraArqServletAtual(nomeArquivoServletAtualizacao,nomeEmpresaSistema,regConvertido);                 
                GeraArqServletExcl geraArqServletExcl = new GeraArqServletExcl(nomeArquivoServletExclusao,nomeEmpresaSistema,regConvertido);                 
                GeraArqServletIncl geraArqServletIncl = new GeraArqServletIncl(nomeArquivoServletInclusao,nomeEmpresaSistema,regConvertido);                 
                GeraArqConsultaJsp geraArqConsultaJsp = new GeraArqConsultaJsp(nomeArquivoConsultaHtml,nomeEmpresaSistema,regConvertido);                  
                GeraArqMenuPrincJsp geraArqMenuPrincJsp = new GeraArqMenuPrincJsp(nomeArquivoMenuPrincJsp,nomeEmpresaSistema,regConvertido);  
                GeraArqMenu_princJsp geraArqMenu_princJsp = new GeraArqMenu_princJsp(nomeArquivoMenu_princJsp,nomeEmpresaSistema,regConvertido); 
                GeraArqGrid_Detalhe geraArqGrid_Detalhe = new GeraArqGrid_Detalhe(nomeArquivoGrid_Detalhe,nomeEmpresaSistema,regConvertido);                  
                GeraArqGrid_Campos geraArqGrid_Campos = new GeraArqGrid_Campos(nomeArquivoGrid_Campos,nomeEmpresaSistema,regConvertido);                  
                GeraArqBuildFile geraArqBuildFile = new GeraArqBuildFile(nomeArquivoBuildFile,nomeEmpresaSistema);                  
                GeraArqBuildPrjFile geraArqBuildPrjFile = new GeraArqBuildPrjFile(nomeEmpresaSistema);                  
                GeraArqWebXmlFile geraArqWebXmlFile = new GeraArqWebXmlFile(nomeArquivoWebXmlFile,nomeEmpresaSistema,regConvertido);    

                //limpaVariaveis();
                
            }//if
             
           
            
         }//for   
		 
      };//extrair_xml
		
        private void criar_xml(){
               
               System.out.println("Estou no criar_xml");
                
               Vector v = new Vector();   
               
               System.out.println("qtd linhas->"+lsColunas.getItemCount());
               
               //Cria array dos registros selecionados
               for(int i=1;i<lsColunas.getItemCount()-1;i++){
                  if (lsColunas.isIndexSelected(i)){  
                     v.add(reg[i-1]);   
                  }
               }  
               //Cria array de registros com tamanho do vetor
               regSelecionados = new Registros[v.size()];

               //Copia o conteúdo do vetor para o Array
               v.copyInto(regSelecionados);
                  
               // Converte os tipos das colunas para o java
               System.out.println("regSelecionados.length->"+regSelecionados.length);
               
               ConverteTipoJava convOracleJava = new ConverteTipoJava(regSelecionados);
               
               regConvertido = convOracleJava.getRegConvertidos();
               
               System.out.println("regConvertido.length->"+regConvertido.length);

               //Carrega a variáveis públicas que serão usadas na classe
               nomeEmpresaSistema = txtEmpresaSistema.getText();
               nomeBean = txtNomeClasse.getText().substring(0,txtNomeClasse.getText().length()-5);
               nomeDB = txtNomeDB.getText().substring(0,txtNomeDB.getText().length()-5);              
               nomeDAO = txtNomeDAO.getText().substring(0,txtNomeDAO.getText().length()-5);
               nomeServletAtualizacao = txtNomeServletAtualizacao.getText().substring(0,txtNomeServletAtualizacao.getText().length()-5);
               nomeServletConsulta = txtNomeServletConsulta.getText().substring(0,txtNomeServletConsulta.getText().length()-5);              
               nomeServletExclusao = txtNomeServletExclusao.getText().substring(0,txtNomeServletExclusao.getText().length()-5);
               nomeServletInclusao = txtNomeServletInclusao.getText().substring(0,txtNomeServletInclusao.getText().length()-5);
               nomeConsultaHtml = txtnomeConsultaHtml.getText().substring(0,txtnomeConsultaHtml.getText().length()-4);
               nomeMenuPrincJsp = txtnomeMenuPrincJsp.getText().substring(0,txtnomeMenuPrincJsp.getText().length()-4);
               nomeMenu_princJsp = txtnomeMenu_princJsp.getText().substring(0,txtnomeMenu_princJsp.getText().length()-4);
               nomeGrid_Detalhe = txtNomeGrid_Detalhe.getText().substring(0,txtNomeGrid_Detalhe.getText().length()-4);
               nomeGrid_Campos = txtNomeGrid_Campos.getText().substring(0,txtNomeGrid_Campos.getText().length()-4);
               nomeArquivoBean = txtNomeClasse.getText();
               nomeArquivoDAO = txtNomeDAO.getText();
               nomeArquivoDB = txtNomeDB.getText();
               nomeArquivoServletAtualizacao = txtNomeServletAtualizacao.getText();
               nomeArquivoServletConsulta = txtNomeServletConsulta.getText();
               nomeArquivoServletExclusao = txtNomeServletExclusao.getText();
               nomeArquivoServletInclusao = txtNomeServletInclusao.getText();
               nomeArquivoConsultaHtml = txtnomeConsultaHtml.getText();
    
               nomeArquivoMenuPrincJsp = txtnomeMenuPrincJsp.getText();
               nomeArquivoMenu_princJsp = txtnomeMenu_princJsp.getText();
               nomeArquivoGrid_Detalhe = txtNomeGrid_Detalhe.getText();
               nomeArquivoGrid_Campos = txtNomeGrid_Campos.getText();
               nomeArquivoBuildFile = "build.xml";
               nomeArquivoWebXmlFile = "web.xml";  
               
               
               System.out.println("---------------------------------------------");
               System.out.println("Variáveis públicas carregadas dos campos txt`s.");
               System.out.println("---------------------------------------------");
               System.out.println("nomeTab="+nomeTabela);
               System.out.println("nomeBean="+nomeBean);
               System.out.println("nomeDAO="+nomeDAO);
               System.out.println("nomeDB="+nomeDB);
               System.out.println("nomeServletAtualizacao="+nomeServletAtualizacao);
               System.out.println("nomeServletConsulta="+nomeServletConsulta);
               System.out.println("nomeServletExclusao="+nomeServletExclusao);
               System.out.println("nomeServletInclusao="+nomeServletInclusao);
               System.out.println("nomeConsultaHtml="+nomeConsultaHtml);
               System.out.println("nomeMenuPrincJsp="+nomeMenuPrincJsp);
               System.out.println("nomeGrid_Detalhe="+nomeGrid_Detalhe);
               System.out.println("nomeGrid_Campos="+nomeGrid_Campos);
               System.out.println("nomeArquivoBean="+nomeArquivoBean);
               System.out.println("nomeArquivoDAO="+nomeArquivoDAO);
               System.out.println("nomeArquivoDB="+nomeArquivoDB);
               System.out.println("nomeArquivoServletAtualizacao="+nomeArquivoServletAtualizacao);
               System.out.println("nomeArquivoServletConsulta="+nomeArquivoServletConsulta);
               System.out.println("nomeArquivoServletExclusao="+nomeArquivoServletExclusao);
               System.out.println("nomeArquivoServletInclusao="+nomeArquivoServletInclusao);  
               System.out.println("nomeArquivoConsultaHtml="+nomeArquivoConsultaHtml);
               System.out.println("nomeArquivoMenuPrincJsp="+nomeArquivoMenuPrincJsp);
               System.out.println("nomeArquivoMenu_princJsp="+nomeArquivoMenu_princJsp);
               System.out.println("nomeArquivoGrid_Detalhe="+nomeArquivoGrid_Detalhe);
               System.out.println("nomeArquivoGrid_Campos="+nomeArquivoGrid_Campos);
               System.out.println("nomeArquivoBuildFile="+nomeArquivoBuildFile);
               System.out.println("nomeArquivoWebXmlFile="+nomeArquivoWebXmlFile);
               System.out.println("---------------------------------------------");
               System.out.println("");

                                 
               //Construção do arquivo XML 
               GeraArqXML geraArqXML = new GeraArqXML(regConvertido);
               
               if (geraArqXML.geracao_ok == false){
                  JOptionPane.showMessageDialog(null, "O arquivo XML NÃO foi gerado!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
               }     
		
      };//criar_xml
		
		private void limpaVariaveis(){
			nomeEmpresaSistema="";
			nomeTabela="";
			nomeBean="";
			nomeDAO="";
			nomeDB="";
			nomeServletAtualizacao="";
			nomeServletConsulta="";
			nomeServletExclusao="";
			nomeServletInclusao="";
			nomeConsultaHtml="";
            nomeMenuPrincJsp="";
			nomeGrid_Detalhe="";
			nomeGrid_Campos="";
			nomeArquivoBean="";
			nomeArquivoDAO="";
			nomeArquivoDB="";
			nomeArquivoServletAtualizacao="";
			nomeArquivoServletConsulta="";
			nomeArquivoServletExclusao="";
			nomeArquivoServletInclusao="";
			nomeArquivoConsultaHtml="";
			nomeArquivoMenuPrincJsp="";
			nomeArquivoMenu_princJsp="";
			nomeArquivoGrid_Detalhe="";
			nomeArquivoGrid_Campos="";
			nomeArquivoBuildFile="";
			nomeArquivoWebXmlFile="";
		}
		
		//Renomeia as classes
		private ActionListener btnRenomearClick = new ActionListener(){			
		public void actionPerformed(ActionEvent ae){
				try{
               //captura o nome alterado
					String nomeArq = txtNomeClasse.getText();

					//retira a extensão
					nomeArq = nomeArq.substring(0,(nomeArq.length()-5));

					//txtNomeClasse.setText(nomeArq +".java");
					txtNomeDB.setText(nomeArq +"DB.java");
					txtNomeDAO.setText(nomeArq +"DAO.java");
					txtNomeServletAtualizacao.setText("Atualiza"+nomeArq+"Servlet.java");
					txtNomeServletConsulta.setText("Consulta"+nomeArq+"Servlet.java");
					txtNomeServletExclusao.setText("Exclui"+nomeArq+"Servlet.java");
					txtNomeServletInclusao.setText("Insere"+nomeArq+"Servlet.java");
					txtnomeConsultaHtml.setText("Consultar"+nomeArq+".jsp");
					txtnomeMenuPrincJsp.setText("MenuPrinc"+nomeArq+".jsp");
					txtnomeMenu_princJsp.setText("Menu_princ"+nomeArq+".jsp");
					txtNomeGrid_Detalhe.setText("Grid_Detalhe"+nomeArq+".jsp");
					txtNomeGrid_Campos.setText("Grid_Campos"+nomeArq+".jsp");

				}
				catch (Exception e) {
					System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
				}
		   }

		};    
		
		//Grava os nomes alterados das colunas no array
		private ActionListener btnOkClick = new ActionListener(){
					
			public void actionPerformed(ActionEvent ae){
					
				try{
					
					String s=txtAliasCampo.getText();

					int indx = Integer.parseInt(s.substring(0,s.indexOf("-")));
					System.out.println("indice:"+indx);
					
					reg[indx].setNomeColuna(s.substring(s.indexOf("-")+1));
					CarregaCampos(reg);
				}
				catch (Exception e) {
					System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
				}
		   }
		   		   
		};
		//Lê o XML
		
		public static void LerXml(String arqXML){			
					
				try{
					//Verifica se há um caminho de um arquivo XML
					if(!arqXML.equals("")){
						XmlReader xml= new XmlReader(arqXML);
						// Aqui carregamos o array de registros com os dados do XML
						Vector vCol = new Vector();
						String[] tabelas;
									
						try{
						  tabelas = xml.lerTabelas();
						  lsTabelas.removeAll();
						  System.out.println("Limpou o lsTabelas e irá adicionar "+tabelas.length+" tabelas "+tabelas[0]);
						  for (int i=0;tabelas!=null && i<tabelas.length;i++){
							  lsTabelas.add(tabelas[i]);
							  System.out.println("Adicionando no lsTabelas ->"+tabelas[i]);
						  }
						  	  
						  arquivoXML = arqXML; //Indicará que a tabela foi carregada por arquivo XML
						}
						catch (Exception e) {
						System.out.println("Erro ao ler registros " + e.getMessage());
						}
					}
				}
				catch (Exception e) {
					System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
				}	
	
		};



		
		private ActionListener lsTabelasDoubleClick = new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					lsColunas.removeAll();
					
					nomeTabela = lsTabelas.getSelectedItem();
					//nomeTabela = lsTabelas.getItem(1);
					
					System.out.println("nomeTabela-->"+nomeTabela);
					System.out.println("arquivoXML-->"+arquivoXML);
					
					//reg = null;
					
					//Não carrega o drive se for um arquivo XML 
					
					//if(arquivoXML.equals("")){
					if(arquivoXML==null){
						GeraClassePgsqlDB gcdb = new GeraClassePgsqlDB();
						reg=gcdb.getCampos(nomeTabela);
						
						//System.out.println("Carregou as tabelas");
						
				        CarregaCampos(reg);
				        
				        //System.out.println("Carregou as colunas");
						
					}else{
						try{	
							XmlReader xml= new XmlReader(arquivoXML);						    
			                Vector v = new Vector();
			                v = xml.lerRegistros(nomeTabela);
			                Registros[] r = new Registros[v.size()];
			                
			                //Copia o conteúdo do vetor para o Array
			                v.copyInto(r);
			                CarregaCampos(r);
						}
						catch (Exception e) {
							System.out.println("Ocorreu o seguinte erro ao ler o XML: " + e.getMessage());
						}	
					    	
					}
					
					//CarregaCampos(reg);
					
                    String nomeArq = plm(lsTabelas.getSelectedItem());
					txtNomeClasse.setText(nomeArq +".java");
					txtNomeDB.setText(nomeArq +"DB.java");
					txtNomeDAO.setText(nomeArq +"DAO.java");
					txtNomeServletAtualizacao.setText("Atualiza"+nomeArq+"Servlet.java");
					txtNomeServletConsulta.setText("Consulta"+nomeArq+"Servlet.java");
					txtNomeServletExclusao.setText("Exclui"+nomeArq+"Servlet.java");
					txtNomeServletInclusao.setText("Insere"+nomeArq+"Servlet.java");
					txtnomeConsultaHtml.setText("Consultar"+nomeArq+".jsp");  //Era html agora é jsp					
					txtnomeMenuPrincJsp.setText("MenuPrinc"+nomeArq+".jsp"); 
					txtnomeMenu_princJsp.setText("menu_princ.jsp"); 
					txtNomeGrid_Detalhe.setText("Grid_Detalhe"+nomeArq+".jsp");
					txtNomeGrid_Campos.setText("Grid_Campos"+nomeArq+".jsp");
					
					btnGeraClasse.setEnabled(true);
					btnRenomear.setEnabled(true);
				}
				catch (SQLException e) {
					System.out.println("Throwing SQLException " + e.getMessage());
				}
		   }
		};

		private ActionListener lsColunasDoubleClick = new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					
					//DefineCampos dc = new DefineCampos("Definir campos");
					String s = lsColunas.getSelectedItem();
					//dc.setAlias(s.substring(s.indexOf("-")+1,s.indexOf(" ")));
					
					System.out.println("Duplo clic!");
					System.out.println(reg[1].getColuna());
										
					
					//if(dc.botao_ok==true){
						//System.out.println("ok pressionado");

						txtAliasCampo.setVisible(true);
						lblAlias.setVisible(true);
						btnOk.setVisible(true);

//						txtAliasCampo.setText(s.substring(s.indexOf("Col:"),s.indexOf(" ")));
						txtAliasCampo.setText(s);
			
						
						
						//-----------------------------
						
						// Create application frame.
		                 EditColunaFrm editFrm = new EditColunaFrm();
		                 
		                 
		                 center(editFrm);
		              
		                 
		                 editFrm.txtAliasColuna.setText("oiii");
		                 editFrm.setVisible(true);
		                 
		                 // Show frame
		                 editFrm.pack();
		                 //editFrm.show();
		                 
		                 
		                 Registros r = new Registros();//(s.substring(0,s.indexOf(" ")),
		                                             //s.substring(1,s.indexOf(" ")),
		                                             //s.substring(2,s.indexOf(" ")),
		                                             //s.substring(3,s.indexOf(" "))
		                 //);   
		                 
		                 editFrm.setRegistro(r);

						//-----------------------------
						
					//	reg[1].setNomeColuna("Alterado");
					//	CarregaCampos(reg);
					//}
					
				}
				catch (Exception e) {
					System.out.println("Erro no evento list2DoubleClick -" + e.getMessage());
				}
		   }
		};

		private ActionListener chkSelTodosClick = new ActionListener(){
			public void actionPerformed(ActionEvent ae){		
				for(int i=0;i<lsColunas.getItemCount();i++){
					//if (chkSelecionarTodos.getSelectedItem()){
						lsColunas.select(i);
					//} else{
					//	ls2.deselect(i);
					//}
				}
		   }
		};

      //Botão GeraClasse ->agora a chamada é pelo menu
      private ActionListener btnAnalyticaClick = new ActionListener(){    
         public void actionPerformed(ActionEvent ae){
            
            System.out.println("----------------------------------------------------");
            System.out.println("Estou no ActionListener btnAnalyticaClick...");
            System.out.println("");
            
            //Verifica se extrairá os dados de um arquivo XML
            //if(txtCaminhoXml.getText().equals("")){
             if(arquivoXML.equals("")){
               
               Vector v = new Vector();   
                  
               //Cria array dos registros selecionados
               for(int i=0;i<lsColunas.getItemCount();i++){
                  if (lsColunas.isIndexSelected(i)){  
                     v.add(reg[i]);   
                  }
               }  
               //Cria array de registros com tamanho do vetor
               regSelecionados = new Registros[v.size()];

               //Copia o conteúdo do vetor para o Array
               v.copyInto(regSelecionados);
                  
               System.out.println("regSelecionados.length->"+regSelecionados.length);
                              
               //Carrega a variáveis públicas que serão usadas na classe
               nomeBean = txtNomeClasse.getText().substring(0,txtNomeClasse.getText().length()-5);
 
               
                  
                 }//if
                                
             JOptionPane.showMessageDialog(null, "Arquivo do Analytica gerado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
         
         };
      };



     /****** FIM DOS LISTENERS  *********/
		
	 /***** Início dos métodos auxiliares   ******/
	
	public static String plm(String s){
	   return  s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
	}
	
	public static String plmi(String s){
	   return  s.substring(0,1).toLowerCase() + s.substring(1);
	}

	public static String ctipo(String s){
      
      String tipoConv = "String";

		if(s.equalsIgnoreCase("String")){		
			 tipoConv = "String";
		}
		
		if(s.equalsIgnoreCase("float")){
			
		    tipoConv = "float";
		}
		
		if(s.equalsIgnoreCase("int")){
			
		    tipoConv = "int";
		}

		if(s.equalsIgnoreCase("double")){
			
		    tipoConv = "double";
		}

		if(s.equalsIgnoreCase("boolean")){
			
			 tipoConv = "boolean";
		}

		if(s.equalsIgnoreCase("java.sql.Date")){
			
			 tipoConv = "Date";
		}
		
		if(s.equalsIgnoreCase("java.sql.Time")){
			
			 tipoConv = "Time";
		}

		if(s.equalsIgnoreCase("java.sql.Timestamp")){
			
			 tipoConv = "Timestamp";
		}

		if(s.equalsIgnoreCase("java.math.BigDecimal")){
			
			 tipoConv = "BigDecimal";
		}

		if(s.equalsIgnoreCase("byte")){
			
			 tipoConv = "byte";
		}
		if(s.equalsIgnoreCase("short")){
			
			 tipoConv = "short";
		}

		if(s.equalsIgnoreCase("long")){
			
			 tipoConv = "Long";
		}
		
		if(s.equalsIgnoreCase("byte[]")){
			
			 tipoConv = "bytes";
		}		
		
		return  plm(tipoConv);
	}
	
	public static String strConc(String str_main, String str_conc, int tamanho ){
		
		if(str_main==null){
			str_main="null";
		}
		
		int tam_str_main = str_main.length();
		int qtd_str=(tamanho - tam_str_main);
		
		if(tamanho > tam_str_main){
		
			for(int i=0;i<qtd_str;i++){
				str_main =str_main + str_conc;		
	    	}
    	}	
		return str_main;	
	}	

	public static String concStr(String str_main, String str_conc, int tamanho ){
		
		if(str_main==null){
			str_main="null";
		}
		
		int tam_str_main = str_main.length();
		int qtd_str=(tamanho - tam_str_main);
		
		if(tamanho > tam_str_main){
		
			for(int i=0;i<qtd_str;i++){
				str_main = str_conc + str_main;		
	    	}
    	}	
		return str_main;	
	}	
	  
	//Fim dos métodos auxiliares	

}//class
	