package com.company;

public class FMCS {


    public Result find_max_crossing_subarray(int[] A, int low, int mid, int high){
        int left_sum = Integer.MIN_VALUE;
        int right_sum = Integer.MIN_VALUE;

        int sum = 0;
        int max_left = 0;
        int max_right = 0;

        //left block
        for(int i = mid; i >= low; i--){
            sum += A[i];

            if(sum > left_sum){
                max_left = i;
                left_sum = sum;
            }
        }


        sum = 0;
        //right block
        for(int j = mid + 1; j <= high; j++){
            sum += A[j];

            if(sum > right_sum){
                max_right = j;
                right_sum = sum;
            }
        }

        return new Result(max_left, max_right, left_sum + right_sum);
    }

    public Result find_max_crossing_subarray(int[] A, int low, int high){
        int mid=0;
        int left_sum = 0, left_low = 0, left_high = 0;
        int right_sum = 0, right_low = 0, right_high = 0;
        int cross_sum = 0, cross_low =0, cross_high = 0;

        if(high==low)
            return new Result(low, high, A[low]);

        else{
            mid= (low+high) /2;

            Result left_block = find_max_crossing_subarray(A, low, mid);
            left_high = left_block.high;
            left_low = left_block.low;
            left_sum = left_block.sum;


            Result right_block = find_max_crossing_subarray(A, mid+1, high);
            right_high = right_block.high;
            right_low = right_block.low;
            right_sum = right_block.sum;


            Result cross_block = find_max_crossing_subarray(A, low, mid, high);
            cross_high = cross_block.high;
            cross_low = cross_block.low;
            cross_sum = cross_block.sum;


            if( left_sum > right_sum && left_sum > cross_sum)
                return new Result(left_low, left_high, left_sum);

            else if( right_sum> left_sum && right_sum > cross_sum)
                return new Result(right_low, right_high, right_sum);

            else
                return new Result(cross_low, cross_high, cross_sum);


        }
    }
}
