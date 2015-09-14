/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nick
 */
public abstract class MagicUser implements EnlightenedBeing{
  
     private AttackSpell Fireball = new AttackSpell("FireBall",10,20);
    private AttackSpell Frost = new AttackSpell("Frost",5,10);
    private AttackSpell Lightningbolt = new AttackSpell("LightningBolt",25,50);
    private healSpell heal = new healSpell("Heal",25,20);
    private final spell[] spellBook = {Fireball,Frost,Lightningbolt,heal};
    
    public final void castSpell(int magic, Being b){
        spell spell = spellBook[magic];
        if(spell.getCost() > this.getMana()){
            System.out.println("Not Enough Mana!?!");
            return;
        }
        System.out.println(this.getName() + " cast " + spell.getName() + " at " + b.getName());
        spell.cast(b);
        this.setMana(this.getMana()- spell.getCost());
    }

    public final spell[] getSpellBook() {
        return spellBook;
    }
    
}
