import java.util.*;

public class Sorts{
    private long steps;
    
    public Sorts(){
        steps = 0;
    }

    public void bubbleSort(ArrayList <Integer> list){
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();

        for (int outer = 0; outer < list.size() - 1; outer++){
            for (int inner = 0; inner < list.size()-outer-1; inner++){
                if (list.get(inner) > list.get(inner + 1)){
                    int temp = list.get(inner);
                    list.set(inner, list.get(inner + 1));
                    list.set(inner + 1, temp);
                    steps += 4;
                }
                steps += 3;
            }
        }
    }

    public void selectionSort(ArrayList <Integer> list){
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();

        int min, temp;
        for (int outer = 0; outer < list.size() - 1; outer++){
            min = outer;
            for (int inner = outer + 1; inner < list.size(); inner++){
                if (list.get(inner) < list.get(min)) {
                    min = inner;
                }
                steps += 3;
            }
            temp = list.get(outer);
            list.set(outer, list.get(min));
            list.set(min, temp);
            steps += 4;
        }
    }

    public void insertionSort(ArrayList <Integer> list){
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();

        for (int outer = 1; outer < list.size(); outer++){
            int position = outer;
            int key = list.get(position);
            
            while (position > 0 && list.get(position - 1) > key){
                list.set(position, list.get(position - 1));
                position--;
                steps += 2;
            }
            list.set(position, key);
            steps += 4;
        }
    }

    public void mergeSort(ArrayList <Integer> list, int low, int high) {
        if(low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(list, low, middle);
            mergeSort(list, middle + 1, high);
            merge(list, low, middle, high);
        }
    }

    private void merge(ArrayList <Integer> list, int low, int middle, int high) {
        ArrayList <Integer> helper = new ArrayList <Integer> ();

        int i = low;
        int j = middle + 1;
        while (i <= middle || j <= high) {
            if (i > middle) {
                helper.add(list.get(j));
                j++;
                steps++;
            }
            else if (j > high){
                helper.add(list.get(i));
                i++;
                steps++;
            }
            else if (list.get(i) <= list.get(j)) {
                helper.add(list.get(i));
                i++;
                steps++;
            } else {
                helper.add(list.get(j));
                j++;
                steps++;
            }
            steps += 3;
        }
        int m = low;
        for(int l = 0; l < helper.size(); l++) {
            list.set(m, helper.get(l));
            m++;
        }
    }

    public long getStepCount(){
        return steps;
    }

    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}