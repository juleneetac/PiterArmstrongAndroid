package edu.upc.dsa.models;

public class User {   //Former "Personaje" and "Usuario" classes

    String username;
    String password;
    int health;
    int defense;
    int attack;
    int money;
    int pieces;  //las piezas serán un int que aqui no identificamos que clase de pieza es sino solo las qu tiene
    int screen;

    public User(String usr, String pwd, int health, int def, int att, int money, int pieces, int screen) {
        this.username = usr;
        this.password = pwd;
        this.health = health;
        this.defense = def;
        this.attack = att;
        this.money = money;
        this.pieces = pieces;
        this.screen= screen;
    }

    public User(String name, String pass){
        this.username = name;
        this.password = pass;
    }

    public User() {
        //Empty constructor
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

}