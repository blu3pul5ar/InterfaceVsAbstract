/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nick
 */

public interface Being {
    public abstract void setName(String n);
    public abstract String getName();
    public abstract void setHealth(int b);
    public abstract int getHealth();
    public abstract void attack(Being b);
    public abstract void block();
    public abstract void takeDamage(int d);
    public abstract void rest();
}
