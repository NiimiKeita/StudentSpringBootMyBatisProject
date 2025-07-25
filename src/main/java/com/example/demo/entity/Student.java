package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

// エンティティであることを示す
@Entity
// Lombokの使用(getter/setter/toString自動生成)
@Data
// MySQLの「sampledb」データベースの「student」テーブルに対応
@Table(name="student")
public class Student {
    // 主キー(primary key)
	@Id
    // 自動採番
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    //「student」テーブルの「id」カラムに対応
	@Column(name="id")
	private Integer id;
	
    //「student」テーブルの「name」カラムに対応
	@Column(name="name")
	private String name;
	
    //「student」テーブルの「score」カラムに対応
	@Column(name="score")
	private Integer score;
}