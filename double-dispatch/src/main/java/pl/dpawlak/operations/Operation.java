package pl.dpawlak.operations;

import pl.dpawlak.Command;
import pl.dpawlak.CommandCreator;

public interface Operation {

    // this method is needed for double-dispatch
    Command createCommandWith(CommandCreator creator);

    // base class does not have the proper type at compile time
//    default Command createACommandWith(CommandCreator creator) {
//        return creator.createCommandFromOperation(this);
//    }
}
