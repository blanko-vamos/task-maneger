package com.example.taskmaneger.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.taskmaneger.Service.TaskService;

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
	//一件取得(詳細表示)
	@GetMapping("/{id}")
	public String detail(@PathVariable Long id, Model model) {
		///taskにGETリクエストして結果をmodelに入れる
		model.addAttribute("task",service.findById(id));
		//task-detail.htmlへ渡す
		return "task-detail";
	}
	//更新処理
	@PostMapping("/{id}/update")
	//受け取ったURLに対象のidとタイトルが含まれていればそれを取得しupdateメソッドにわたして更新
	public String update(@PathVariable Long id,
			@RequestParam String title){
		service.update(id, title);
		///tasksページに戻る
		return "redirect:/tasks";
	}
}