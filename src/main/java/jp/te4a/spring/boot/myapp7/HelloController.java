package jp.te4a.spring.boot.myapp7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@Autowired
	BookService bookService;
	@RequestMapping("books/list")//URL指定
	public String index(Model model) {
	model.addAttribute("msg", "this is setting message");
	return "books/list";//URL指定
	}
	@RequestMapping(value="books/list", method=RequestMethod.POST)//URL指定
	public ModelAndView postForm(@RequestParam("id") String id, 
	@RequestParam("title") String title,@RequestParam("writter") String writter, 
	@RequestParam("publisher") String publisher,@RequestParam("price") String price) {
	ModelAndView mv = new ModelAndView("books/list");//URL指定
	bookService.save(new BookBean(Integer.valueOf(id), title, writter, publisher, 
	Integer.valueOf(price)));//全パラメタ指定
	mv.addObject("books",bookService.findAll());//booksとしてlist<BookBean>をそのまま渡す
	return mv;
	}
}
