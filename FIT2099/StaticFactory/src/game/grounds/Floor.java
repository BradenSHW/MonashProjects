package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.enumerations.Ability;
import game.enumerations.Status;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Kok Heng Ng
 */
public class Floor extends Ground {
    public Floor() {
        super('_');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if(actor.hasCapability(Ability.CAN_ENTER_SPACESHIP)){
            return true;
        }
        return false;
    }
}
