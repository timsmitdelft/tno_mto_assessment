import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Radar {

    /**
     * Array to store the radar data.
     */
    private String[] radar_data_array;

    /**
     * Creates a Radar object
     * @param filePath the location where the radar data is stored
     */
    Radar(String filePath){
        readCsv(filePath);
    }

    /**
     * Reads the input csv and stores it in array, line by line.
     *
     * @param  filePath the location of the input csv
     */
    private void readCsv(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            List<String> radar_data_list = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                radar_data_list.add(line);
            }
            radar_data_array = radar_data_list.toArray(new String[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scans the radar data.
     *
     * @param  time the current time in the simulation.
     * @return the output of the radar.
     */
    public String scan(int time){
        return radar_data_array[time];
    }
}
