import java.util.Arrays;

public class Sorting {

    // BubbleSort:  *** Não deve ser incluso nos testes
    public void bubble(int x[]) {
        int aux, j, i;
        int n = x.length;
        boolean trocou = true;
        for(i = 0; i < n - 1 && trocou == true; i++) {
            trocou = false;
            for(j = 0; j < (n - i - 1); j++){
                if (x[j] > x[j + 1]) {
                    trocou = true;
                    aux = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = aux;
                }
            }
        }
    }

    // SimpleSort:  *** Não será usado nos testes
    public void simple(int[] array){
        int k, i;
        int tamanho_array = array.length;
        for (k = 1; k < tamanho_array; k++){
            int y = array[k];
            for (i = k -1; i >= 0 && y < array[i]; i--)
                array[i + 1] = array[i];
            array[i + 1] = y;
        }
    }

    // Obrigatório - QuickSort:
    private void swap (int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    private void quick(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quick(arr, low, j);
        if (high > i)
            quick(arr, i, high);
    }
    public void quick(int[] array){
        int n = array.length - 1;
        quick(array, 0, n);
    }

    // Obrigatório - ShellSort:
    public void shell(int[] array){
        int incremento, j, k, span, y;
        int[] vetor = array;
        for(incremento = 0; incremento < array.length; incremento++){
            span = array[incremento];
            for(j = span; j < vetor.length; j++) {
                y = vetor[j];
                for(k = j - span; k >= 0 && y < vetor[k]; k -= span)
                    vetor[k + span] = vetor[k];
                vetor[k+span] = y;
            }
        }
    }

    // Obrigatório - HeapSort:
    private void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    public void heap(int arr[]){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // BitonicSort (incluso nos testes):
    private void compAndSwap(int a[], int i, int j, int dir) {
        if ( (a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    private void bitonicMerge(int a[], int low, int cnt, int dir) {
        if (cnt>1) {
            int k = cnt/2;
            for (int i=low; i<low+k; i++)
                compAndSwap(a,i, i+k, dir);
            bitonicMerge(a,low, k, dir);
            bitonicMerge(a,low+k, k, dir);
        }
    }
    private void bitonicSort(int a[], int low, int cnt, int dir) {
        if (cnt>1) {
            int k = cnt/2;
            bitonicSort(a, low, k, 1);
            bitonicSort(a,low+k, k, 0);
            bitonicMerge(a, low, cnt, dir);
        }
    }
    public void bitonic(int a[]) {
        bitonicSort(a, 0, a.length, 1);
    }

    // RadixSort (incluso nos testes):
    private int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    private void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    private void radixsort(int arr[], int n) {
        int m = getMax(arr, n);
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    public void radix(int[] arr){
        int n = arr.length;
        radixsort(arr, n);
    }

    // PancakeSort:
    private void flip(int arr[], int i) {
        int temp, start = 0;
        while (start < i) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
    private int findMax(int arr[], int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }
    private int pancakeSort(int arr[], int n) {
        for (int curr_size = n; curr_size > 1; --curr_size) {
            int mi = findMax(arr, curr_size);
            if (mi != curr_size-1) {
                flip(arr, mi);
                flip(arr, curr_size-1);
            }
        }
        return 0;
    }
    public void pancake(int[] arr){
        int n = arr.length;
        pancakeSort(arr,n);
    }
}