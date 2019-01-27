package com.udemy;

public class Bankomat {

    private int saldo;

    public void wplataPieniedzy(int wplata){
        if(wplata>0) {
            saldo = saldo + wplata;
        }
        if (wplata <= 0) {
            System.out.println("Nie mozna wplacic takiej kwoty.");
        }
    }

    public void wyplataPieniedzy(int wyplata){
        if(wyplata<+saldo) {
            saldo = saldo - wyplata;
        }else{
            System.out.println("Nie masz wystarczajacej ilosci srodkow na koncie!");
        }
    }

    public int pokazSaldo(){
        System.out.println("Masz na koncie: " + saldo);
        return saldo;
    }
}
