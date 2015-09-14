/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nick
 */
import java.util.Scanner;
import java.util.Random;
public class Fighter {
    public static void main(String [] args){
        int choice;
        Random gen = new Random();
        Scanner reader = new Scanner(System.in);
        System.out.println("Name your Mage!");
        String name = reader.nextLine();
        Mage Nick = new Mage(name);
        Mage John = new Mage("John", 250, 10, 250);
        System.out.println("John the boss has appeared!!!");
        while(Nick.getHealth() > 0){
            System.out.println(Nick.getName() + " has " + Nick.getMana() + " mana left and " + Nick.getHealth()
                    + " health left! What will " + Nick.getName() +
                    " do?\n 1 Attack 2 Cast Spell\n 3 Rest 4 run");
            choice = reader.nextInt();
            if(choice == 1){
                Nick.attack(John);
            }
            else if(choice == 2){
                System.out.println("Which spell would you like to cast?\n 1 " + Nick.getSpellBook()[0].getName() + 
                        "(" + Nick.getSpellBook()[0].getCost() + ") 2 " + Nick.getSpellBook()[1].getName() +
                        "(" + Nick.getSpellBook()[1].getCost() + ") \n 3 " + Nick.getSpellBook()[2].getName()
                        + "(" + Nick.getSpellBook()[2].getCost() + ") 4 " + Nick.getSpellBook()[3].getName() + "("
                        + Nick.getSpellBook()[3].getCost() + ")");
                choice = reader.nextInt();
                if(choice == 4){
                    Nick.castSpell(choice-1, Nick);
                }
                else{
                    Nick.castSpell(choice-1, John);
                }
            }
            else if (choice == 3){
                Nick.rest();
            }  
            else{
                Nick.setHealth(0);
                break;
            }
            System.out.println("John has " + John.getHealth() + " health left!");
            if(John.getHealth() > 0){
                if(John.getHealth() < 100 && John.getMana() > John.getSpellBook()[3].getCost()){
                    John.castSpell(3, John);
                }
                else if(John.getMana() > John.getSpellBook()[2].getCost()){
                    John.castSpell(2, Nick);
                }
                else if(John.getMana() > John.getSpellBook()[0].getCost()){
                     John.castSpell(0, Nick);
                }
                else if(John.getMana() > John.getSpellBook()[1].getCost()){
                     John.castSpell(1, Nick);
                }
                else{
                    System.out.println("John Charges his mana!");
                    John.setMana(John.getMana() + gen.nextInt(41)+10);
                }
            }
            else{
                System.out.println("John Died");
                break;
            }
        }
        if(Nick.getHealth() > 0){
                System.out.println("you Win!");
            }
            else{
                System.out.println("You Lost!");
            }
    }
}
