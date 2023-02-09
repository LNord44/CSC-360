public class SearchRecursion {
    public static void main(String[] args) {
        int[] list = {2, 6, 8, 9, 12, 15, 21, 24};
        System.out.println(search(list, 12, 0 , list.length - 1));
    }

    public static int search(int[] array, int key, int low, int high) {
        if (low > high) {
            return -low - 1;
        }
            int mid = (low + high) / 2;
            System.out.println("low=" + low + ",mid=" + mid + ",high=" + high);
            if (key < array[mid]) { return search(array, key, low, mid - 1); }
            else if (key == array[mid]) { return mid; }
            else { return search(array, key, mid + 1, high); }
    }

    }

