package awsl.com.company.BoxContainer.addBox1;

import java.util.ArrayList;
import com.company.*;

public class OutputType {

    public ArrayList<Box> boxes = new ArrayList<>();

    public OutputType() {
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public OutputType(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }
}
