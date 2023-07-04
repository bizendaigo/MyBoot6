package jp.te4a.spring.boot.myapp10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Repository;
import java.util.List;
//import java.util.ArrayList;
//import java.util.concurrent.*;

public interface BookRepository extends JpaRepository<BookBean, Integer>{
	@Query("SELECT X FROM BookBean X ORDER BY X.title")
	List<BookBean> findAllOrderByTitle();
}

//JPAはこのインタフェースから、自動でリポジトリクラスを作成
//リポジトリクラスはCRUD操作用メソッド
//（save, delete, findOne, findAll）を持つ


