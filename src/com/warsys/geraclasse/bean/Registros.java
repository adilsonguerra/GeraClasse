
package com.warsys.geraclasse.bean;

public class Registros{

  private String coluna;  
  private String tipo;
  private String tamanho;
  private String precisao;
  private String obrigatorio;
  private String chave;
  private String ini;
  private String nomeColuna;
  private String repositorio;
  private String tabRepos;
  private String chaveRepos;

  /**
   * @param coluna: Nome da coluna no banco de dados
   * @param tipo: Tipo da coluna
   * @param tamanho: Tamanho do campo
   * @param precisao: Casas após a vírgula
   * @param Obrigatorio: Se Permite nulo ou não
   * @param ini: Como deverá ser inicializado
   * @param nomeColuna: nome que irá no label
   * @param repositorio: tipo de componente que será usado textbox,combo, etc.
   * @param tabRepos: Tabela que será usada para preencher o combo
   * @param chaveRepos: campo chave da tabela que será usada para preencher o combo
  */
  
  public Registros(){
  }
  
  public Registros(String coluna, String tipo, String tamanho, String precisao, String obrigatorio, String chave, String ini, String nomeColuna, String repositorio, String tabRepos, String chaveRepos) {
    this.coluna = coluna;
	 this.tipo = tipo;
	 this.tamanho = tamanho;
	 this.precisao = precisao;
	 this.obrigatorio = obrigatorio;
	 this.chave = chave;
	 this.ini = ini;
	 this.nomeColuna = nomeColuna;
	 this.repositorio = repositorio;
	 this.tabRepos = tabRepos;
	 this.chaveRepos = chaveRepos;
  }

   public Registros(String coluna, String tipo, String tamanho, String precisao, String obrigatorio, String chave, String ini) {
    this.coluna = coluna;
	 this.tipo = tipo;
	 this.tamanho = tamanho;
	 this.precisao = precisao;
	 this.obrigatorio = obrigatorio;
	 this.chave = chave;
	 this.ini = ini;
  }

  public String getColuna() {
    return coluna;
  }

  public String getTipo() {
    return tipo;
  }

  public String getTamanho() {
    return tamanho;
  }

  public String getPrecisao() {
    return precisao;
  }
  
  public String getObrigatorio() {
    return obrigatorio;
  }
  public String getChave() {
    return chave;
  }
  public String getIni() {
    return ini;
  }
  public String getNomeColuna() {
    return nomeColuna;
  }
  public String getRepositorio() {
    return repositorio;
  }
  public String getTabRepos() {
    return tabRepos;
  }
  public String getChaveRepos() {
    return chaveRepos;
  }

  public void setColuna(String coluna) {
    this.coluna =coluna;
  }

  public void setTipo(String tipo) {
    this.tipo =tipo;
  }

  public void setTamanho(String tamanho) {
    this.tamanho = tamanho;
  }

  public void setPrecisao(String precisao) {
    this.precisao = precisao;
  }

  public void setObrigatorio(String obrigatorio) {
    this.obrigatorio = obrigatorio;
  }

  public void setChave(String chave) {
    this.chave = chave;
  }
  public void setIni(String ini) {
    this.ini = ini;
  }

  public void setNomeColuna(String nomeColuna) {
    this.nomeColuna=nomeColuna;
  }
  public void setRepositorio(String repositorio) {
    this.repositorio=repositorio;
  }
  public void setTabRepos(String tabRepos) {
    this.tabRepos=tabRepos;
  }
  public void setChaveRepos(String chaveRepos) {
    this.chaveRepos=chaveRepos;
  }

}
