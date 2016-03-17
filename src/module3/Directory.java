package module3;
import java.util.List;

/**
 * Created by home on 06.03.2016.
 */
public class Directory {
    private List<AudioFile> textFileList;
    private List<AudioFile> audioFileList;
    private List<AudioFile> imageFileList;

    public List<AudioFile> getTextFileList() {
        return textFileList;
    }

    public void setTextFileList(List<AudioFile> textFileList) {
        this.textFileList = textFileList;
    }

    public List<AudioFile> getAudioFileList() {
        return audioFileList;
    }

    public void setAudioFileList(List<AudioFile> audioFileList) {
        this.audioFileList = audioFileList;
    }

    public List<AudioFile> getImageFileList() {
        return imageFileList;
    }

    public void setImageFileList(List<AudioFile> imageFileList) {
        this.imageFileList = imageFileList;
    }
}
