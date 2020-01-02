package jack.springboot.springboot_20180427.dao;

import jack.springboot.springboot_20180427.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
//import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

//    @Query
    List<Book> findByReader(String reader);

}
