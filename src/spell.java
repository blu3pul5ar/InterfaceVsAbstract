/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nick
 */
public abstract class spell {
    private String name;
    private int power;
    private int cost;
    public spell(String name, int power) {
        this.name = name;
        this.power= power;
    }
    public abstract void levelUp();
    public void cast(Being b){
        if(this instanceof AttackSpell){
            b.takeDamage(this.getPower());
        }
        else if(this instanceof healSpell){
            b.setHealth(b.getHealth() + this.power);  
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    
}
