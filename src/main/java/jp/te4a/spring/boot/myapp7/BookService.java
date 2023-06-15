package jp.te4a.spring.boot.myapp7;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public BookBean save(BookBean bookBean) {//保存用メソッド
		return bookRepository.save(bookBean);
		}
	
	public List<BookBean> findAll() {//(全件)取得用メソッド
		return bookRepository.findAll();
		}
}



//【Service/Repositoryの両方で保存/取得メソッドを作る利点】
//例）保存先がMapでなくDBに変わった場合も、
//RepositoryのメソッドだけSQL実行に変えればよい
//→Serviceクラスは変更なしで済む
