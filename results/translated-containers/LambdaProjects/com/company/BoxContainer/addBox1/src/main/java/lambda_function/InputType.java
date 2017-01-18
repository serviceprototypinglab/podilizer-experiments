package lambda_function;

import java.util.ArrayList;
import com.company.*;

public class InputType {

    public ArrayList<Box> boxes = new ArrayList<>();

    public Box box;

    public InputType() {
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Box getBox() {
        return box;
    }

    public InputType(ArrayList<Box> boxes, Box box) {
        this.boxes = boxes;
        this.box = box;
    }
}
