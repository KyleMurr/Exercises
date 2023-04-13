public class Exercises {

    static public int getTotal(int num1, int num2){
        return num1 + num2;
    }

    static public int getTotal(int[] nums){
        int total = 0;
        for (var num:
             nums) {
            total+=num;
        }
        return total;
    }

}
