import java.util.*;
import java.io.*;

public class Bakery{
  private Item []items;
  private int numItems, numSweets;
  private double Area;
  private String Name, Location;
  
  Bakery(String name, String loc, double area, int size){
    Name = name;
    Location = loc;
    Area = area;
    items = new Item[size];
    numItems = 0;
    numSweets = 0;
  }
  
  public boolean addItem(Item item) throws IllegalNameException{
    if(numItems < items.length){
     if(item instanceof Sweet){ //The addition of sweet
      items[numItems++] = new Sweet ((Sweet) item);
      numSweets++;}
     if(item instanceof Bread) //The addition of bread
      items[numItems++] = new Bread ((Bread) item);
      return true;
    }
    else
    return false;
  }
  
  public boolean removeItem(int loc){
  try{
    if(items[loc] != null){
    
      for(int count = 0; count < numItems; count++){
        if(items[count].equals(items[loc]))
        numItems--;
        if(items[count] instanceof Sweet)
        numSweets--;}
        
        int count;
      for(count = loc; count < numItems; count++)
        items[count] = items[count + 1];  
        items[count] = null;
        return true;
      }
      else 
        throw new NullPointerException();
        } catch (ArrayIndexOutOfBoundsException e1) {
          System.out.println("This location is not in the range of the menu list | your input " + loc);
        } catch (NullPointerException e2) {
          System.out.println("There is no item exists at this index " + loc);
        }
        return false;
  }
  
  public void DailyCheck(){
    //Opeartions for daily check
    for(int count = 0; count < numItems; count++){
    (items[count].displayedDays)++;
    if(items[count].isRotten())
    removeItem(count);
    }
    
    try{
    //Save information to a file
    File dailyCheck = new File("bakery.dat");
    FileOutputStream fileOutStream = new FileOutputStream(dailyCheck);
    ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
    
    //Bakery info
    objectOutStream.writeBytes(Name);
    objectOutStream.writeBytes(Location);
    objectOutStream.writeDouble(Area); 
    objectOutStream.writeInt(numItems); 
    objectOutStream.writeInt(numSweets);
    
    //List of items
    for(int count = 0; count < numItems; count++)
    objectOutStream.writeObject((Item)items[count]);
    
    objectOutStream.close(); } catch (IOException error) {
      System.out.println(error);
    }
  }
  
  public String storeAllSweet(){
    String data = "Bakery's name: " + Name + " \rNumber of sweets: " + numSweets + "         \rTotal price of sweets: ";
    double total = 0;
    for(int count = 0; count < numItems; count++)
    if(items[count] instanceof Sweet)
    total += items[count].getPrice();
    
    data += total + " SR\r";
    try{
    File storeSweet = new File("sweets.txt");
    FileOutputStream fileOut = new FileOutputStream(storeSweet);
    PrintWriter writer = new PrintWriter(fileOut);
    writer.print(data);
    writer.close();} catch (IOException e) {
      System.out.println(e);
    }
    
    return data;
  }
  
  public String toString(){
    String info = "\rName: " + Name + "\rLocation: " + Location + "\rArea: " + Area + " KM^2\rNo. of items: " + numItems + " item\r\rMenu: ";
    for(int count = 0; count < numItems; count++)
    info += "\rItem no. " + (count + 1) + "\r" + items[count].toString();
    
    return info;
  }
  
  public Item[] getItems(){
    return items;
  }
  
  public int getNumItems(){
    return numItems;
  }
  
  public int getNumSweets(){
    return numSweets;
  }
}