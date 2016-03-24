package module3;
/**
 * Created by home on 06.03.2016.
 */
public class Guitar extends MusicalInstrument {
    public Guitar(String type) {
        super(type);
    }
    public Guitar(String type, int price) {
        super(type, price);
    }

    @Override
    public void playSound() {
        System.out.println("Guitar sound");
    }
}
