package jp.te4a.spring.boot.myapp8;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;


@Repository
public class BookRepository {
	private final ConcurrentMap<Integer, BookBean> bookMap
	= new ConcurrentHashMap<>();
	private int BOOK_ID=1;
	public int getBookId(){
		return BOOK_ID++;
	}
	public BookBean create(BookBean bookBean) {//作成
		return bookMap.put(bookBean.getId(), bookBean);
	}
	public BookBean update(BookBean updateBookBean) {//更新
		BookBean bookBean = bookMap.get(updateBookBean.getId());
		BeanUtils.copyProperties(updateBookBean, bookBean);
		return bookBean;
	}
	public void delete(Integer bookId) {//削除
		bookMap.remove(bookId);
	}
	public List<BookBean> findAll() {//(全件)取得用メソッド                  //***************************
		return new ArrayList<>(bookMap.values());
	}
	public BookBean findOne(Integer id) {//(1件)取得用メソッド
		return bookMap.get(id);
	}
}


