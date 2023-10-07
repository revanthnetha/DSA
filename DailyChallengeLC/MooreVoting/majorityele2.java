class Solution {
    public List<Integer> majorityElement(int[] arr) {
        if (arr.length == 0)
            return new ArrayList<>();
        if (arr.length == 1)
            return new ArrayList<>(Arrays.asList(arr[0]));
        if (arr.length == 2) {
            if (arr[0] == arr[1])
                return new ArrayList<>(Arrays.asList(arr[0]));
            return new ArrayList<>(Arrays.asList(arr[0], arr[1]));
        }
        
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr);

        int count = 1, flag = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1])
                count = 1;
            if (arr[i] == arr[i-1])
                count ++;
            if (count > arr.length/3) {
                if (flag != arr[i])
                    res.add(arr[i-1]);
                flag = arr[i];
            }
        }

        return res;

    }
}
Copyright © 2023 LeetCode