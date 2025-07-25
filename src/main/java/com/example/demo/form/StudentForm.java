package com.example.demo.form;

import com.example.demo.entity.Student;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class StudentForm {
    // 学生ID
	private Integer id;
    // 学生の名前
	private String name;
    // 学生の点数
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
