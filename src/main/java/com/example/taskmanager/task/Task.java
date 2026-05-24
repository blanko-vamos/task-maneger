package com.example.taskmanager.task;
import com.example.taskmanager.taskstatus.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//このクラスはDBのテーブルとして扱う
@Entity
public class Task{
	//主キーとして設定
	@Id
	//主キーをDB側で1自動採番する
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	//各情報のgetter
		public long getId() {
			return id;
		}
		
		public String getTitle() {
			return title;
		}
		
		public String getDescription() {
			return description;
		}
		
		public TaskStatus getStatus() {
			return status;
		}
		
		//各項目のsetter ※setIdはタスク追加時に発番するのでsetterを設けない
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}
		
		public void setStatus(TaskStatus status) {
			this.status = status;
		}
}