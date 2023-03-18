import java.util.*;
import java.io.*;

public abstract class Item implements Serializable{
   private static Scanner scan = new Scanner(System.in);
   protected int displayedDays;
   private double price;
   
   Item(double price) throws InputMismatchException{
     displayedDays = 1;
     boolean correct = true;
     while(correct){ 
     try{
     if(price < 0)
     throw new InputMismatchException("Invalid price | your input was " + price);
     else
     this.price = price;
     correct = false;
     } catch (InputMismatchException e) { 
       System.out.println("Please re-enter the price correctly");
       price = scan.nextDouble();
     }
    }
   }
   
   Item(Item item){
     this(item.price);
     displayedDays = item.displayedDays;
   }
   
   public String toString(){
     return "Price: " + price + " SR\rNo. of displayed days: " + displayedDays + "\r";
   }
   
   public double getPrice(){
     return price;
   }
   
   public abstract boolean isRotten();
}