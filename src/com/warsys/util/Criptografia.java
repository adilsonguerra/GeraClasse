package com.warsys.util;

public class Criptografia {
    private String s = "";
    
    public Criptografia(){
    }//construtor
    
    public String cripto(String s){
        //retira os brancos
        s=s.trim();
        
        //monta um array de chrs
        char[] chr =s.toCharArray();
        int asc;
        int asc2;
        int tam =chr.length;
        int aux=0;
        char str;
        
        if (tam>0){
            for(int i=0;i<tam;i++){
                asc =chr[i];
                asc2= i+tam+1;
                aux=asc^asc2;
                if(aux>255){
                    aux=255;
                }
                str=(char)aux;
                this.s= this.s+str;
            }
        }
        return this.s;
    }    
}
