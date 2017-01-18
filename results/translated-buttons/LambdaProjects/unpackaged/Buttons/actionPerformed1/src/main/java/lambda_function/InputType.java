package lambda_function;

import java.awt.*;
import java.awt.event.*;
import unpackaged.*;

public class InputType {

    public ActionEvent event;

    public InputType() {
    }

    public void setEvent(ActionEvent event) {
        this.event = event;
    }

    public ActionEvent getEvent() {
        return event;
    }

    public InputType(ActionEvent event) {
        this.event = event;
    }
}
