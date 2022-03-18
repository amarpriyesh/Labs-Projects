import java.util.ArrayList;

public class Main {
  public static void main(String[] args){
    Housing a= new Isolation();
    a.setHousing(8);
    a.setIsolation("jb", 8);
    a.setIsolation("jeb", 8);


   for(Monkey b:a.getIsolation()) {
     System.out.println(b.getName());
   }








  }


}
