package com.goit.gojavaonline;

/**
 * Created by home on 06.03.2016.
 */
public class File {

    protected String name;

    public File () {
        this.name = "newFile";
    }

    public File (String fileName) {
        this.name = fileName;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
