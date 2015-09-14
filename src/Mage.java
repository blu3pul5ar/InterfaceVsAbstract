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
    private AttackSpell Fireball = new AttackSpell("FireBall",10,20);
    private AttackSpell Frost = new AttackSpell("Frost",5,10);
    private AttackSpell Lightningbolt = new AttackSpell("LightningBolt",25,50);
    private healSpell heal = new healSpell("Heal",25,20);
    private final spell[] spellBook = {Fireball,Frost,Lightningbolt,heal};
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

    @Override
    public void block() {
    }
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
    public void castSpell(int magic, Being b){
        spell spell = spellBook[magic];
        if(spell.getCost() > this.getMana()){
            System.out.println("Not Enough Mana!?!");
            return;
        }
        System.out.println(this.Name + " cast " + spell.getName() + " at " + b.getName());
        spell.cast(b);
        this.mana -= spell.getCost();
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

    public void takeDamage(int d) {
        this.health -= d;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public spell[] getSpellBook() {
        return spellBook;
    }
    
}
