package com.example.domain;
import lombok.Data;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
//getter,setter自動生成
@Data
//JPAのエンティティクラス
@Entity
//DBのテーブル名
@Table(name = "users")
//全ての属性を持ったコンストラクタの生成

public class User {
	//テーブルの主キーを示す
	@Id
	private String id;
	
	@JsonIgnore
	private String password;
	
	
	
}
