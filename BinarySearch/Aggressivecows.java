import java.util.*;

public class Aggressivecows {

    public static boolean f(int a[],int cows,int val){
        int curr = a[0];
        int count =1;
        for(int i=1;i<a.length;i++){
            if(a[i]-curr>=val){
                curr = a[i];
                count++;
            }
            if(count>=cows) 
                return true;
        }
        return false;
    }
    public static void main(String args[]){
      try (Scanner sc = new Scanner(System.in)) {
        int t = sc.nextInt();
          while(t-->0){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);
            int h = a[n-1]-a[0];
            int l=1;
            while(l<=h){
                int mid = (l+h)/2;
                if(f(a,c,mid)){
                   l = mid+1;
                }else{
                    h = mid-1;
                } 
            }
            System.out.println(h);
        }
            return;
          }
    }
    }

