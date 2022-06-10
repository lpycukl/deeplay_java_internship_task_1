public class ReadData {
    public static byte[] read(String playingField, String race) throws Exception {

        byte[] playingFieldPoints = new byte[16];
        /*
        для работы алгоритма рассмотрим игровое поле, как массив очков перемещения
         0  1   2   3  индексы массива соотвественно клеткам игрового поля
         4  5   6   7
         8  9   10  11
         12 13  14  15
        */
        try {
            switch (race) {

                case "Human":
                    for (byte i = 0; i < 16; i++) {
                        switch (playingField.charAt(i)) {
                            case ('S') -> playingFieldPoints[i] = 5;
                            case ('T') -> playingFieldPoints[i] = 3;
                            case ('W') -> playingFieldPoints[i] = 2;
                            case ('P') -> playingFieldPoints[i] = 1;
                            default -> throw new Exception();
                        }
                    }
                    break;

                case "Swamper":
                    for (byte i = 0; i < 16; i++) {
                        switch (playingField.charAt(i)) {
                            case ('S'), ('W'), ('P') -> playingFieldPoints[i] = 2;
                            case ('T') -> playingFieldPoints[i] = 5;
                            default -> throw new Exception();
                        }
                    }
                    break;

                case "Woodman":
                    for (byte i = 0; i < 16; i++) {
                        switch (playingField.charAt(i)) {
                            case ('S'), ('W') -> playingFieldPoints[i] = 3;
                            case ('T'), ('P') -> playingFieldPoints[i] = 2;
                            default -> throw new Exception();
                        }
                    }
                    break;

                default:
                    throw new Exception("неверные данные");

            }
        } catch (Exception e) {
            throw new Exception("неверные данные");
        }
        return (playingFieldPoints);
    }
}
