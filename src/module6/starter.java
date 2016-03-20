package module6;

import module3.*;
import module4.ConsoleReader;

import java.util.*;

/**
 * Created by home on 17.03.2016.
 */
public class starter {
    public static void main(String[] args) {
        MusicalInstrumentsShop muztorg = new MusicalInstrumentsShop();
        Map <String,Integer> order = new HashMap<String, Integer>();
        //making list of supplied to shop instruments
        ArrayList<MusicalInstrument> instrumentSupplyList = new ArrayList<>();

        for (int i=0; i<5; i++)  {
            instrumentSupplyList.add(new Piano("piano"));
        }

        for (int i=0; i<3; i++)  {
            instrumentSupplyList.add(new Guitar("guitar"));
        }

        for (int i=0; i<1; i++)  {
            instrumentSupplyList.add(new Tube("tube"));
        }

        //making instruments supply to shop
        muztorg.makeInstrumentsSupply(instrumentSupplyList);

        order = muztorg.makeOrder();
       /* for (MusicalInstrument instruments: muztorg.getAvaibleInstruments()
             ) {
            System.out.println(instruments.getType() +":"+ instruments.getId());
        }*/

        muztorg.prepareInstruments(order);


    }

}
