/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nick
 */ 
public class Mage extends MagicUser{
    private int health;
    private int attack;
    private int mana;
    private String Name;
   
    public Mage(String Name) {
        this.Name=Name;
        health = 100;
        attack = 10;
        mana = 100;
    }

    public Mage(String Name, int health, int attack, int mana) {
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.Name = Name;
    }
    
    

    
    @Override
    public void attack(Being b) {
        b.setHealth(b.getHealth() - this.attack);
    }

    /**
     *
     */
    @Override
    public void block() {
    }
    @Override
    public void rest(){
        if(this.mana < 100){
            this.mana += 10;
            if(this.mana > 100){
                this.mana = 100;
            }
        }
        if(this.health < 100){
            this.health += 10;
            if(this.health > 100){
                this.health = 100;
            }
        }
    }

 
   

    @Override
    public void setMana(int m) {
        this.mana = m;
    }

    @Override
    public void setHealth(int b) {
        this.health = b;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getHealth() {
       return health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public void takeDamage(int d) {
        this.health -= d;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String Name) {
        this.Name = Name;
    }
    
}
