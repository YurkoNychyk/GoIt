package module3;
/**
 * Created by home on 06.03.2016.
 */
public abstract class MusicalInstrument implements Cloneable{
    private static long counter;

    final long id = counter++;

    protected String type;
    private float price;

    public MusicalInstrument(String type){
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    abstract void playSound();
}
