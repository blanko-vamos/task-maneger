package taskmanegement;
import java.util.ArrayList;
import java.util.List;
class TaskOperation{
	//CRUD処理をするためのメソッドをここに書いていく
	//タスクの各情報を管理するための配列
	private List<Task> tasks = new ArrayList<>();
	//初期のIDを初版
	private int nextId = 1;
	//新たにタスクを追加するときに使う呼び出すメソッド
	void create(String title,String content) {
		//Task型を扱う為にインスタンス生成
		Task task = new Task(nextId,title,content);
		tasks.add(task);
		//新しいタスクが追加されたらidを＋１する
		nextId++;
	}
	//タスクを読み取って返すメソッド
	public void showAll(){
		for(Task task : tasks) {
			System.out.println(
			"ID:" + task.getId() + "タイトル:" + task.getTitle() +
			"ステータス:" + task.getStatus());
		}
	}
	//タスクを更新するためのメソッド
	void updateTitle(int id, String newTitle) {
		//対象のidのリストの参照を渡す
		Task task = findById(id);
		//タスクの中身が空の場合エラーメッセージを出す
		if(task == null) {
			System.out.println("指定されたIDのタスクがありません");
			return;
		}
		//タスクが空じゃなかったら新しいタイトルを渡す 直接配列をいじらないので安心安全
		task.setTitle(newTitle);
	}
	//タスクを消去するためのメソッド
	void delete(int id){
		//対象のidのリストの参照を渡す
		Task task = findById(id);
		//タスクの中身が空の場合エラーメッセージを出す
		if(task == null) {
			System.out.println("指定されたIDのタスクがありません");
			return;
		}
		tasks.remove(task);
	}
	
	//渡されたidと一致するタスクを返すメソッド
	private Task findById(int id) {
		//タスクを一件ずつチェックして一致するidを確認
		for(Task task: tasks) {
			if(task.getId() == id) {
				//trueだったら対象のタスクを返す
				return task;
			}
		}
		//最後まで見つからなかったらnullを返す
		return null;
	}
	
	//渡されたidに一致するステータスを更新するメソッド
	public void updateStatus(int id,TaskStatus status){
		//対象のidのリストの参照を渡す
		Task task = findById(id);
		if(task == null) {
			System.out.println("指定されたIDのタスクがありません");
			return;
		}
		//更新するステータスを渡す
		task.setStatus(status);
	}
}