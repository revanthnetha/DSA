class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isvalid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board))
                                return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isvalid(char board[][],int row,int col,char ch){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch)
                return false;
            if(board[i][col]==ch)
                return false;
            int nr = 3*(row/3) + i/3;
            int nc = 3*(col/3) + i%3;
            if(board[nr][nc]==ch)
                return false;
        }
        return true;
    }
}