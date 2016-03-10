/**
 * Created by home on 06.03.2016.
 */
public abstract class MusicalInstrument {

    private String name;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void playSound();
}
