package jp.te4a.spring.boot.myapp8;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("books")
public class BookController {
	@Autowired
	BookService bookService;
	@ModelAttribute
	BookForm setUpForm() {
	return new BookForm();
	}
	@GetMapping                //booksにGET要求
	String list(Model model) {
	model.addAttribute("books", bookService.findAll());
	return "books/list";
	}
	@PostMapping(path="create")//books/createにPOST要求
	String create(BookForm form, Model mode) {
	bookService.create(form);
	return "redirect:/books";
	}
	@PostMapping(path = "edit", params = "form")   //books/ceditにパラメタformを含むPOST要求
	String editForm(@RequestParam Integer id, BookForm form) {
	BookForm bookForm = bookService.findOne(id);
	BeanUtils.copyProperties(bookForm, form);
	return "books/edit";
	}
	@PostMapping(path = "edit")    //books/editにPOST要求
	String edit(@RequestParam Integer id, BookForm form) {
	bookService.update(form);
	return "redirect:/books";
	}
	@PostMapping(path = "delete")   //books/deleteにPOST要求
	String delete(@RequestParam Integer id) {
	bookService.delete(id);
	return "redirect:/books";
	}
	@PostMapping(path = "edit", params = "goToTop")//books/ceditにパラメタformを含むPOST要求
	String goToTop() {
	return "redirect:/books";
	}
}




