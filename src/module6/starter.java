package module6;

import module3.*;
import module4.ConsoleReader;

import java.util.*;

/**
 * Created by home on 17.03.2016.
 */
public class Starter {
    public static void main(String[] args) {
        MusicalInstrumentsShop muztorg = new MusicalInstrumentsShop();
        Map <String,Integer> order = new HashMap<String, Integer>();

        //making list of instruments which will be added to shop
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

        //adding instruments to our shops list
        muztorg.makeInstrumentsSupply(instrumentSupplyList);

        //printing shop contense
        for (MusicalInstrument instrument:muztorg.getAvaibleInstruments()
             ) {
            System.out.println(instrument.getType() + " id: " + instrument.getId());
        }
        //adding instruments to order user input
        order = muztorg.makeOrder();

        try{
            List<MusicalInstrument> suppliedInstruments = muztorg.prepareInstruments(order);
            muztorg.removeInstrument(suppliedInstruments);
        }

        catch (InvalidInstrumentName e){
            System.err.println(e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        //printing remaining instruments
        for (MusicalInstrument instrument:muztorg.getAvaibleInstruments()
                ) {
            System.out.println(instrument.getType() + " id: " + instrument.getId());
        }

    }

}
