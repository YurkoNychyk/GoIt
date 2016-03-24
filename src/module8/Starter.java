package module8;
import module3.*;

import java.util.*;

/**
 * Created by home on 23.03.2016.
 */
public class Starter {

    public static void main(String[] args) {

        List<MusicalInstrument> listOfInstruments = new LinkedList<>();
        //Filling up collections with random objects
        generateCollection(listOfInstruments);

        HashSet<MusicalInstrument> setOfInstruments = new HashSet(listOfInstruments);
        TreeSet<MusicalInstrument> treeSetMusicalInstruments = new TreeSet(listOfInstruments);

        System.out.println("LinkedList");
        CollectionPrint.printOutMusicalInstrument(listOfInstruments);
        System.out.println("Set");
        CollectionPrint.printOutMusicalInstrument(setOfInstruments);
        System.out.println("Treeset");
        CollectionPrint.printOutMusicalInstrument(treeSetMusicalInstruments);

    }
    //Fill up collection with an object of a random type
    public static void generateCollection (Collection collection) {
        final int randomNumberRange = 3;
        Random randomizer = new Random();

        for (int i=0; i<10; i++){
            int randomNumber = randomizer.nextInt(randomNumberRange);
            switch (randomNumber){
                case 1:
                    collection.add(new Guitar("guitar" , randomNumber));
                    break;
                case 2:
                    collection.add(new Piano("piano" , randomNumber));

                    break;
                case 3:
                    collection.add(new Tube("tube" , randomNumber));

                    break;
                default:
                    collection.add(new Tube("tube", randomNumber));

            }
        }
    }


}
