package pl.dpawlak;

import pl.dpawlak.operations.AmsOperation;
import pl.dpawlak.operations.FusOperation;
import pl.dpawlak.operations.PvsOperation;
import pl.dpawlak.operations.RgsOperation;

// this interface is needed for double-dispatch
public interface CommandCreator {

    Command createCommandFromOperation(FusOperation fusOperation);

    Command createCommandFromOperation(PvsOperation pvsOperation);

    Command createCommandFromOperation(RgsOperation rgsOperation);

    Command createCommandFromOperation(AmsOperation amsOperation);
}
