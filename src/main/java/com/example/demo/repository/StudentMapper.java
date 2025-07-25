package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Student;

// MyBatisのマッパーインターフェースを示す
@Mapper
public interface StudentMapper {
    // すべての学生を検索するメソッド
	List<Student> findAll();

    // IDを指定して学生を検索するメソッド
	Student findById(int id);
	
    // 検索フォームから受け取った情報をもとに動的検索を実施するメソッド
    List<Student> search(Student student);

    // 学生情報を保存するメソッド
	void save(Student student);

    // 学生情報を更新するメソッド
	void update(Student student);

    // IDを指定して学生を削除するメソッド
	void delete(int id);
	
    // IDを指定して学生を論理削除するメソッド
    void logicalDelete(int id);
}