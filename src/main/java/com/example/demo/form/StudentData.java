package com.example.demo.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.example.demo.entity.Student;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class StudentData {
    // 学生ID
	private Integer id;
	
    // 学生の名前
    // 入力されなかった場合に下記メッセージを表示
	@NotBlank(message="名前を入力してください")
	private String name;
	
    // 学生の点数
    // 入力されなかった場合に下記メッセージを表示
	@NotNull(message="点数を入力してください")
    // 指定の数値以下が入力された場合に下記メッセージを表示
	@Min(value=0, message="0点以上で入力してください")
    // 指定の数値以上が入力された場合に下記メッセージを表示
	@Max(value=100, message="100点以下で入力してください")
	private Integer score;
	
    // Studentエンティティへの変換
	public Student toEntity() {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setScore(score);
		
		return student;
	}
}