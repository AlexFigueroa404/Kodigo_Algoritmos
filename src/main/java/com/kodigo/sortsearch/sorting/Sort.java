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

    public void insertionSort() {

    }

    public void mergeSort() {

    }

    // metodo auxiliar para intercambiar dos elementos
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
