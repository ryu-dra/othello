package othero;

import static othero.Board.*;

public class Main{
	public static void main(String[] args) {
		var board = new Board();
		var p1 = new NPC_random_Player(W);
		var p2 = new NPC_random_Player(B);
		
		board.show_board();
		
		while(board.num_of_stone(E)!=0 && board.num_of_stone(B)!=0 && board.num_of_stone(W)!=0) {
			
			System.out.println("p1のターン");
			if(!board.turnable_pos_list(p1.get_color()).isEmpty()) {
				p1.put_on(board);
				board.show_board();
			}else {
				System.out.println("パス。");
			}
			
			
			if(board.num_of_stone(E)==0 && board.num_of_stone(B)==0 && board.num_of_stone(W)==0) {
				break;
			}
			
			System.out.println("p2のターン");
			if(!board.turnable_pos_list(p2.get_color()).isEmpty()) {
				p2.put_on(board);
				board.show_board();
			}else {
				System.out.println("パス。");
			}
			
			System.out.println("ターン終了。");
		}
		
		System.out.println("ゲーム終了。");
		board.show_board();
		System.out.println(p1.get_color()+": "+board.num_of_stone(p1.get_color()));
		System.out.println(p2.get_color()+": "+board.num_of_stone(p2.get_color()));
		if(board.num_of_stone(p1.get_color())>board.num_of_stone(p2.get_color())) {
			System.out.println("p1の勝ち");
		}else if(board.num_of_stone(p1.get_color())<board.num_of_stone(p2.get_color())){
			System.out.println("p2の勝ち");
		}else {
			System.out.println("引き分け");
		}
	}
}