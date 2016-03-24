package module3;
/**
 * Created by home on 06.03.2016.
 */
public class Piano extends MusicalInstrument{
    public Piano(String type, int price) {
        super(type, price);
    }
    public Piano(String type) {
        super(type);
    }
    @Override
    public void playSound() {
        System.out.println("Piano sound");
    }

}
