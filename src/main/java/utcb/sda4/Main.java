package utcb.sda4;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 10, 21, 35, 4, 101 };

        System.out.println("Crescator: ");
        bubbleSort(arr, false);
        print(arr);
        System.out.println("Descrescator: ");
        bubbleSort(arr, true);
        print(arr);
    }

    public static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String numbers = "";
        for (int j : arr) {
            sb.append(j);
            sb.append(", ");
        }
        sb.append("]");

        sb.replace(sb.length() - 3, sb.length() - 1, "");
        System.out.println(sb);
    }

    public static void bubbleSort(int[] items, boolean desc) {
        int iterations = 0;
        for (int i = items.length - 1; i >= 0; i--) {
            boolean modified = false;
            for (int j = 0; j < i; j++) {
                boolean condition;
                if (desc) {
                    condition = items[j] < items[j + 1];
                } else {
                    condition = items[j] > items[j + 1];
                }
                if (condition) {
                    modified = true;
                    int temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
            iterations++;
            if (!modified) {
                break;
            }
        }

        System.out.printf("Did %d iterations%n", iterations);
    }
}
