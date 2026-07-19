package com.example.taskmanager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.task.Task;
import com.example.taskmanager.taskstatus.TaskStatus;

@Controller
@RequestMapping("/tasks")

public class TaskController{
	//依存性注入
	private final TaskService service;
	
	public TaskController(TaskService service) {
		this.service = service;
	}
	//一覧表示
	@GetMapping
	public String list(Model model) {
		///tasksにGETリクエストして結果をmodelに入れる
		model.addAttribute("tasks", service.findAll());
		//task-list.htmlへ渡す
		return "task-list";
	}
	/*一件取得(詳細表示)
	@GetMapping("/{id}")
	public String detail(@PathVariable Long id, Model model) {
		///taskにGETリクエストして結果をmodelに入れる
		model.addAttribute("task",service.findById(id));
		//task-detail.htmlへ渡す
		return "task-detail";
	}
	*/
	
	
	//タスク登録機能
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("task",new Task());
		return "task-form";
	}
	
	//登録
	@PostMapping("")
	public String create(@ModelAttribute Task task) {
		//登録情報が空の状態で呼び出されたらフォーム画面に戻す
		if(task.getTitle() == null || task.getTitle().isEmpty()) {
			return "task-form"; //簡易バリデーション
		}
		
		service.create(task.getTitle(),task.getDescription(),task.getStatus());
		
		return "redirect:/tasks";
	}
	
	//詳細
	@GetMapping("/{id}")
	public String detail(@PathVariable Long id, Model model) {
	
	Task task = service.findById(id);
	model.addAttribute("task",task);
	//task-detailへ渡す
	return "task-detail";
		
	}
	
	//更新内容登録機能
	@GetMapping("/{id}/edit")
	public String showEditForm(@PathVariable Long id,
								Model model) {
		Task task = service.findById(id);
		model.addAttribute("task", task);
		return "task-edit";
	}
	
	//更新処理
		@PostMapping("/{id}/update")
		//受け取ったURLに対象のidとタイトルが含まれていればそれを取得しupdateメソッドにわたして更新
		public String update(@PathVariable Long id,
							@RequestParam String title,
							@RequestParam String description,
							@RequestParam TaskStatus status){
			service.update(id, title,description,status);
			//tasksページに戻る
			return "redirect:/tasks";
		}
	
	//削除処理
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {

	    service.delete(id);

	    return "redirect:/tasks";
	}
	
}

