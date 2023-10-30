package utcb.sda5;

import utcb.sda_data.SDAArrayUtil;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = { 5, 3, -1, 53, 12, 21 };
        selectionSort(arr);
        System.out.println(SDAArrayUtil.toString(arr));
    }

    public static void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
