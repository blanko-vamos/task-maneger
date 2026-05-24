package com.example.taskmaneger.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.taskmaneger.Task.Task;

@Service
public class TaskService{
	//タスク情報を管理する配列
	private List<Task> tasks = new ArrayList<>();
	
	//タスクを新規追加するメソッド
	public Task create(String title,String description) {
		Task task = new Task();
		//タスクのタイトルを渡す
		task.setTitle(title);
		//タスクの内容を渡す
		task.setDescription(description);
		//IDを自動採番　そのIDをtaskオブジェクトにセット
		return repository.save(task);
	}
	
	//jpaのfindByIdを使いたいので継承したインターフェースを定義
	public interface TaskRepository extends JpaRepository<Task, Long>{
		
	}
	//依存性を注入
	private final TaskRepository repository;
	
	public TaskService(TaskRepository repository) {
		this.repository = repository;
	}
	//一件取得するメソッド
	public Task findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("タスクが存在しません"));
	}
	
	//タスクの一覧表示をするメソッド
	public List<Task> findAll(){
		return repository.findAll();
	}
	//タスクのタイトルを更新するメソッド
	public void update(Long id,String newTitle) {
		//対象のタスクがあるのかを先ず確認
		Task task = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("タスクが存在しません"));
		
		//新しいタスク名を渡す
		task.setTitle(newTitle);
		//IDを自動採番　そのIDをtaskオブジェクトにセット
		repository.save(task);
	}
	//指定されたタスクを削除するメソッド
	public void delete(Long id) {
		//対象のタスクがあるのかを先ず確認
				Task task = repository.findById(id)
						.orElseThrow(() -> new RuntimeException("タスクが存在しません"));
				//タスクを削除
				repository.delete(task);
	}

}