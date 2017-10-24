package todoexample;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringComponent
public class TodoList extends VerticalLayout {

    @Autowired
    TodoRepository todoRepository;

    @PostConstruct
    void init() {
        update();
    }

    private void update() {
        setTodos(todoRepository.findAll());
    }

    private void setTodos( List<Todo> todoList ) {
        removeAllComponents();

        todoList.forEach(todo -> addComponent(new TodoLayout(todo)));
    }

    void add( Todo todo ) {
        todoRepository.save(todo);
        update();
    }

    void deleteCompleted() {
        todoRepository.deleteByDone(true);
        update();
    }
}
