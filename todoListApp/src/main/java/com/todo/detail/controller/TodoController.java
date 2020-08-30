package com.todo.detail.controller;


        import com.todo.detail.model.Todo;
        import com.todo.detail.Repository.TodoRepository;
        import com.todo.detail.model.TodoRequest;
        import com.todo.detail.model.TodoResponse;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageImpl;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.server.ResponseStatusException;

        import java.util.List;
        import java.util.Optional;

        import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RequestMapping(path = "api/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TodoRequest todoRequest) {
        Todo saved = this.todoRepository.save(
                new Todo(todoRequest.getTask())
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("")
    public Page<TodoResponse> list(@RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "10") int size) {
        System.out.println("inside the get api");
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Todo> pageResult = todoRepository.findAll(pageRequest);
        List<TodoResponse> todos = pageResult
                .stream()
                .map(TodoResponse::new)
                .collect(toList());
        System.out.println(todos);

        return new PageImpl<>(todos, pageRequest, pageResult.getTotalElements());

    }

    @GetMapping("/dataRange")
    public Page<TodoResponse> listRange(@RequestParam(name = "start") int start,
                                   @RequestParam(name = "end") int end) {
        System.out.println("inside the get api");
        int size=end-start;
        PageRequest pageRequest = PageRequest.of(0, (int)end-start+1);
        Page<Todo> pageResult = todoRepository.findByIdBetween(start, end, pageRequest);
        List<TodoResponse> todos = pageResult
                .stream()
                .map(TodoResponse::new)
                .collect(toList());
        System.out.println(todos);

        return new PageImpl<>(todos, pageRequest, pageResult.getTotalElements());

    }
}
