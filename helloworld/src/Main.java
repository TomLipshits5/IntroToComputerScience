
public class Main {
    public static void main(String[] args){
        int[] coins = {1,2,3};
        int n = randomElement(coins);
        System.out.println(n);

    }


    public static int randomElement(int[] array){
        int index = (int)(Math.random()*array.length);
        return array[index];
    }
}
