package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      for (int i = 1; i < array.length; i++ ) {
         T current = array[i];
         int j = i - 1;

         while (j >= 0 && current.compareTo(array[j]) < 0) {
            array[j + 1] = array[j];
            j--;
         }
         array[j+1] = current;
      }
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      for (int i = fromIndex; i < toIndex; i++ ) {
         T current = array[i];
         int j = i - 1;

         while (j >= 0 && current.compareTo(array[j]) < 0) {
            array[j + 1] = array[j];
            j--;
         }
         array[j+1] = current;
      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      insertionSort(array, 0, array.length, comparator);
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for (int i = fromIndex; i < toIndex; i++ ) {
         T current = array[i];
         int j = i - 1;

         while (j >= 0 && comparator.compare(current, array[j]) < 0) {
            array[j + 1] = array[j];
            j--;
         }
         array[j+1] = current;
      }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      for (int i = 0; i < array.length / 2; i++) {
         T key = array[i];
         int j = array.length - i - 1;
         array[i] = array[j];
         array[j] = key;
      }
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
       for (int i = fromIndex; i < (toIndex - fromIndex) / 2; i++) {
         T key = array[i];
         int j = toIndex - i - 1;
         array[i] = array[j];
         array[j] = key;
      }
   }




   ///////////////////////////////////////////
   // Binary search bw indices
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      toIndex--; //HUOM 1: indeksit ovat [fromIndex,toIndex) -- haku tehdään siis fromIndex..<toIndex, ei fromIndex...toIndex.
      int middle;
      
      while (fromIndex <= toIndex) {
         middle = fromIndex + (toIndex - fromIndex) / 2;
         if (aValue.compareTo(fromArray[middle]) < 0) {
            toIndex = middle - 1;
         }
         else if (aValue.compareTo(fromArray[middle]) > 0) {
            fromIndex = middle + 1;
         }
         else {
            return middle;
         }
      }
      return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      toIndex--; //HUOM 1: indeksit ovat [fromIndex,toIndex) -- haku tehdään siis fromIndex..<toIndex, ei fromIndex...toIndex.
      int middle;

      while (fromIndex <= toIndex) {
         middle = fromIndex + (toIndex - fromIndex) / 2;
         if (comparator.compare(aValue, fromArray[middle]) < 0) {
            toIndex = middle - 1;
         }
         else if (comparator.compare(aValue, fromArray[middle]) > 0) {
            fromIndex = middle + 1;
         }
         else {
            return middle;
         }
      }
      return -1;
   }


   
   public static <E extends Comparable<E>> void fastSort(E [] array) {
      fastSort(array, 0, array.length - 1);
   }



   public static <E extends Comparable<E>> void fastSort(E[] array, int fromIndex, int toIndex) {
      if (toIndex > fromIndex) {
         int middleIndex = (fromIndex + toIndex) / 2;

         fastSort(array, fromIndex, middleIndex);
         fastSort(array, middleIndex + 1, toIndex);

         merge(array, fromIndex, middleIndex, toIndex);
      }     
   }



   public static <E> void fastSort(E [] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length - 1, comparator);
   }



   public static <E> void fastSort(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      if (toIndex > fromIndex) {
         int middleIndex = (fromIndex + toIndex) / 2;

         fastSort(array, fromIndex, middleIndex, comparator);
         fastSort(array, middleIndex + 1, toIndex, comparator);

         merge(array, fromIndex, middleIndex, toIndex, comparator);
      }
   }


   // Comparator merge method
   @SuppressWarnings("unchecked")
   private static <E> void merge(E [] array, int fromIndex, int middleIndex, int toIndex, Comparator<E> comparator) {
      int leftArraySize = middleIndex - fromIndex + 1;
      int rightArraySize = toIndex - middleIndex;

      E [] leftArray = (E []) new Comparable[leftArraySize];
      E [] rightArray = (E []) new Comparable[rightArraySize];

      for (int i = 0; i < leftArraySize; i++) {
         leftArray[i] = array[fromIndex + i];
      }
      for (int j = 0; j < rightArraySize; j++) {
         rightArray[j] = array[middleIndex + 1 + j];
      }

      int i = 0;
      int j = 0; 
      int k = fromIndex; 

      // This loop runs until one of the arrays reaches the end
      while (i < leftArraySize && j < rightArraySize) {
         if (comparator.compare(leftArray[i], rightArray[j]) < 0) {
            array[k++] = leftArray[i++];
         } else {
            array[k++] = rightArray[j++];
         }
      }

      // These loops runs through the remaining elements
      while (i < leftArraySize) {
         array[k++] = leftArray[i++];
      }
      while (j < rightArraySize) {
         array[k++] = rightArray[j++];
      }
   }

      // Comparable merge method
      @SuppressWarnings("unchecked")
      private static <E extends Comparable<E>> void merge(E [] array, int fromIndex, int middleIndex, int toIndex) {
      int leftArraySize = middleIndex - fromIndex + 1;
      int rightArraySize = toIndex - middleIndex;

      E [] leftArray = (E []) new Comparable[leftArraySize];
      E [] rightArray = (E []) new Comparable[rightArraySize];
      
      for (int i = 0; i < leftArraySize; i++) {
         leftArray[i] = array[fromIndex + i];
      }
      for (int j = 0; j < rightArraySize; j++) {
         rightArray[j] = array[middleIndex + 1 + j];
      }


      int i = 0;
      int j = 0; 
      int k = fromIndex; 

      // This loop runs until one of the arrays reaches the end
      while (i < leftArraySize && j < rightArraySize) {
         if (leftArray[i].compareTo(rightArray[j]) < 0) {
            array[k++] = leftArray[i++];
         } else {
            array[k++] = rightArray[j++];
         }
      }

      // These loops runs through the remaining elements
      while (i < leftArraySize) {
         array[k++] = leftArray[i++];
      }
      while (j < rightArraySize) {
         array[k++] = rightArray[j++];
      }
   }
}
