package awsl.com.company.BoxContainer.totalVolume;

import java.util.ArrayList;
import com.company.*;

public class OutputType {

    public ArrayList<Box> boxes = new ArrayList<>();

    public int totalVolumeResult;

    public OutputType() {
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setTotalVolumeResult(int totalVolumeResult) {
        this.totalVolumeResult = totalVolumeResult;
    }

    public int getTotalVolumeResult() {
        return totalVolumeResult;
    }

    public OutputType(ArrayList<Box> boxes, int totalVolumeResult) {
        this.boxes = boxes;
        this.totalVolumeResult = totalVolumeResult;
    }
}
