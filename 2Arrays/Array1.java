public class Array1 extends Thread {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public void array1() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        method(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    public void array2() {
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        new Thread(String.valueOf(method(arr1))).start();
        new Thread(String.valueOf(method(arr2))).start();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }


    public synchronized static float[] method(float[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr1;
    }


}
