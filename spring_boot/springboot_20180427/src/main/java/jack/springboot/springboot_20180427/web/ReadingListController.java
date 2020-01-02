package jack.springboot.springboot_20180427.web;

import jack.springboot.springboot_20180427.dao.BookRepo;
import jack.springboot.springboot_20180427.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    private BookRepo bookRepo;

    @Autowired
    public ReadingListController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/{reader}")
    public String readersBooks(@PathVariable(name = "reader") String reader, Model model) {
        List<Book> books = bookRepo.findByReader(reader);
        if (books != null) {
            model.addAttribute("books", books);
        }
        return "readinglist";
    }

    @PostMapping("/{reader}")
    public String addToReadinglist(@PathVariable(name = "reader") String reader, Book book) {
        book.setReader(reader);
        bookRepo.save(book);
        return "redirect:/{reader}";
    }


}
