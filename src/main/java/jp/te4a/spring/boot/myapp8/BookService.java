package jp.te4a.spring.boot.myapp8;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	public BookForm create(BookForm bookForm) {//作成
		bookForm.setId(bookRepository.getBookId());
		BookBean bookBean = new BookBean();
		BeanUtils.copyProperties(bookForm, bookBean);
		bookRepository.create(bookBean);
		return bookForm;
	}
	public BookForm update(BookForm bookForm) {//更新
		BookBean bookBean = new BookBean();
		BeanUtils.copyProperties(bookForm, bookBean);
		bookRepository.update(bookBean);
		return bookForm;
	}
	public void delete(Integer id) { bookRepository.delete(id); }//削除
	public List<BookForm> findAll() {//(全件)取得用メソッド
		List<BookBean> beanList = bookRepository.findAll();
		List<BookForm> formList = new ArrayList<BookForm>();
		for(BookBean bookBean: beanList) {
		BookForm bookForm = new BookForm();
		BeanUtils.copyProperties(bookBean, bookForm);
		formList.add(bookForm);
		}
		return formList;
		}
	public BookForm findOne(Integer id) {
		BookBean bookBean = bookRepository.findOne(id);
		BookForm bookForm = new BookForm();
		BeanUtils.copyProperties(bookBean, bookForm);
		return bookForm;
	}
}



//【Service/Repositoryの両方で保存/取得メソッドを作る利点】
//例）保存先がMapでなくDBに変わった場合も、
//RepositoryのメソッドだけSQL実行に変えればよい
//→Serviceクラスは変更なしで済む