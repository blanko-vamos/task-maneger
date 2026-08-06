概要

本アプリケーションはSpring Bootを用いて作成したWebアプリケーションです。
タスクの作成、更新、一覧参照、削除といった基本的なCRUD処理機能を実装しています。
本プロジェクトはポートフォリオとして作成し、以下の理解を深めることを目的としています。

・Javaのオブジェクト指向設計(それぞれの役割を持たせそこから逸脱しない設計)
・CRUD処理の実装(アプリケーション処理の基本であるためこれらの実装を目指しました。)
・Git/GitHubを用いたバージョン管理

主な機能
1:タスクの新規作成
2:タスク一覧表示
3:タスク内容の更新
4:タスク内容の削除
5：タスクのステータス管理
6:PostgreSQLによるデータ永続化,pgAdmin4を用いたデータベース管理

使用技術
・Java
・Ecripse
・Git
・GitHub
・Spring Boot
・PostgreSQL
・pgAdmin4
・Spring Data JPA
・Thymeleaf
・Eclipse

プロジェクト構成
｜ーーTaskManagerApplication.java
｜ーーTask.java
｜ーーTaskController.java
｜ーーTaskStatus.java
｜ーーTaskService.java
｜ーーTaskRepository.java


各クラスの役割
・TaskManagerApplication.java
SpringBootアプリケーションのエントリークラス　アプリケーションの起動を担当
・Task.java
タスク情報を表すエンティティクラス 各情報のgetter,setterも定義されている
・TaskController.java
HTTPリクエストを受け取りどの処理を実行するか決めるクラス
・TaskStatus.java
タスクの状態を定義する列挙型
・TaskService.java
ビジネスロジックをまとめたクラス Controllerから呼び出されタスクのCRUD処理を実行
・TaskRepository.java
DBのやり取りを担当するクラス

今後の改善予定
・入力バリデーションの強化

本プロジェクトで学んだこと
・クラス設計と責務分離の重要性(設計書を作成し技術選定各クラスの役割設定から行いました)
・ブランチ管理の基礎
・SpringBootを使用してのウェブアプリ開発の基礎
