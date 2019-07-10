package pl.dpawlak.operations;

import pl.dpawlak.Command;
import pl.dpawlak.CommandCreator;

public class RgsOperation implements Operation {

    @Override
    public Command createCommandWith(CommandCreator creator) {
        return creator.createCommandFromOperation(this);
    }
}
