public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int day=1;day<n;day++){
            for(int last=0;last<4;last++){
                int max=0;
                for(int i=0;i<3;i++){
                    if(i!=last){
                         int p = points[day][i] + dp[day-1][i];
                         max = Math.max(max,p);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[n-1][3];


    }

    public static int f(int day,int last,int points[][],int n,int dp[][]){
        if(day==0){
            int m=0;
            for(int i=0;i<3;i++){
                if(i!=last)
                    m= Math.max(m,points[day][i]);
            }
            return m;
        }

        if(dp[day][last]!=-1)
            return dp[day][last];
        int max=0;

        for(int i=0;i<3;i++){
            if(i!=last){
                int p = points[day][i] + f(day-1,i,points,n,dp);
                max = Math.max(max,p);
            }
        }
        return dp[day][last]=max;
    }

}

//space optimization 

// public class Solution {
//     public static int ninjaTraining(int n, int points[][]) {
//         int prev[] = new int[4];
//         prev[0] = Math.max(points[0][1],points[0][2]);
//         prev[1] = Math.max(points[0][0],points[0][2]);
//         prev[2] = Math.max(points[0][0],points[0][1]);
//         prev[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

//         for(int day=1;day<n;day++){
//             int temp[] = new int[4];
//             for(int last=0;last<4;last++){
//                 int max=0;
//                 for(int i=0;i<3;i++){
//                     if(i!=last){
//                          int p = points[day][i] + prev[i];
//                          max = Math.max(max,p);
//                     }
//                 }
//                 temp[last] = max;
//             }
//             prev = temp;
//         }
//         return prev[3];


//     }