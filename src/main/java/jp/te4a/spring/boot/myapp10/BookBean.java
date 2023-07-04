package jp.te4a.spring.boot.myapp10;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import jakarta.persistence.*;
@Entity
@Table(name = "books")//対応テーブル指定
@Data
@AllArgsConstructor
@NoArgsConstructor  //値なしコンストラクタ
	public class BookBean {
		@Id//主キー指定
		@GeneratedValue//DB側で自動採番
		private Integer id;
		@Column(nullable=false)//NOT NULL制約
		private String title;
		private String writter;
		private String publisher;
		private Integer price;
	}
