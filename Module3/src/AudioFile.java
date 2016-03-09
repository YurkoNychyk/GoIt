/**
 * Created by home on 06.03.2016.
 */
public class AudioFile extends File{
    public AudioFile() {
        this.name = "newAudioFile";
    }

    public AudioFile (String fileName) {
        this.name = fileName;
    }
    public AudioFile createAudioFile (String fileName){
        return new AudioFile(fileName);
    }
    public AudioFile createAudioFile(){
        return new AudioFile();
    }
}
