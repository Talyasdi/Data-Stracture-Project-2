import java.util.*;

import static java.lang.System.currentTimeMillis;

public class MyTest {
     public static void main(String[] args) {
         //first n: 5000009
         //sec n: 9500018
         HashTableElement[] tb = new HashTableElement[5000009];
         for (int i=0; i< 5000009; i++) {
             Random rnd = new Random();
             long b_i = rnd.nextInt(100);
             long a_i = 100 * i + b_i;
             HashTableElement hte = new HashTableElement(a_i, a_i);
             //System.out.println(hte.GetKey());
             tb[i] = hte;
         }

         LP(tb);
         AQP(tb);
         QP(tb);
         Double(tb);

     }

     public static void LP (HashTableElement[] arr){
         LPHashTable tb = new LPHashTable(10000019, 1000000007);
         System.out.println("len of arr: " + arr.length);
         int coun = 0;
         long time = currentTimeMillis();
         //first n: 5000009
         //sec n: 9500018
         for (int i=0; i< arr.length; i++) {
             try {
                 //System.out.println("inserting: " + arr[i].GetKey());
                 tb.Insert(arr[i]);
                 coun++;
             } catch (IHashTable.KeyAlreadyExistsException ex) {
                 System.out.println("oops key already exists, i: " + i + ", ai: " + arr[i]);
             } catch (IHashTable.TableIsFullException ex) {
                 System.out.println("oops table is full, i: " + i + ", ai: " + arr[i]);
             }
         }
         long after = currentTimeMillis();
         System.out.println( "LP: " + ((after-time)));
         System.out.println("coun: "+ coun);
     }

    public static void AQP (HashTableElement[] arr){
        AQPHashTable tb = new AQPHashTable(10000019, 1000000007);
        long time = currentTimeMillis();
        //first n: 5000009
        //sec n: 9500018
        for (int i=0; i< arr.length; i++) {
            try {
                tb.Insert(arr[i]);
            } catch (IHashTable.KeyAlreadyExistsException ex) {
                System.out.println("oops key already exists, i: " + i + ", ai: " + arr[i]);
            } catch (IHashTable.TableIsFullException ex) {
                System.out.println("oops table is full, i: " + i + ", ai: " + arr[i]);
            }
        }
        long after = currentTimeMillis();
        System.out.println("AQP: " + ((after-time) * 0.001));
    }

    public static void QP (HashTableElement[] arr){
        QPHashTable tb = new QPHashTable(10000019, 1000000007);
        long time = currentTimeMillis();
        //first n: 5000009
        //sec n: 9500018
        for (int i=0; i< arr.length; i++) {
            try {
                tb.Insert(arr[i]);
            } catch (IHashTable.KeyAlreadyExistsException ex) {
                System.out.println("oops key already exists, i: " + i + ", ai: " + arr[i]);
            } catch (IHashTable.TableIsFullException ex) {
                System.out.println("oops table is full, i: " + i + ", ai: " + arr[i]);
            }
        }
        long after = currentTimeMillis();
        System.out.println("QP: " + ((after-time) * 0.001));
    }

    public static void Double (HashTableElement[] arr){
        DoubleHashTable tb = new DoubleHashTable(10000019, 1000000007);
        long time = currentTimeMillis();
        //first n: 5000009
        //sec n: 9500018
        for (int i=0; i< arr.length; i++) {
            try {
                tb.Insert(arr[i]);
            } catch (IHashTable.KeyAlreadyExistsException ex) {
                System.out.println("oops key already exists, i: " + i + ", ai: " + arr[i]);
            } catch (IHashTable.TableIsFullException ex) {
                System.out.println("oops table is full, i: " + i + ", ai: " + arr[i]);
            }
        }
        long after = currentTimeMillis();
        System.out.println("Double: " + ((after-time) * 0.001));
    }

    /***

    public static void main(String[] args) {
        DoubleHashTable tb = new DoubleHashTable(10000019, 1000000007);
        long time_after_3 = 0;
        long time_end = 0;
        long time_first = currentTimeMillis();
        for (int j = 0; j < 6; j++) {
            long first = currentTimeMillis();
            long[] keys = new long[5000009];
            for (int i = 0; i < 5000009; i++) {
                Random rnd = new Random();
                long b_i = rnd.nextInt(100);
                long a_i = 100 * i + b_i;
                keys[i] = a_i;
                HashTableElement hte = new HashTableElement(a_i, a_i);
                try {
                    tb.Insert(hte);
                } catch (IHashTable.KeyAlreadyExistsException ex) {
                    System.out.println("oops key already exists, i: " + i + ", ai: " + a_i + ", j:" + j);
                } catch (IHashTable.TableIsFullException ex) {
                    System.out.println("oops table is full, i: " + i + ", ai: " + a_i + ", j:" + j);
                }
            }
            for (int z = 0; z < 5000009; z++) {
                try {
                    tb.Delete(keys[z]);
                } catch (IHashTable.KeyDoesntExistException ex) {
                    System.out.println("not such key: " + keys[z]);
                }
            }

            long second = currentTimeMillis();
            System.out.println("for j: " + j + ", time: " + (second-first)*0.001);
            if (j == 2) {
                time_after_3 = currentTimeMillis();
            }
        }
        time_end = currentTimeMillis();
        System.out.println("after 3: " + (time_after_3 - time_first)*0.001);
        System.out.println("after 6: " + (time_end - time_after_3)*0.001);
    }
     ***/
}
