import java.util.ArrayList;
import java.util.List;

public class MissileLauncher {
    /**
     * The probability of kill ratio.
     */
    double PK;

    /**
     * The results of the launched missiles.
     */
    List<Boolean> missileResults = new ArrayList<>();

    /**
     * Create a missile launcher object.
     * @param PK the probability of kill ratio, between 0 and 1.
     */
    public MissileLauncher(double PK) {
        this.PK = PK;
    }

    /**
     * Launches a missile.
     * @return the id of the missile
     */
    public int launchMissile(){
        double random = Math.random();
        if(random > PK){
            missileResults.add(false);
        }
        else{
            missileResults.add(true);
        }

        return missileResults.size() - 1;
    }

    /**
     * Check the result of a specific missile.
     * @param missileId the id of the missile.
     * @return whether the missile hit the target.
     */
    public boolean checkMissileHit(int missileId){
        return missileResults.get(missileId);
    }
}
