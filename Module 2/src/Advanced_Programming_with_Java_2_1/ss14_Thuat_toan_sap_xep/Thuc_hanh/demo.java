package Advanced_Programming_with_Java_2_1.ss14_Thuat_toan_sap_xep.Thuc_hanh;

public class demo {
    public static void main(String[] args) {
//        int[] arr = {8,6,2,7,9,6,4,3};
//        for (int i = 0; i < arr.length - 1 ; i++){
//            for (int j = i + 1; j < arr.length; j++){
//                if (arr[i] < arr[j]){
//                    int tempt = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tempt;
//                }
//            }
//        }
//        for (int arrs: arr){
//            System.out.println(arrs);
//        }
//
//        int[] arr = {8,6,2,7,9,6,4,3};
//        for (int i = 0; i < arr.length - 1 ; i++){
//            for (int j = arr.length - 1; j > i; j--){
//                if(arr[j] < arr[j - 1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = temp;
//                }
//            }
//        }
//
//        for (int arrs: arr){
//            System.out.println(arrs);
//        }


//        int[] arr = {8,6,2,7,9,6,4,3};
//        for (int i = 0; i < arr.length - 1; i++){
//            for (int j = 0; j < arr.length - 1 - i; j++){
//                if(arr[j] > arr[j + 1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        for (int arrs: arr){
//            System.out.println(arrs);
//        }


        int pos,x;
        int[] arr = {8,6,2,7,9,6,4,3};

        for(int i = 1; i < arr.length; i++){
            x = arr[i];
            pos = i;
            while (pos > 0 && x < arr[pos - 1]){
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
        }

        for (int arrs: arr){
            System.out.println(arrs);
        }






    }
}
