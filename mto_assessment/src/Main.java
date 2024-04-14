public class Main {
    public static void main(String[] args) {
        String radarFile = "./radar_data.csv";
        double PK = 0.8;
        int simulationTime = 20;
        int timeStep = 1;

        String setup = String.format("Simulating with input file: %s, PK ratio: %.2f, simulation duration: %d, time step: %d",
                radarFile, PK, simulationTime, timeStep);
        System.out.println(setup);

        Radar radar = new Radar(radarFile);
        IFF iff = new IFF();
        MissileLauncher launcher = new MissileLauncher(PK);

        run(simulationTime, timeStep, radar, iff, launcher);
    }

    public static void run(int simulationTime, int timeStep, Radar radar, IFF iff, MissileLauncher launcher){
        for (int time = 0; time < simulationTime; time+=timeStep){
            String scanOutput = radar.scan(time);
            FF ff = iff.identifyFF(scanOutput);
            if(ff == FF.FOE) {
                int missileId = launcher.launchMissile();
                boolean hit = launcher.checkMissileHit(missileId);
                printResult(time, true, true, hit);
                continue;
            }
            printResult(time, false, false, false);
        }
    }

    /**
     * Print simulation status
     * @param time current simulation time.
     * @param foe whether a foe was detected.
     * @param launch whether a missile was launched.
     * @param hit whether a target was hit.
     */
    public static void printResult(int time, boolean foe, boolean launch, boolean hit){
        String formattedString = String.format("Time: %d, foe detected : %s, missile launched : %s, foe hit %s",
                time,
                foe ? "YES" : "NO",
                launch ? "YES" : "NO",
                hit ? "YES" : "NO");

        System.out.println(formattedString);
    }
}