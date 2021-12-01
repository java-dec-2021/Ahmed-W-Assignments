import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    public void printNums(){
        for (int i = 0; i<= 255; i++){
            System.out.println(i);
        }
    }
    
    public int sumNums(){
        int sum = 0;
        for (int i = 0; i <= 255; i++){
            sum += i;
        }
        return sum;
    }

    public void printOdds(){
        for (int i = 0; i<= 255; i++){
            if(i%2 == 1){
                System.out.println(i);;
            }
        }
        
    }

    public static void iterateArray(int[] newArray){
        for (int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }

    }

    public static int maxArray(int[] newArray){
        int tmax = 0;
        for(int i = 0; i < newArray.length; i++){
            int max = newArray[0];
            if(newArray[i] > max){
                max = newArray[i];
                tmax = max;
            }
        }
        return tmax;
    }
    public static int minArray(int[] newArray){
        int tmin = newArray[0];
        for(int i = 0; i < newArray.length; i++){
            if(newArray[i] < tmin){
                tmin = newArray[i];
            }
        }
        return tmin;
    }

    public static ArrayList<Integer> oddArray(){
        
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 0; i <= 255; i++){
            if (i%2 == 1){
                y.add(i);
            }
        }
        return y;
    }

    public static double getAverage(int[] newArray){
        double avg = 0;
        double sum = 0;
        for (int i = 0; i < newArray.length; i++){
            sum += newArray[i];
        }
        avg = sum/newArray.length;
        return avg;
    }

    public int greaterY(int[] newArray, int y){
        int count = 0;
        for (int i = 0; i < newArray.length; i++){
            if(newArray[i] > y){
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Integer> squared(int[] newarr){
        ArrayList<Integer> v = new ArrayList<Integer>();
        for (int i = 0; i < newarr.length; i++){
            v.add(newarr[i]*newarr[i]);
        }
        return v;
    }

    public static ArrayList<Integer> noNegatives(int[] newarr){
        ArrayList<Integer> v = new ArrayList<Integer>();
        for (int i = 0; i < newarr.length; i++){
            if(newarr[i] < 0){
                v.add(0);
            }
            else{
                v.add(newarr[i]);
            }
        }
        return v;
    }

    public static ArrayList<Object> maxMinAvg(int[] newarr){
        ArrayList<Object> v = new ArrayList<Object>();
        double avg = getAverage(newarr);
        int max = maxArray(newarr);;
        int min = minArray(newarr);
        v.add(max);
        v.add(min);
        v.add(avg);
        return v;
    }

    public static void shiftArray(int[] newarr){
        for (int i = 1; i < newarr.length; i++){
            newarr[i-1] = newarr[i];
        }
        newarr[newarr.length-1] = 0;
        
        System.out.println(Arrays.toString(newarr));;
    }
}
