package module8;

import module3.MusicalInstrument;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by home on 23.03.2016.
 */
public class CollectionPrint  {

    public static String printOutMusicalInstrument(Collection<MusicalInstrument> collection) {
        Iterator iter = collection.iterator();
        StringBuffer outputStringBuffer = new StringBuffer();
        while (iter.hasNext()){
            outputStringBuffer.append(iter.next().toString());
            outputStringBuffer.append("\n");
        }
        return outputStringBuffer.toString();
    }

}
