package module3;
/**
 * Created by home on 06.03.2016.
 */
public abstract class MusicalInstrument implements Comparable{
    private static long counter;

    final long id = counter++;

    protected String type;
    private int price;

    public MusicalInstrument(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public MusicalInstrument(String type){
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    abstract void playSound();

    @Override
    public String toString() {
        return "|| MusicalInstrument" +
                "\t|| id=" + id +
                "\t\t|| type='" + type + '\'' +
                "\t\t\t|| price=" + price +
                "\t||";
    }
    @Override
    public int compareTo(Object o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        MusicalInstrument instrument = (MusicalInstrument)o;

        if (this.getPrice() <= instrument.getPrice()){
            return AFTER;
        }
//        if (this.getPrice() == instrument.getPrice()){
//            return EQUAL;
//        }
        if (this.getPrice() > instrument.getPrice()){
            return BEFORE;
        }

        return 0;
    }
}
