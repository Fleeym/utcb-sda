package utcb.sda9;

// Shellsort

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] arr = {36,56,31,21,101,56,41,2,10,25,15,19,17};
        System.out.printf("Stare initiala: %s\n", Arrays.toString(arr));
        shellSort(arr);
        System.out.printf("Stare finala: %s\n", Arrays.toString(arr));
        long[] arr2 = {36,56,31,21,101,56,41,2,10,25,15,19,17};
        System.out.printf("Partitia are loc la pos %d\n", partition(arr2, 50));
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(long[] arr, long pivot) {
        int left = 0;
        int right = arr.length - 1;

        while (true) {
            while(left < arr.length - 1 && arr[left] < pivot) {
                left++;
            }

            while(right > 0 && arr[right] > pivot) {
                right--;
            }

            if (left >= right) {
                break;
            } else {
                long temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return left;
    }

    public static void shellSort(long[] arr) {
        // Folosim secventa lui Knuth
        // Aceasta consta in intervale de forma 3h + 1

        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        System.out.printf("Plecam de la h = %d\n", h);
        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                long temp = arr[i];
                int j = i;
                System.out.println(Arrays.toString(arr));

                while (j > h - 1 && arr[j - h] >= temp) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                if (j != i) {
                    arr[j] = temp;
                }
            }
            h = (h - 1) / 3;
            System.out.printf("h = %d\n", h);
        }
    }
}
