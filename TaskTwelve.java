import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TaskTwelve {
    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void swap(List<Integer> list, int x, int y) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    public static void genAll(int[] elements, int i,
                              Consumer<int[]> callback) {
        int j;
        if (i == elements.length - 1)
            callback.accept(elements);
        else {
            for (j = i; j <= elements.length - 1; j++) {
                swap(elements, i, j);
                genAll(elements, i + 1, callback);
                swap(elements, i, j);
            }
        }
    }

    public static void genAll(List<Integer> elements, int i,
                              Consumer<List<Integer>> callback) {
        int j;
        if (i == elements.size() - 1)
            callback.accept(elements);
        else {
            for (j = i; j <= elements.size() - 1; j++) {
                swap(elements, i, j);
                genAll(elements, i + 1, callback);
                swap(elements, i, j);
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 512, 12);
        Consumer<List<Integer>> printer = printedList -> System.out.println(printedList.toString());
        genAll(list, 0, printer);
    }
}