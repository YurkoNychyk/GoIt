/**
 * Created by home on 06.03.2016.
 */
public class TextFile extends File{
    public TextFile () {
        this.name = "newTextFile";
    }

    public TextFile (String fileName) {
        this.name = fileName;
    }

    public TextFile createTextFile (String fileName){
        return new TextFile(fileName);
    }
    public TextFile createTextFile(){
        return new TextFile();
    }
}
