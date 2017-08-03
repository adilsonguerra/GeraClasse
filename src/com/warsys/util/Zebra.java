package com.warsys.util;

public class Zebra {
    private int i = 0;
    
    public String getCorProxima() {
        return ++i % 2 == 0 ? "impar" : "par";
    }
    
    public String getCorAtual() {
        return i % 2 == 0 ? "impar" : "par";
    }
    
}
