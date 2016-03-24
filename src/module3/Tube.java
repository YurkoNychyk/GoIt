package module3;
/**
 * Created by home on 06.03.2016.
 */
public class Tube extends MusicalInstrument{
    public Tube(String type, int price) {
        super(type, price);
    }
    public Tube(String type) {
        super(type);

    }

    @Override
    public void playSound() {
        System.out.println("Tube sound");
    }


}
