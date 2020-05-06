package com.gahee.algorithms.inflearn.stringarray;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums = {2, 8, 10, 21};
        int target = 10;

        TwoSum twoSum = new TwoSum();
        int [] result = twoSum.solve(nums, target);

        for (int value : result) {
            System.out.println(value);
        }
    }

    // 배열을 돌리면서 10 - a = b 인 것을 찾는다
    // 결과는 숫자의 인덱스를 반환한다.
    private int[] solve(int[] nums, int target) {
        //2, 8 을 꺼낸다.
        // index 0 부터 for 문을 돌려, 2나와,
        // 10 - 2 를 하니 8이 나온다. 8을 Map 에 등록한다.
        // (8, 1번) index 돌려서 맵에 있는 거랑 매치가 되면
        // 우리는 인덱스를 구할 수 있다.
        Map<Integer, Integer> map = new HashMap<>();
        int [] result = new int[2]; //방이 두개이다.
        for (int i = 0; i < nums.length; i++) {
            // from, to, 증가
            // 밥그릇이 있어야 한다 - Map 하고 Array 를 사용하자
            if(map.containsKey(nums[i])){
                int mapValue = map.get(nums[i]);
                // i = 1 일때 8이 나온다, map(8, 0)
                result[0] = mapValue + 1; //1
                result[1] = i + 1; //2
            }else{
                map.put(target - nums[i], i);
                // 10-2 = 8 (key), i = 0 (value)
            }
        }
        return result;
    }
}
