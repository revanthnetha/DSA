package Recursion;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<List<String>>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                board[i][j] = '.';
        }
        int row[] = new int[n];
        int ld[] = new int[2*n-1];
        int rd[] = new int[2*n-1];
        f(0,board,ans,row,ld,rd);
        return ans;
    }

    public static void f(int col,char[][] board,List<List<String>> ans,int row[],int ld[],int rd[] ){
        if(col==board.length){
            ans.add(construct(board));
            return;
        }

        for(int i=0;i<board.length;i++){
            if(row[i]==0 && ld[i+col]==0 && rd[board.length-1+ (col-i)]==0){
                row[i]=1 ;
                ld[i+col]=1 ;
                 rd[board.length-1+ (col-i)]=1;
                board[i][col] = 'Q';
                f(col+1,board,ans,row,ld,rd);
                board[i][col] = '.';
                 row[i]=0 ;
                ld[i+col]=0 ;
                 rd[board.length-1+ (col-i)]=0;
            }
        }
        
    }

    
    static List < String > construct(char[][] board) {
        List< String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
