import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SingleNumber {

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer value = myMap.get(nums[i]);
            if(value == null){
                myMap.put(nums[i],1);
            }
            else{
                myMap.put(nums[i],value+1);
            }
        }

        return getKeyByValue(myMap,1);
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
