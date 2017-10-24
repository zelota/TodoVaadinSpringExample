package todoexample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Boolean done;

    public Todo() {
        this("", false);
    }

    public Todo( String text ) {
        this(text, false);
    }

    public Todo( String text, Boolean done ) {
        this.text = text;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public Boolean isDone() {
        return done;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone( Boolean done ) {
        this.done = done;
    }

    public void toggleDone() {
        setDone(!isDone());
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj != null && this.id != null && obj instanceof Todo ) {
            Todo otherTodo = (Todo) obj;
            return this.id.equals(otherTodo.getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "org.home.todo.Todo[entity] id=" + this.id;
    }
}
