class Solution {
    public boolean winnerOfGame(String colors) {
        int A=0;
        int B=0;
        
            for(int i=1;i<colors.length()-1;i++){
                if( colors.charAt(i)=='A' && colors.charAt(i-1)=='A' && colors.charAt(i+1)=='A'){
                   A++;
                }else if(colors.charAt(i)=='B' && colors.charAt(i-1)=='B' && colors.charAt(i+1)=='B'){
                    B++;
                }
            }
        return A>B;
    }
}

// In our today's problem, We have two of our friends Alice and Bob and they are playing some game (a Weird game😂). Alice only can remove piece with letter A and its neighbors have also letter A and Bob only can remove piece with letter B and its neighbors have also letter B. Alice starts first and the player who can't move any more pieces lose. 🤔

// From the description, It seems that we will have to do many calculations and go through many steps but actually we won't.🤩
// Let's see some exapmles.

// EX1: colors = BBAAABBA
                             
// Alice's Turn -> removes BBA`A`ABBA
// colors = BBAABBA
              
// Bob's Turn -> can't remove any piece
// Alice wins               
// EX2: colors = ABBBABAAAB

// Alice's Turn -> removes ABBBABA`A`AB
// colors = ABBBABAAB
              
// Bob's Turn -> removes AB`B`BABAAB
// colors = ABBABAAB

// Alice's Turn -> can't remove any piece
// Bob wins  
// I think this is enough for the problem.
// From these two examples we can see two important observations:

// First observation, If someone removed a piece from its place (Let's say Alice) It won't give the other player more moves to help him play more.🤔
// Ex -> BBAAABB -> Alice plays -> BBAABB -> Bob loses
// We can see that from the begining of the game, Bob doesn't have any pieces to move and Alice's move didn't give hime extra moves like it didn't make the string BBBB.🤯

// Second observation, From first observation we can conclude and I mentioned it in the first one also, Every player have dedicated number of moves in the begining of the game and it can't be increased or decreased.😔

// From these two observations the solution become much easier. Only count the moves for each player and if Alice has more moves then she wins and if Bob has more or equal moves then he wins