package todoexample;

import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class TodoUI extends UI {

    @Autowired
    TodoList todoList;
    private VerticalLayout layout;

    @Override
    protected void init( VaadinRequest vaadinRequest ) {
        setupLayout();
        addHeader();
        addForm();
        addTodoList();
        addDeleteButton();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.TOP_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("TODO");
        header.setStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidth("80%");
        TextField taskField = new TextField();
        taskField.setWidth("100%");
        Button addButton = new Button("");
        addButton.setIcon(VaadinIcons.PLUS);
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        formLayout.addComponents(taskField, addButton);
        formLayout.setExpandRatio(taskField, 1);
        layout.addComponent(formLayout);

        addButton.addClickListener(event -> {
            if ( taskField.getValue() == null || taskField.getValue().isEmpty() ) {
                return;
            }
            todoList.add(new Todo(taskField.getValue()));
            taskField.clear();
            taskField.focus();
        });

        taskField.focus();
        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    private void addTodoList() {
        layout.addComponent(todoList);
    }

    private void addDeleteButton() {
        Button deleteButton = new Button("Delete", event -> todoList.deleteCompleted());
        layout.addComponent(deleteButton);
    }
}
