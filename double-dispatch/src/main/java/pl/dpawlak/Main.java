package pl.dpawlak;

import pl.dpawlak.operations.*;

import java.util.function.Consumer;

public class Main {

    private final DDCommandCreator commandCreator = new DDCommandCreator();

    public static void main(String[] args) {
        Main main = new Main();
        Consumer<Operation> handleFun = main::handleOperation;
        handleFun.accept(new FusOperation());
        handleFun.accept(new PvsOperation());
        handleFun.accept(new RgsOperation());
        handleFun.accept(new AmsOperation());
    }

    // Standard multiple-instanceof handler
    private void handleOperation(Operation operation) {
        Command command;
        if (operation instanceof FusOperation) {
            command = CommandsImpl::fusCommand;
        } else if (operation instanceof PvsOperation) {
            command = CommandsImpl::pvsCommand;
        } else if (operation instanceof RgsOperation) {
            command = CommandsImpl::rgsCommand;
        } else if (operation instanceof AmsOperation) {
            command = CommandsImpl::amsCommand;
        } else {
            throw new IllegalStateException("unknown operation type");
        }
        command.action();
    }

    // Double Dispatch handler
    private void handleOperationDD(Operation operation) {
        Command command = operation.createCommandWith(commandCreator);
        command.action();
    }
}
