package pl.dpawlak;

import pl.dpawlak.operations.AmsOperation;
import pl.dpawlak.operations.FusOperation;
import pl.dpawlak.operations.PvsOperation;
import pl.dpawlak.operations.RgsOperation;

public class DDCommandCreator implements CommandCreator {

    @Override
    public Command createCommandFromOperation(FusOperation o) {
        return CommandsImpl::fusCommand;
    }

    @Override
    public Command createCommandFromOperation(PvsOperation pvsOperation) {
        return CommandsImpl::pvsCommand;
    }

    @Override
    public Command createCommandFromOperation(RgsOperation rgsOperation) {
        return CommandsImpl::rgsCommand;
    }

    @Override
    public Command createCommandFromOperation(AmsOperation amsOperation) {
        return CommandsImpl::amsCommand;
    }
}
