package com.example.demo.form;

import com.example.demo.entity.Student;

import lombok.Data;

// Lombokの使用(getter/setter/toString)
@Data
public class StudentQuery {
    // 学生ID
	private Integer id;
    // 学生の点数
	private String name;
	
    // Studentエンティティへの変換
	public Student toEntity() {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		
		return student;
	}
}