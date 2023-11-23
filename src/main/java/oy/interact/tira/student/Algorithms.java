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
      fastSort(array, 0, array.length);
   }



   @SuppressWarnings("unchecked")
   public static <E extends Comparable<E>> void fastSort(E[] array, int fromIndex, int toIndex) {
      if (array.length <= 1) {
         return;
      }

      int middleIndex = (toIndex - fromIndex) / 2;
      Object[] leftArray = new Object[middleIndex];
      Object[] rightArray = new Object[array.length - middleIndex];

      System.arraycopy(array, 0, leftArray, 0, leftArray.length);
      System.arraycopy(array, middleIndex, rightArray, 0, rightArray.length);

      fastSort((E[]) leftArray, 0, middleIndex);
      fastSort((E[]) rightArray, 0, array.length - middleIndex - 1);

      merge(array, (E[])leftArray, (E[])rightArray);
   }



   public static <E> void fastSort(E [] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length, comparator);
   }



   @SuppressWarnings("unchecked")
   public static <E> void fastSort(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      if (toIndex - fromIndex < 0) {
         return;
      }

      int middleIndex = (toIndex - fromIndex) / 2;
      Object[] leftArray = new Object[middleIndex];
      Object[] rightArray = new Object[array.length - middleIndex];

      System.arraycopy(array, 0, leftArray, 0, leftArray.length);
      System.arraycopy(array, middleIndex, rightArray, 0, rightArray.length);

      fastSort((E[]) leftArray, 0, middleIndex, comparator);
      fastSort((E[]) rightArray, 0, array.length - middleIndex - 1, comparator);

      merge(array, (E[])leftArray, (E[])rightArray, comparator);
   }



   // Comparator merge method
   private static <E> void merge(E [] array, E [] leftArray, E [] rightArray, Comparator<E> comparator) {
      int i = 0; // Left array index
      int j = 0; // Right array index
      int k = 0; // Merged array index

      while (i < leftArray.length && j < rightArray.length) {
         if (comparator.compare(leftArray[i], rightArray[j]) < 0) {
            array[k++] = leftArray[i++];
         }
         else {
            array[k++] = rightArray[j++];
         }
      }


      while (i < leftArray.length) {
         array[k++] = leftArray[i++];
      }
      while (j < rightArray.length) {
         array[k++] = rightArray[j++];
      }
      
   }

      // Comparable merge method
      private static <E extends Comparable<E>> void merge(E [] array, E [] leftArray, E [] rightArray) {
      int i = 0; // Left array index
      int j = 0; // Right array index
      int k = 0; // Merged array index

      while (i < leftArray.length && j < rightArray.length) {
         if (leftArray[i].compareTo(rightArray[j]) < 0) {
            array[k++] = leftArray[i++];
         }
         else {
            array[k++] = rightArray[j++];
         }
      }


      while (i < leftArray.length) {
         array[k++] = leftArray[i++];
      }
      while (j < rightArray.length) {
         array[k++] = rightArray[j++];
      }
      
   }

}
