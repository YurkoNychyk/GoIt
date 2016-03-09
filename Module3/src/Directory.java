import java.util.ArrayList;

/**
 * Created by home on 06.03.2016.
 */
public class Directory {
   ArrayList<File> fileList = new ArrayList<>();

    public void addFile(AudioFile file){
        fileList.add(file);
    }
    public void addFile(ImageFile file){
        fileList.add(file);
    }
    public void addFile(TextFile file){
        fileList.add(file);
    }
}
