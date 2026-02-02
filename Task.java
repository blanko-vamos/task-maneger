package taskmanegement;

class Task{
	//タスク管理においてデータを持つフィールド
	private int id; //タスクを一意に特定するための値
	private String title; //タスクの名前
	private String content; //タスクの内容
	private TaskStatus status; //タスクの期日
	
	//id,タスク名,タスク内容を受け取るメソッド
	public Task(int id,String title,String content) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.status = TaskStatus.TODO;
	}
	
	//各情報のgetter
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public TaskStatus getStatus() {
		return status;
	}
	
	//各項目のsetter ※setIdはタスク追加時に発番するのでsetterを設けない
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
}