/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.darumanfce;

import br.com.daruma.jna.NFCe;
import br.com.daruma.jna.UTIL;

/**
 *
 * @author mario
 */
public class Main {

    static {
        try {
            System.loadLibrary("DarumaFramework");
            System.out.println("DarumaFramework Carrega !!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        NFCe.regAlterarValor("CONFIGURACAO\\EmpPK", "");

        //Impressora
        UTIL.regAlterarValor("DUAL\\PortaComunicacao", "192.168.0.1:2000");
        
        NFCe.aCFAbrir("08799507900", "Mario Feles", "", "", "", "", "", "", "");
        NFCe.aCFVender("1", "1", "3", "0", "0", "1", "UN", "Coca-Cola");
        NFCe.aCFVender("1", "1", "5", "0", "0", "2", "UN", "X-Salada");
        NFCe.aCFTotalizar("D$", "0,00");
        NFCe.aCFEfetuarPagamento("Dinheiro", "8");
        int retorno = NFCe.tCFEncerrar("DarumaFramework NFC-e !!!");
        
        System.out.println("Retorno NFC-e " + retorno);

    }

}
