import java.util.ArrayList;

public class Dijstra {
    public static byte dijstra(byte[] playingFieldPoints) {
        //данную задачу рассматривал, как задачу нахождения кратчейшего пути в графе.
        // Использовал усовершенствованный(под условия задачи) алгоритм Дейкстры.

        byte[] dist = new byte[16]; //массив с расстояниями до вершин
        dist[0] = 0;
        for (byte i = 1; i < 16; i++) {
            dist[i] = 127; //
        }

        ArrayList<Integer> listMinIndex = new ArrayList<>(); //список вершин на релаксацию
        listMinIndex.add(0);
        //заметил, что на данном игровом поле(4 на 4) перемещения вверх и влево бессмысленны,
        //так что для каждой вершины релаксировал в нижнюю (если есть) и правую (если есть) вершину.
        while (listMinIndex.size() != 0) { //выполняем, пока есть вершины на релоксацию.
            /* если учитывать, что будем рассматривать перемещение только вниз и вправо, то в каждую вершину
            можно попасть максимум 2 раза(не учитывая, что в некоторые только сверху или справа).
            Следовательно, примерное количество прохождений по циклу будет 2n, где n-количество вершин,
            В нашем случае n=16. Итого приблизительно 32 прохода,
            что существенно меньше стандартной сложности алгоритма Дейкстры(n^2) */

            Integer minIndex = listMinIndex.get(0);
            listMinIndex.remove(0);

            //Уточняем расстоние до правой клетки от текущей
            if (minIndex != 3 && minIndex != 7 && minIndex != 11 && minIndex != 15) { //наличие правой клетки
                int newDistRight = dist[minIndex] + (playingFieldPoints[minIndex + 1]);
                if (dist[minIndex + 1] > (byte) newDistRight) { //проверка, что новое расстояние меньше, чем текущее
                    dist[minIndex + 1] = (byte) newDistRight;
                    listMinIndex.add(minIndex + 1);
                }
            }
            //Уточняем расстоние до нижней клетки от текущей
            if (minIndex < 12) { //наличие нижней клетки
                int newDistDown = dist[minIndex] + (playingFieldPoints[minIndex + 4]);
                if (dist[minIndex + 4] > (byte) newDistDown) { //проверка, что новое расстояние меньше, чем текущее
                    dist[minIndex + 4] = (byte) newDistDown;
                    listMinIndex.add(minIndex + 4);
                }
            }

        }
        //возвращаем расстояние, указанное 16ым в массиве( соответсвует нижней правой клетке)
        return (dist[15]);
    }
}

