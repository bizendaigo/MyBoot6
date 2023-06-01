package jp.te4a.spring.boot.myapp6;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;


@Repository
public class BookRepository {
	private final ConcurrentMap<Integer, BookBean> bookMap
	= new ConcurrentHashMap<>();

	public BookBean save(BookBean bookBean) {//保存用メソッド
		return bookMap.put(bookBean.getId(), bookBean);
		}
	
	public void delete(Integer bookId) {//削除用メソッド
		bookMap.remove(bookId);
		}
	public List<BookBean> findAll() {//(全件)取得用メソッド
		return new ArrayList<>(bookMap.values());
		}
}


//上3つのメソッドはDB使用時にSQL実行に変える