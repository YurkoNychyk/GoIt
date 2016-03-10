import java.util.List;

/**
 * Created by home on 06.03.2016.
 */
public class Bouquet {
    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    private List<Flower> flowerList;
}
