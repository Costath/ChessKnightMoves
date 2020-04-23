package foo.bar;

import java.util.ArrayList;

public class GoogleFooBar {

	public static void main(String[] args) {
		
		int src = 19;
		int dest = 36;
		int moves;
		
		moves = Solution.solution(src, dest);
		System.out.println("moves qtd = " + moves);
		System.out.println("Expected qtd = 1\n");
		
		moves = Solution.solution(0, 1);
		System.out.println("moves qtd = " + moves);
		System.out.println("Expected qtd = 3\n");

		moves = Solution.solution(0, 36);
		System.out.println("moves qtd = " + moves);
		System.out.println("Expected qtd = 4\n");

		moves = Solution.solution(0, 63);
		System.out.println("moves qtd = " + moves);
		System.out.println("Expected qtd = 6\n");

		moves = Solution.solution(0, 62);
		System.out.println("moves qtd = " + moves);
		System.out.println("Expected qtd = 5\n");
		
		moves = Solution.solution(0, 56);
		System.out.println("moves qtd = " + moves);
		System.out.println("Expected qtd = 5\n");

		moves = Solution.solution(35, 37);
		System.out.println("moves qtd = " + moves);
		System.out.println("Expected qtd = 2\n");

		moves = Solution.solution(0, 37);
		System.out.println("moves qtd = " + moves);
		System.out.println("Expected qtd = 3\n");
		
	}

}
