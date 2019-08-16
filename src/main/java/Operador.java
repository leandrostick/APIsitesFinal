public class Operador<T> {

    public static <T extends  Comparable<T>> T min(T[] arr){
        T aux = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1].compareTo(aux) < 0) {
                aux = arr[i + 1];
            }
        }
        return aux;
    }

    public static <T extends  Comparable<T>> T max(T[] arr){
        T aux = arr[0];
        for(int i= 1; i<arr.length-1; i++){
            if(arr[i+1].compareTo(aux)>0){
                aux = arr[i+1];
            }
        }
        return aux;
    }

    public static <T extends  Comparable<T>> int exists(T[] arr, T t){
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public static <T extends  Comparable<T>> T[] ordenar(T[] arr) {
        T aux;
        for(int i=0; i<arr.length - 1; i++){
            for(int j=0;j<arr.length - i - 1; j++){
                if(arr[j+1].compareTo(arr[j])<0){
                    aux = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
        return arr;
    }


}
