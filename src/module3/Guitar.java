package module3;
/**
 * Created by home on 06.03.2016.
 */
public class Guitar extends MusicalInstrument{
    public void playSound() {
        System.out.println("Guitar sound");
    }

    public Guitar(String type) {
        super(type);
    }
}
