public class Solution {
    public static byte getResult(String playingField, String race) throws Exception {

        byte[] playingFieldPoints = ReadData.read(playingField, race);
        byte solution = Dijstra.dijstra(playingFieldPoints);

        return (solution);
    }
}
