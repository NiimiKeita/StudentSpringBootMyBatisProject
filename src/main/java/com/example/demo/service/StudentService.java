package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.entity.Student;
import com.example.demo.form.StudentData;
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
	
    // 検索フォームの条件によってStudentオブジェクトを検索するメソッド
	public List<Student> search(Student student) {
		return studentMapper.search(student);
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
    
    // カスタムバリデーション(全角スペースで構成されているかを判定)
    // Controllerからフォームから入力されたStudentDataオブジェクトとデフォルトバリデーションの結果を保持したBindingResultオブジェクトを受け取る
	public boolean isValid(StudentData studentData, BindingResult result) {
        // バリデーションにエラーが含まれるか判定するためのフラグ
		boolean answer = true;
        // StudentDataオブジェクトの名前を取得
		String name = studentData.getName();
        // 名前がnullもしくは空白でないとき処理を実施
		if (name != null && !name.equals("")) {
            // 全角スペースで構成されているか判定するフラグ
			boolean isAllDoubleSpace = true;
            // 名前を一文字ずつ判定する
			for (int i = 0; i < name.length(); i++) {
                // 文字が全角スペース以外であれば処理を実施
				if (name.charAt(i) != '　') {
                    // 全角スペース判定フラグをfalseに設定
					isAllDoubleSpace = false;
//                    繰り返し処理を抜ける
					break;
				}
			}
            // 全角スペース判定フラグがTrueなら処理を実施
			if (isAllDoubleSpace) {
//                FieldErrorオブジェクトに下記内容を引数として渡す
				FieldError fieldError = new FieldError(
						result.getObjectName(),
						"name",
						"件名が全角スペースです"
						);
                // エラーリストに上記結果を追加する
				result.addError(fieldError);
//                バリデーションエラー判定フラグをfalseに設定
				answer = false;
			}
		}
        // 結果を返す
		return answer;
	}
}