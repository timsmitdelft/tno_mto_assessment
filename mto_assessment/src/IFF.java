public class IFF {

    /**
     * Creates an IFF (identify Friend or Foe) object.
     */
    IFF(){}

    /**
     * Identify friend or foe based on radar data.
     * @param input the radar data.
     * @return Friend or Foe
     */
    public FF identifyFF(String input){
        int evenCount = 0;
        int oddCount = 0;

        String[] binaryArray = input.split(";");
        for (String binary : binaryArray) {
            // Only need to check last character to check if number is even or odd.
            char lastChar = binary.charAt(binary.length() - 1);

            // If last character is 0 it's always even.
            if (lastChar == '0') {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        if(oddCount > evenCount){
            return FF.FOE;
        }
        return FF.FRIEND;
    }
}

