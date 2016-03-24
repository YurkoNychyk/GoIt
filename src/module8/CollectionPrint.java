package module8;

import module3.MusicalInstrument;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by home on 23.03.2016.
 */
public class CollectionPrint  {
    public static void printOutMusicalInstrument(Collection<MusicalInstrument> collection) {
        Iterator iter = collection.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }

}
