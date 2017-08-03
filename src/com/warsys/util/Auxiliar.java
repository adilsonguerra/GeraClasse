package com.warsys.util;

public class Auxiliar  {
    
    private int quant=10;
    private int total;
    private int campo;
    private int pagina;
    private String destacartxt = "";
    public String mensagem;
    public String mostraano="";
    
    public void setQtdLinha(int lin){
        if (lin!=0){this.quant=lin;}
    }
    
    public int getInicioPagina(){
        int lin= this.quant;
        int total = getPagina()*lin-lin+1;
        return total;
    }
    
    public int getFimPagina(){
        int lin = this.quant;
        int total = getPagina()*lin;
        return total;
    }
    
    
    public int getCampo() {
        return campo;
    }
    
    public int getPagina() {
        if (pagina==0){pagina=1;}
        return pagina;
    }
    
    public int getTotal() {
        return total;
    }
    
    public String getDestacartxt() {
        return destacartxt;
    }
    
    public int getUltima() {
        return (int)(Math.ceil(total/(double)this.quant)-1);
    }
    
    public void setCampo(int campo) {
        this.campo = campo;
    }
    
    public void setPagina(int pagina) {
        this.pagina=pagina;
    }
    
    protected void setTotal(int total){
        this.total=total;
    }
    
    public void setDestacartxt(String destacartxt) {
        this.destacartxt = destacartxt;
    }
    
    public String getVirgula(String s){
        
        s=s.replace('.',',');
        
        return s;
    }
    
    public String getMostraano(){
        return mostraano;
    }
    
    public void setMostraano(String mostraano){
        this.mostraano = mostraano;
    }
    
    public String getPaginacao(){
        String s="";
        s+="<table id='paginacao' width=100% border=1 cellspacing=0 cellpadding=4>";
        s+="  <tr class='paginacao'>";
        s+="    <td width='50' class='dados'>Registros:"+total;
        s+="    </td>";
        s+="    <td align='center' class='dados'>";
        
        if (pagina<=1){
            s+="Primeira | Anterior";
        } else {
            s+="<a href='?metodo=normal&pagina=1&campo="+campo+"&mostraano="+mostraano+"'>Primeira</a>";
            s+=" | ";
            s+="<a href='?metodo=normal&pagina="+(pagina-1)+"&campo="+campo+"&mostraano="+mostraano+"'>Anterior</a>";
        }
        s+=" | ";
        for (int i=0;i<=getUltima();i++) {
            System.out.println("Verifica I-> "+i+" = Página-> "+pagina);
            if (pagina==i+1) {
                s+=i+1;
                System.out.println("IF");
            }else{
                System.out.println("ELSE");
            s+="<a href='?metodo=normal&pagina="+(i+1)+"&campo="+campo+"&mostraano="+mostraano+"'>"+(i+1)+"</a>";
            }
            s+=" | ";
        }
                
        if (pagina>=getUltima()){
            s+="Próxima | Última";
        } else{
            if (pagina==0){pagina=1;}
            s+="<a href='?metodo=normal&pagina="+(pagina+1)+"&campo="+campo+"&mostraano="+mostraano+"'>Próxima</a>";
            s+=" | ";
            s+="<a href='?metodo=normal&pagina="+(getUltima()+1)+"&campo="+campo+"&mostraano="+mostraano+"'>Última</a>";
        }
        s+="    </td>";
        s+="    <td width='50' align='right' class='dados'>Página:"+pagina+"</td>";
        s+="  </tr>";
        s+="</table>";
        return s;
    }
}
