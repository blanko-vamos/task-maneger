package taskmanegement;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		//入力受け取る用意
		Scanner sc = new Scanner(System.in);
		TaskOperation operation = new TaskOperation();
		
		//繰り返し処理で画面の一覧を表示するための設定
		boolean run = true;
		
		//繰り返し処理で操作を選択
		while(run) {
			System.out.println("====タスク管理システム====");
			System.out.println("1.タスク一覧表示");
			System.out.println("2.タスク追加");
			System.out.println("3.タスク更新");
			System.out.println("4.タスク削除");
			System.out.println("0.終了");
			System.out.println("選択してください");
			
			//指示を数値で受け取る
			int choice = sc.nextInt();
			//受け取ったのが数値なので改行対策で一行受け取る
			sc.nextLine();
			//受け取った指示によって処理を分岐させる
			switch(choice) {
			//タスク一覧を表示する
			case 1 :
				System.out.println("----タスク一覧表示----");
				//タスクを全権表示する
				operation.showAll();
					break;
			case 2 :
				System.out.println("----追加するタスクのタイトルと内容を入力してください----");
				System.out.println("タイトル");
				String title = sc.next();
				System.out.println("内容");
				String content = sc.next();
                 operation.create(title,content);
				
				System.out.println("タスクを追加しました");
				break;
			case 3 :
				System.out.println("更新するタスクID");
				//更新する値を数値で受け取る
				int updateId = sc.nextInt();
				//受け取ったのが数値なので改行対策で一行受け取る
				sc.nextLine();
				
				System.out.println("新しいタイトル");
				//新しいタイトルを受け取る
				String newTitle = sc.nextLine();
				//受け取った内容を渡してタスクを更新する
				operation.updateTitle(updateId,newTitle);
				
				System.out.println("タスクを更新しました");
				break;
			case 4 :
				System.out.println("削除するタスク番号");
				//削除するidを数値で受け取る
				int deleteId = sc.nextInt();
				
				//受け取ったのが数値なので改行対策で一行受け取る
				sc.nextLine();
				
				//受け取ったIDを削除
				operation.delete(deleteId);
				
				System.out.println("タスクを削除しました");
				break;
			}
		
		}
		sc.close();
	}
}