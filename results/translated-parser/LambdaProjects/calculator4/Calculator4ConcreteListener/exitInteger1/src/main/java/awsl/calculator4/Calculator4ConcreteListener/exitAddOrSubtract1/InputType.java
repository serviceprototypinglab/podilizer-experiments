package awsl.calculator4.Calculator4ConcreteListener.exitAddOrSubtract1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import calculator4.Calculator4Parser.AddOrSubtractContext;
import calculator4.Calculator4Parser.ArgContext;
import calculator4.Calculator4Parser.AssignmentContext;
import calculator4.Calculator4Parser.IntegerContext;
import calculator4.Calculator4Parser.MultOrDivContext;
import calculator4.Calculator4Parser.PrintContext;
import calculator4.*;

public class InputType {

    public Stack<Integer> stack = new Stack<Integer>();

    public Map<String, Integer> sym = new HashMap<String, Integer>();

    public AddOrSubtractContext ctx;

    public InputType() {
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void setSym(Map<String, Integer> sym) {
        this.sym = sym;
    }

    public Map<String, Integer> getSym() {
        return sym;
    }

    public void setCtx(AddOrSubtractContext ctx) {
        this.ctx = ctx;
    }

    public AddOrSubtractContext getCtx() {
        return ctx;
    }

    public InputType(Stack<Integer> stack, Map<String, Integer> sym, AddOrSubtractContext ctx) {
        this.stack = stack;
        this.sym = sym;
        this.ctx = ctx;
    }
}
