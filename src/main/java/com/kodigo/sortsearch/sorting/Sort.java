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
