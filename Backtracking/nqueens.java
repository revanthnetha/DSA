class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],'.');
        int line[] = new int[n];
        int leftup[] = new int[2*n-1];
        int leftdown[] = new int[2*n-1];
        bfs(0,board,ans,line,leftup,leftdown);
        return ans;
    }

    public void bfs(int col,char board[][],List<List<String>> ans,int[] line,int[] leftup,int[] leftdown){
        if(col==board.length){
            ans.add(construct(board));
            return;
        }

        for(int row=0;row<board.length;row++){
            if(issafe(board,row,col,line,leftup,leftdown)){
                board[row][col]='Q';
                line[row] = 1;
                leftdown[row+col]=1;
                leftup[board.length-1+(col-row)] = 1;
                bfs(col+1,board,ans,line,leftup,leftdown);
                line[row] = 0;
                leftdown[row+col]=0;
                leftup[board.length-1+(col-row)] = 0;
                board[row][col] ='.';
            }
        }
    }

    public boolean issafe(char board[][],int row,int col,int[] line,int[] leftup,int[] leftdown){
        // int nr= row;
        // int nc = col;
        // while(row>=0 && col>=0){
        //     if(board[row][col]=='Q')
        //         return false;
        //     row--;
        //     col--;
        // }
        // row = nr;
        // col = nc;
        // while(col>=0){
        //      if(board[row][col]=='Q')
        //         return false;
        //     col--;
        // }
        // row = nr;
        // col = nc;
        // while(row<board.length && col>=0){
        //      if(board[row][col]=='Q')
        //         return false;
        //     col--;
        //     row++;
        // }
        // return true;
        if(line[row] == 0 && leftdown[row+col]==0 && leftup[board.length-1+(col-row)] == 0)
            return true;
        return false;
    }

    public List<String> construct(char board[][]){
        List<String> a = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            a.add(new String(board[i]));
        }
        return a;
    }

}