class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        //Approch 1-->
        // Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        // int n = intervals.length;
        // int count = 0;
        // int i = 0 , j = 1;

        // while(j < n){
        //     int currStart = intervals[i][0];
        //     int currEnd = intervals[i][1];

        //     int nextStart = intervals[j][0];
        //     int nextEnd = intervals[j][1];

        //     if(currEnd <= nextStart){
        //         i = j;
        //         j++;
        //     }
        //     else if(currEnd <= nextEnd){
        //         j++;
        //         count++;
        //     }
        //     else if(currEnd > nextEnd){
        //         i = j;
        //         j++;
        //         count++;
        //     }
        // }

        // return count;

        //-----------------------------------------------------------------------------------
        //Approch 2 ->

        // Arrays.sort(intervals , (a , b) -> Integer.compare(a[0],b[0]));
        // int n = intervals.length;
        // int count = 0;
        // int i = 1;
        // int[] last_interval = intervals[0];

        // while(i < n){


        //     if(last_interval[1] <= intervals[i][0]){
        //         last_interval = intervals[i];
        //         i++;
        //     }
        //     else if(intervals[i][1] >= last_interval[1]){
        //         i++;
        //         count++;
        //     }
        //     else if(intervals[i][1] < last_interval[1]){
        //         last_interval = intervals[i];
        //         i++;
        //         count++;
        //     }
        // }

        // return count;
        //--------------------------------------------------------------------------------

        //Sort on the basis of end ->

        Arrays.sort(intervals ,(a ,b)->Integer.compare(a[1],b[1]));
        int n = intervals.length;
        int count = 0;
        int lastEnd = intervals[0][1];

        for(int i = 1 ; i < n ; i++){
            if(intervals[i][0]<lastEnd){
                count++;
            }else{
                lastEnd = intervals[i][1];
            }
        }
        return count;
    }
}