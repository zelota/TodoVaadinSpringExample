package todoexample;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Transactional
    void deleteByDone( Boolean done );
}
