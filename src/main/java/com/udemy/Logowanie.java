package com.udemy;

public class Logowanie {

    //tutaj bedzie przechowywana nazwa uzytkownika i haslo - symulacja bazy danych
    private String currentUserName;
    private String currentPassword;
    private String msg;
    private boolean isLoggedIn;

    //implementacja odpowiednich metod, ktore umożliwia przeprowadzenie testow
    public void setUserInDataBase(String userName, String password){ //parametry
        this.currentUserName = userName; //przypisujemy do nazwy uzytkownika (currentUserName) ta nazwe, która została podana w metodzie jako parametr
        this.currentPassword = password; //przypisujemy do hasla (currentPassword) to haslo, które zostało podane w metodzie jako parametr
    }

    public boolean logIn(String userName, String password){
        if(userName.equals(currentUserName) && password.equals(currentPassword)){
            this.msg = "Udalo Ci sie zalogowac!";
            this.isLoggedIn = true;
        }else{
            this.msg = "Nie ualo Ci sie zalogowac!";
            this.isLoggedIn = false;
        }
        return isLoggedIn;
    }

    public String getMsg(){ //możliwosc pobrania informacji, czy uzytkownik jest zalogoany - pobranie wiadomosci
        return msg;
    }

    public boolean isLoggedIn(){ //mozlioosc pobrania informacji (true/false), czy uzytkownik jest zalogowany
        return isLoggedIn;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }
}
