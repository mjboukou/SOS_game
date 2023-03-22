import java.util.Scanner;

//MIXALIS BOUKOUVALAS 3293
//ARIS GOUVAS 4009
//GEORGIA KAPSALI 3248
public class Sos {

	public static class Move 
	{ 
	    int row, col;
	    char letter;
	} 
	//Evaluation function
	public static int evaluate(char b[][]){
		int x=0,t=0,f=0;
		int y=0;
		int l=0;
		int p=0;
		int n=0;
		int z=0;
		for(int row=0;row<3;row++){
			for(int col=0;col<3;col++){
				if(b[row][col]=='_') {
					n=n+1;
				}
			}
		}
		for(int row=0;row<3;row++){
			if(b[row][0]=='s' && b[row][2]=='s' && b[row][1]=='_'){
				x=x+ 30;
			}
		}
		for(int col=0;col<3;col++){
			if(b[0][col]=='s' && b[2][col]=='s' && b[1][col]=='_'){
				x=x+ 30;
			}
		}
		if(b[0][0]=='s' && b[2][2]=='s' && b[1][1]=='_'){
			x=x+ 30;
		}
		if(b[0][2]=='s' && b[2][0]=='s' && b[1][1]=='_'){
			x=x+ 30;
		}
		for(int row=0;row<3;row++){
			if((b[row][0]=='s' && b[row][1]=='o' && b[row][2]=='_')||(b[row][0]=='_' && b[row][1]=='o' && b[row][2]=='s')){
				y=y+ 30;
			}
		}
		for(int col=0;col<3;col++){
			if((b[0][col]=='s' && b[1][col]=='o' && b[2][col]=='_')||(b[0][col]=='_' && b[1][col]=='o' && b[2][col]=='s')){
				y=y+ 30;
			}
		}
		if((b[0][0]=='s' && b[1][1]=='o' && b[2][2]=='_')||(b[0][0]=='_' && b[1][1]=='o' && b[2][2]=='s')){
			y=y+ 30;
		}
		if((b[0][2]=='s' && b[1][1]=='o' && b[2][0]=='_')||(b[0][2]=='_' && b[1][1]=='o' && b[2][0]=='s')){
			y=y+ 30;
		}
		for(int row=0;row<3;row++){
			if(b[row][0]=='_' && b[row][1]=='o' && b[row][2]=='_'){
				l=l+10;
			}
		}
		for(int col=0;col<3;col++){
			if(b[0][col]=='_' && b[1][col]=='o' && b[2][col]=='_'){
				l=l+10;
			}
		}
		if(b[0][0]=='_' && b[1][1]=='o' && b[2][2]=='_'){
			l=l+10;
		}
		if(b[2][0]=='_' && b[1][1]=='o' && b[0][2]=='_'){
			l=l+10;
		}
		for(int row=0;row<3;row++){
			if(b[row][0]=='s' && b[row][1]=='_' && b[row][2]=='_'){
				p=p+ 10;
			}
		}
		for(int col=0;col<3;col++){
			if(b[0][col]=='s' && b[2][col]=='_' && b[1][col]=='_'){
				p=p+ 10;
			}
		}
		if(b[0][0]=='s' && b[2][2]=='_' && b[1][1]=='_'){
			p=p+ 10;
		}
		if(b[2][0]=='s' && b[0][2]=='_' && b[1][1]=='_'){
			p=p+ 10;
		}
		for(int row=0;row<3;row++){
			if(b[row][0]=='_' && b[row][1]=='_' && b[row][2]=='s'){
				p=p+ 10;
			}
		}
		for(int col=0;col<3;col++){
			if(b[0][col]=='_' && b[1][col]=='_' && b[2][col]=='s'){
				p=p+ 10;
			}
		}
		if(b[0][0]=='_' && b[1][1]=='_' && b[2][2]=='s'){
			p=p+ 10;
		}
		if(b[2][0]=='_' && b[1][1]=='_' && b[0][2]=='s'){
			p=p+ 10;
		}
		for(int row=0;row<3;row++) {
			if(b[row][0]=='s' && b[row][1]=='o' && b[row][2]=='s') {
				z = z+1000;
			}
		}
		for(int col=0;col<3;col++) {
			if(b[0][col]=='s' && b[1][col]=='o' && b[2][col]=='s') {
				z = z+ 1000;
			}
		}
		if(b[0][0]=='s' && b[1][1]=='o' && b[2][2]=='s') {
			z= z + 1000;
		}
		if(b[2][0]=='s' && b[1][1]=='o' && b[0][2]=='s') {
			z= z + 1000;
		}
		t=(int) Math.pow(-1, n);
		f=((t*(x+y))+((z+l+p)));
		return f;
	}
	//minimax
	public static Move minimax(char board[][],Boolean isMax) {
		int h=0;
		int g=0;
		Move bestMove = new Move();
	    Move bestMove1 = new Move();
	    Move bestMove2 = new Move();
	    bestMove.row=-1;
	    bestMove.col=-1;
	    bestMove1.row = -1; 
	    bestMove1.col = -1;
	    bestMove2.row = -1; 
	    bestMove2.col = -1;
	    bestMove.letter = ' ';
	    bestMove1.letter =' ';
	    bestMove2.letter =' ';
		int score1=-1000;
		int score2=-1000;
		int score3=1000;
		int score4=1000;
		if(isMax) {
			//maximaizer
			for (int i = 0; i < 3; i++) 
			{ 
				for (int j = 0; j < 3; j++) 
				{ 
					// Check if cell is empty 
					if (board[i][j]=='_') 
					{ 
						// Make the move 
						board[i][j] = 's'; 
  
						// Call evaluate to see the score of the board
						// and choose the maximum value 
						h = evaluate(board);
						if(score1<h) {
							score1 = h;
							bestMove1.row=i;
							bestMove1.col=j;
							bestMove1.letter='s';
						}
						// Undo the move 
						board[i][j] = '_'; 
					} 
				}
			}
			for (int i = 0; i < 3; i++) 
			{ 
				for (int j = 0; j < 3; j++) 
				{ 
					// Check if cell is empty 
					if (board[i][j]=='_') 
					{ 
						// Make the move 
						board[i][j] = 'o'; 
  
						// Call evaluate recursively and choose 
						// the maximum value 
						g = evaluate(board);
						if(score2<g ) {
							score2 = g;
							bestMove2.row=i;
							bestMove2.col=j;
							bestMove2.letter='o';
						}
                    
						// Undo the move 
						board[i][j] = '_'; 
					} 
				}
			}
			//chooses the best move
			if(score1>score2) {
				bestMove=bestMove1;
				bestMove.col=bestMove1.col;
				bestMove.row=bestMove1.row;
				bestMove.letter=bestMove1.letter;
				return bestMove;
			}
			else {
				bestMove=bestMove2;
				bestMove.col=bestMove2.col;
				bestMove.row=bestMove2.row;
				bestMove.letter=bestMove2.letter;
				return bestMove;
			}
		
		}
		else {
			//minimaizer
			for (int i = 0; i < 3; i++) 
			{ 
				for (int j = 0; j < 3; j++) 
				{ 
					// Check if cell is empty 
					if (board[i][j]=='_') 
					{ 
						// Make the move 
						board[i][j] = 's'; 
  
						// Call evaluate recursively and choose 
						// the minimum value 
						int to = evaluate(board);
						if(score3<to ) {
							score3 = to;
							bestMove1.row=i;
							bestMove1.col=j;
							bestMove1.letter='s';
						} 
                    
						// Undo the move 
						board[i][j] = '_'; 
					} 
				}
			}
			for (int i = 0; i < 3; i++) 
			{ 
				for (int j = 0; j < 3; j++) 
				{ 
					// Check if cell is empty 
					if (board[i][j]=='_') 
					{ 
						// Make the move 
						board[i][j] = 'o'; 
  
						// Call evaluate recursively and choose 
						// the minimum value 
						int go = evaluate(board);
						if(score4<go ) {
							score4 = go;
							bestMove2.row=i;
							bestMove2.col=j;
							bestMove2.letter='o';
						} 
                    
						// Undo the move 
						board[i][j] = '_'; 
					} 
				}
			}
			//chooses the worst move
			if(score3<score4) {
				bestMove=bestMove1;
				bestMove.col=bestMove1.col;
				bestMove.row=bestMove1.row;
				bestMove.letter=bestMove1.letter;
				return bestMove;
			}
			else {
				bestMove=bestMove2;
				bestMove.col=bestMove2.col;
				bestMove.row=bestMove2.row;
				bestMove.letter=bestMove2.letter;
				return bestMove;
			}
		}
	}
	//check the board if is emprty
	public static Boolean empty(char board[][]) {
		int v=0;
		for(int row=0;row<3;row++){
			for(int col=0;col<3;col++){
				if(board[row][col]=='_') {
					v=v+1;
				}
			}
		}
		if(v!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	//checking for winner
	public static Boolean WinnerFound(char board[][]) {
		if(evaluate(board)>800) {
			return true;
		}
		else {
			return false;
		}
	}
	//prints the board
	public static void board(char board[][]) {
		for(int l = 0; l<3; l++)
	    {
	    	for(int j = 0; j<3; j++)
	    	{
	    		System.out.print("|");
	    	    System.out.print(board[l][j]);
	    	    System.out.print("|");
	    	}
	    	System.out.print("\n");
	    }
	    System.out.print("\n");
	}
	// Driver code 
	public static void main(String [] args) 
	{	
		Scanner input = new Scanner(System.in);
		System.out.println("Choose board");
		System.out.println("1 for the 'o' on the left or 2 for the 'o' on the right");
		int blet;
		blet = input.nextInt();
		while(blet!=1 && blet!=2) {
			System.out.println("give a correst number!!(1 or 2)");
			blet = input.nextInt();
		}
		if(blet==1) {
			char board[][] = {{ '_', '_', '_' }, 
                    		  { 'o', '_', '_' }, 
                    		  { '_', '_', '_' }};
			board(board);
			while(empty(board)==true)
			{	
				Move bestMove = null;
				char letter2 = ' ';
				bestMove = minimax(board,true);
				letter2=bestMove.letter;
				board[bestMove.row][bestMove.col]=letter2;
				board(board);
				if(WinnerFound(board)==true) {
					System.out.println("Max is the Winner!!");
					break;
				}
				int ro;
				int co;
				System.out.println("Enter the row number: ");
				ro = input.nextInt();
				while(ro>2 || ro<0) {
					System.out.println("Give a correct nomber(from 0 to 2)");
					ro = input.nextInt();
				}
				System.out.println("Enter the column number: ");
				co = input.nextInt();
				while(co>2 || co<0) {
					System.out.println("Give a correct nomber(from 0 to 2)");
					co = input.nextInt();
				}
				while(board[ro][co]!= '_') {
					System.out.println("choose an emprty possision!!");
					System.out.println("Enter the row number");
					ro = input.nextInt();
					while(ro>2 || ro<0) {
						System.out.println("Give a correct nomber(from 0 to 2)");
						ro = input.nextInt();
					}
					System.out.println("Enter the column number: ");
					co = input.nextInt();
					while(co>2 || co<0) {
						System.out.println("Give a correct nomber(from 0 to 2)");
						co = input.nextInt();
					}
				}
				System.out.println("Enter s or o: ");
				input.nextLine();
				char let = input.next().charAt(0);
				while(let!='s' && let!= 'o') {
					System.out.println("Give a correct letter!!");
					let = input.next().charAt(0);
				}
				board[ro][co] = let;
				board(board);
				if(WinnerFound(board)==true) {
					System.out.println("Min is the Winner!!");
					break;
				} 
			}
			if(WinnerFound(board)==false) {
				System.out.println("No winner it's a tie");
			}
		}
		else if (blet ==2) {
			char board[][] = {{ '_', '_', '_' }, 
							  { '_', '_', 'o' }, 
							  { '_', '_', '_' }};
			board(board);
			while(empty(board)==true)
			{	
				Move bestMove = null;
				char letter2 = ' ';
				bestMove = minimax(board,true);
				letter2=bestMove.letter;
				board[bestMove.row][bestMove.col]=letter2;
				board(board);
				if(WinnerFound(board)==true) {
					System.out.println("Max is the Winner!!");
					break;
				}
				int ro;
				int co;
				System.out.println("Enter the row number: ");
				ro = input.nextInt();
				while(ro>2 || ro<0) {
					System.out.println("Give a correct nomber(from 0 to 2)");
					ro = input.nextInt();
				}
				System.out.println("Enter the column number: ");
				co = input.nextInt();
				while(co>2 || co<0) {
					System.out.println("Give a correct nomber(from 0 to 2)");
					co = input.nextInt();
				}
				while(board[ro][co] != '_') {
					System.out.println("choose an emprty possision!!");
					System.out.println("Enter the row number: ");
					ro = input.nextInt();
					while(ro>2 || ro<0) {
						System.out.println("Give a correct nomber(from 0 to 2)");
						ro = input.nextInt();
					}
					System.out.println("Enter the column number: ");
					co = input.nextInt();
					while(co>2 || co<0) {
						System.out.println("Give a correct nomber(from 0 to 2)");
						co = input.nextInt();
					}
					input.nextLine();
				}
				System.out.println("Enter s or o: ");
				input.nextLine();
				char let = input.next().charAt(0);
				while(let!='s' && let!= 'o') {
					System.out.println("Give a correct letter!!");
					let = input.next().charAt(0);
				}
				board[ro][co] = let;
				board(board);
				if(WinnerFound(board)==true) {
					System.out.println("Min is the Winner!!");
					break;
				} 
			}
			if(WinnerFound(board)==false) {
				System.out.println("No winner it's a tie");
			}
		}
	    input.close();
	} 
	  
}
