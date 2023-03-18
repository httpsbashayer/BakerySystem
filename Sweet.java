public class Sweet extends Item{
  private String name;
  
  Sweet(String n, double price) throws IllegalNameException{
    super(price);
    if(n.equalsIgnoreCase("Doughnut") || n.equalsIgnoreCase("English Cake") || n.equalsIgnoreCase("Cookies"))
      name = n;
    else
    throw new IllegalNameException("This is illegal form of name | your input was " + n);
  }
  
  Sweet(Sweet s) throws IllegalNameException{
      this(s.name, s.getPrice());
  }
  
  public String toString(){
    return super.toString() + "Name: " + name + "\r";
  }
  
  public boolean isRotten(){
    if((name.equalsIgnoreCase("Doughnut") && displayedDays > 2) || (name.equalsIgnoreCase("English Cake") && displayedDays > 4) || (name.equalsIgnoreCase("Cookies") && displayedDays > 3))
    return true;
    else
    return false;
  }
}

class IllegalNameException extends Exception{
  IllegalNameException(String message){
    super(message);
  }
}