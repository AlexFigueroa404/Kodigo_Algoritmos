package com.kodigo.sortsearch.sorting;

public class Sort {


    public void bubbleSort(int[] arr) {

        boolean swapped = false; // variable para saber si se hizo un intercambio
        for (int i = 0; i < arr.length - 1; i++) { // hasta n - 1 iteraciones porque el último elemento ya estará ordenado
            for (int j = 0; j < arr.length - i - 1; j++) {
                /*
                 * Se resta i porque en cada iteración el elemento más grande se coloca al final por lo que no es necesario
                 * comparar los elementos que ya están ordenados
                 * */
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // si no se hizo ningún intercambio, el arreglo ya está ordenado
            if (!swapped) {
                break;
            }
        }
    }

    public void selectionSort(int[] arr) {

        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i; // se asume que el primer elemento es el menor y se actualiza si se encuentra un valor menor
            for (int j = i + 1; j < arr.length; j++) {
                /*
                 * j = i + 1 porque se entiende que el valor anterior ya esta "ordenado"
                 *
                 * */
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) { // si el valor mínimo no es el mismo que el valor actual, se intercambian
                swap(arr, i, minIndex);
            }
        }


    }

    public void insertionSort(int[] arr) {

        int temp, j;

        for (int i = 1; i < arr.length; i++) {

            temp = arr[i];
            j = i;

            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }

    }

    public void mergeSort(int[] arr, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            mergeSort(arr, lowerBound, mid);
            mergeSort(arr, mid + 1, upperBound);
            merge(arr, lowerBound, mid, upperBound); // metodo auxiliar para mezclar los arreglos
        }
    }

    // metodo auxiliar para intercambiar dos elementos
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    private void merge(int[] arr, int lowerBound, int mid, int upperBound) {
        int[] merged = new int[upperBound - lowerBound + 1];
        int indexA = lowerBound;
        int indexB = mid + 1;
        int indexMerged = 0;

        while (indexA <= mid && indexB <= upperBound) {
            if (arr[indexA] < arr[indexB]) {
                merged[indexMerged++] = arr[indexA++]; // se copia el valor de A y se incrementa el índice usando post-incremento
            } else {
                merged[indexMerged++] = arr[indexB++];
            }
        }

        while (indexA <= mid) {
            merged[indexMerged++] = arr[indexA++];
        }

        while (indexB <= upperBound) {
            merged[indexMerged++] = arr[indexB++];
        }

        // copiar valores de merged al arreglo original

        int j = lowerBound;
        for (int i = 0; i < merged.length; i++) {
            arr[j++] = merged[i];
        }

    }
}
