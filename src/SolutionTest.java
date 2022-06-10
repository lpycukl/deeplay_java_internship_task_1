import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getResult1() throws Exception {
        String playingField = "STWSWTPPTPTTPWPP";
        String race = "Human";
        assertEquals(10, Solution.getResult(playingField, race));
    }

    @Test
    void getResult2() throws Exception {
        String playingField = "STWSWTPPTPTTPWPP";
        String race = "Swamper";
        assertEquals(15, Solution.getResult(playingField, race));
    }

    @Test
    void getResult3() throws Exception {
        String playingField = "STWSWTPPTPTTPWPP";
        String race = "Woodman";
        assertEquals(12, Solution.getResult(playingField, race));
    }

    @Test
    void getResult4() throws Exception {
        String playingField = "SSSSWWWWTTTTPPPP";
        String race = "Woodman";
        assertEquals(13, Solution.getResult(playingField, race));
    }

    @Test
    void getResult5() throws Exception {
        String playingField = "SSSSPPSSSPSSSPPP";
        String race = "Human";
        assertEquals(6, Solution.getResult(playingField, race));
    }

    @Test
    void getException1() {
        String playingField = "SHOWSTOPPER";
        String race = "Human";
        assertThrows(Exception.class, () -> Solution.getResult(playingField, race));
    }

    @Test
    void getException2() {
        String playingField = "STWSWPPTPTTPWPP";
        String race = "Swampier";
        assertThrows(Exception.class, () -> Solution.getResult(playingField, race));
    }

    @Test
    void getException3() {
        String playingField = "STWSWPPTPWPP";
        String race = "Human";
        assertThrows(Exception.class, () -> Solution.getResult(playingField, race));
    }

}
