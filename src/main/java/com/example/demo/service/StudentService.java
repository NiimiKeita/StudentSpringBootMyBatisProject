package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentMapper;

import lombok.AllArgsConstructor;

// Lombokの使用(すべてのフィールドを引数に持つコンストラクタを自動生成する)
@AllArgsConstructor
// サービスロジックであることを示す
@Service
public class StudentService {
	
    // StudentMapperインターフェイスのインスタンス
	private final StudentMapper studentMapper;
	
    // 全件検索して得られたStudentオブジェクトをリスト形式で返すメソッド
	public List<Student> findAll() {
		return studentMapper.findAll();
	}

    // ID によってStudentオブジェクトを検索するメソッド
	public Student findById(int id) {
		return studentMapper.findById(id);
	}
	
    // Studentオブジェクトを保存するメソッド
	public void save(Student student) {
		studentMapper.save(student);
	}
	
    // Studentオブジェクトを更新するメソッド
	public void update(Student student) {
		studentMapper.update(student);
	}
	
    // ID によってStudentオブジェクトを削除するメソッド
	public void delete(int id) {
		studentMapper.delete(id);
	}
	// ID によってStudentオブジェクトを論理削除するメソッド
		public void logicalDelete(int id) {
			studentMapper.logicalDelete(id);
		}
}