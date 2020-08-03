import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            int findElement = target - nums[i];
            if(myMap.containsKey(findElement)){
                indices[0] = i;
                indices[1] = myMap.get(findElement);
                break;
            }
            myMap.put(nums[i],i);
        }
        return indices;
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int[] indices = twoSum(nums,9);
        for(int num : indices){
            System.out.println(num);
        }
    }
}
