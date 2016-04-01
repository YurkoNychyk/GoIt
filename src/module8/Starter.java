package module8;
import module3.*;
import module9.*;

import java.util.*;

/**
 * Created by home on 23.03.2016.
 */
public class Starter {

    public static void main(String[] args) {

        List<MusicalInstrument> listOfInstruments = new LinkedList<>();
        String encodedCollectionText;
        String decodedCollectionText;

        //Filling up collections with random objects
        generateCollection(listOfInstruments);
        HashSet<MusicalInstrument> setOfInstruments = new HashSet(listOfInstruments);
        TreeSet<MusicalInstrument> treeSetMusicalInstruments = new TreeSet(listOfInstruments);


/*
        System.out.println("LinkedList");
        System.out.println(CollectionPrint.printOutMusicalInstrument(listOfInstruments));
        System.out.println("Set");
        System.out.println(CollectionPrint.printOutMusicalInstrument(setOfInstruments));
        System.out.println("Treeset");
        System.out.println(CollectionPrint.printOutMusicalInstrument(treeSetMusicalInstruments));
*/

        System.out.println("Normal collection:");
        System.out.println(CollectionPrint.printOutMusicalInstrument(treeSetMusicalInstruments));

        encodedCollectionText = Coder.encodeString(CollectionPrint.printOutMusicalInstrument(treeSetMusicalInstruments),5);
        System.out.println("Encoded collection: \n" + encodedCollectionText);

        decodedCollectionText = Coder.decodeString(encodedCollectionText,5);
        System.out.println("\nDecoded collection: \n" + decodedCollectionText);

        

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
