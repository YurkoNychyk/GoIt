/**
 * Created by home on 06.03.2016.
 */
public class ImageFile extends File{
    public ImageFile() {
        this.name = "newImageFile";
    }

    public ImageFile (String fileName) {
        this.name = fileName;
    }

    public ImageFile createImageFile (String fileName){
        return new ImageFile(fileName);
    }
    public ImageFile createImageFile(){
        return new ImageFile();
    }
}
