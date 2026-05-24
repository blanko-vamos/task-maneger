package com.example.taskmanager.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.task.Task;

@Service
public class TaskService{
	
	//依存性を注入
		private final TaskRepository repository;
		
		public TaskService(TaskRepository repository) {
			this.repository = repository;
		}
		
	//タスクを新規追加するメソッド
	public Task create(String title,String description) {
		Task task = new Task();
		//タスクのタイトルを渡す
		task.setTitle(title);
		//タスクの内容を渡す
		task.setDescription(description);
		//更新内容を保存
		return repository.save(task);
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
	public void update(Long id,String title,String description) {
		//対象のタスクがあるのかを先ず確認
		Task task = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("タスクが存在しません"));
		
		//新しいタスク名を渡す
		task.setTitle(title);
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