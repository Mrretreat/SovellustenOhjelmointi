import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      ArrayList<Elain> elaimet = new ArrayList<>();
      elaimet.add(new Lintu("Lokki"));
      elaimet.add(new Elain("Elain"));
      elaimet.add(new Kala("Kilpikonna"));

      for(Elain e : elaimet){
        e.heraa();
      }
      for(Elain e: elaimet){
        e.toimi();
      }
      for(Elain e: elaimet) {
        e.lepaa();
      }
    }
}
