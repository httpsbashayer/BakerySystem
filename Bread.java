public class Bread extends Item{
  private String type;
  
  Bread(String t, double price){
    super(price);
    type = t;
  }
  
  Bread(Bread b){
    this(b.type, b.getPrice());
  }
  
  public String toString(){
    return super.toString() + "Type: " + type + "\r";
  }
  
  public String getType(){
    return type;
  }
  
  public boolean isRotten(){
    if((type.equalsIgnoreCase("Arabic") && displayedDays > 3) || (type.equalsIgnoreCase("Toast") && displayedDays > 5) || (type.equalsIgnoreCase("Others") && displayedDays > 4))
    return true;
    else
    return false;
  }
}