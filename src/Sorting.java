import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Sorting extends BinarySort{
    
    public static void main(String[] args){
        BufferedReader reader ;
        BinarySort tree ;
        int sorting_kind = 0 ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Quicksort\n2-Bubblesort\n3-Binarysort\nChoose a sorting type : ");
        sorting_kind = scanner.nextInt();
        if(sorting_kind < 1 || sorting_kind > 3){
            System.out.println("Please enter 1||2||3 !! \nRestart Console");
            System.exit(1);
        }

        
        
        try{
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            Integer arr[] = {};
            while (line != null) {
                arr = addX(0, arr, Integer.parseInt(line)); 
                line = reader.readLine();
            }
            int n = arr.length;
            System.out.println("Array : " + java.util.Arrays.toString(arr));
            long start_time = System.currentTimeMillis();
            if(sorting_kind == 1){
                arr = quicksort(arr, 0, n-1);
                System.out.println("Sorted array : " + java.util.Arrays.toString(arr)); 
                System.out.println("Minimum element of array : " + arr[n-1]);
                long finish_time = System.currentTimeMillis();
                long cpu_time = finish_time - start_time ;
                System.out.println("CPU Time : " +cpu_time + "ms");
                
            }
            else if(sorting_kind == 2){
                arr = bubbleSort(arr);
                System.out.println("Sorted array : " + java.util.Arrays.toString(arr)); 
                System.out.println("Minimum element of array : " + arr[n-1]);
                long finish_time = System.currentTimeMillis();
                long cpu_time = finish_time - start_time ;
                System.out.println("CPU Time : " +cpu_time + "ms");
            }
            else if(sorting_kind == 3){
                ArrayList<Integer> arr_for_binarysort = new ArrayList<>();
                tree = new BinarySort();
                tree.treeins(arr);
                tree.inorderRec(tree.root,arr_for_binarysort);
                System.out.println("Sorted array : " + arr_for_binarysort);
                System.out.println("Minimum element array : " + arr_for_binarysort.get(n-1));
                long finish_time = System.currentTimeMillis();
                long cpu_time = finish_time - start_time ;
                System.out.println("CPU Time : " +cpu_time + "ms");
            }
            reader.close();
            }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
           
        
    }
    
   static Integer[] bubbleSort(Integer arr[]) 
    { 
        for(int i =0;i<arr.length;i++){
            for(int j = 0;j<(arr.length)-i-1;j++){
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    
                }
            }
        }
        return arr;
    } 
   
   static int partition(Integer arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);  
        for (int j=low; j<high; j++) 
        { 
            
            if (arr[j] < pivot) 
            { 
                i++; 
  
                
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
   
   static Integer[] quicksort(Integer arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            
            int pi = partition(arr, low, high);  
            quicksort(arr, low, pi-1); 
            quicksort(arr, pi+1, high); 
        } 
        return arr;
    } 
     public static Integer[] addX(int n, Integer arr[], int x) //adding item to array
    { 
        int i; 
  
         
        List<Integer> arrlist 
            = new ArrayList<Integer>( 
                Arrays.asList(arr)); 
  
         
        arrlist.add(x); 
  
        
        arr = arrlist.toArray(arr); 
  
        
        return arr; 
    } 
   
  
}

