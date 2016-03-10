package com.goit.gojavaonline;

/**
 * Created by home on 06.03.2016.
 */
public class Module3 {
    public static void main (String[] args){
        Directory dir1 = new Directory();

        dir1.addFile(new AudioFile("AudioFile1"));
        dir1.addFile(new ImageFile("ImageFile1"));
        dir1.addFile(new TextFile("TextFile1"));
        dir1.addFile(new AudioFile("AudioFile2"));


        System.out.println("This is " + dir1.fileList.get(0).name);
        System.out.println("This is " + dir1.fileList.get(1).name);
        System.out.println("This is " + dir1.fileList.get(2).name);
        System.out.println("This is " + dir1.fileList.get(3).name);

        RoseBush bush1 = new RoseBush();
        bush1.rose1 = new Rose();

        System.out.println( bush1.rose1.hashCode());

        Guitar gibsonSg = new Guitar();
        gibsonSg.name = "Gibson Sg";
        gibsonSg.price=100000.0f;

        MusicalInstrumentsShop myShop = new MusicalInstrumentsShop();
        myShop.priceList.put(gibsonSg.name, gibsonSg.price);

    }
}
