package awsl.com.company.BoxContainer.totalVolume;

import java.util.ArrayList;
import com.company.*;

public class InputType {

    public ArrayList<Box> boxes = new ArrayList<>();

    public InputType() {
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public InputType(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }
}
