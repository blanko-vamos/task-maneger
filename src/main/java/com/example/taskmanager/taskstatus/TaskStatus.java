package  com.example.taskmanager.taskstatus;

public enum TaskStatus{
	//タスクの進行状況 画面表示用にラベルの内容を指定
	TODO("作業前"),
	DOING("作業中"),
	DONE("完了");
	
	//外部から変更できないように変数定義
	private final String label;
	
	//enumが呼ばれたときにこのコンストラクタが呼ばれる　引数の値をラベルに入れる
	 TaskStatus(String label) {
		 this.label = label;
		// TODO 自動生成されたコンストラクター・スタブ
	}
	 //ラベルの値を返す用のメソッド
	 public String getLabel() {
		 return label;
	 }
}	 
