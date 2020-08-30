package com.todo.detail;

import com.todo.detail.Repository.TodoRepository;
import com.todo.detail.model.Todo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DetailApplication {

    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DetailApplication.class, args);
    }
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
        todoRepository.deleteAll();

        todoRepository.save(new Todo("task 1" , false));
        todoRepository.save(new Todo("task 2" , false));
        todoRepository.save(new Todo("task 3" , true));
        todoRepository.save(new Todo("task 4" , true));
        todoRepository.save(new Todo("task 5" , false));
        todoRepository.save(new Todo("task 6" , false));
        todoRepository.save(new Todo("task 7" , true));
        todoRepository.save(new Todo("task 8" , true));
        todoRepository.save(new Todo("task 9" , true));
        todoRepository.save(new Todo("task 10" , true));
        todoRepository.save(new Todo("task 11" , true));
        todoRepository.save(new Todo("task 12" , true));
        todoRepository.save(new Todo("task 13" , false));
        todoRepository.save(new Todo("task 14" , false));
        todoRepository.save(new Todo("task 15" , false));
        todoRepository.save(new Todo("task 16" , false));
        todoRepository.save(new Todo("task 17" , true));
        todoRepository.save(new Todo("task 18" , false));
        todoRepository.save(new Todo("task 19" , false));
        todoRepository.save(new Todo("task 20" , false));
        todoRepository.save(new Todo("task 21" , false));
        todoRepository.save(new Todo("task 22" , false));
        todoRepository.save(new Todo("task 23" , true));
        todoRepository.save(new Todo("task 24" , false));
        todoRepository.save(new Todo("task 25" , false));
        todoRepository.save(new Todo("task 26" , false));
        todoRepository.save(new Todo("task 27" , true));
        todoRepository.save(new Todo("task 28" , false));
        todoRepository.save(new Todo("task 29" , false));
        todoRepository.save(new Todo("task 30" , true));
        todoRepository.save(new Todo("task 31" , false));
        todoRepository.save(new Todo("task 32" , false));
        todoRepository.save(new Todo("task 34" , false));
        todoRepository.save(new Todo("task 35" , false));
        todoRepository.save(new Todo("task 36" , true));
        todoRepository.save(new Todo("task 37" , false));
        todoRepository.save(new Todo("task 38" , true));
        todoRepository.save(new Todo("task 39" , false));
        todoRepository.save(new Todo("task 40" , false));
        todoRepository.save(new Todo("task 41" , false));
        todoRepository.save(new Todo("task 42" , true));
        todoRepository.save(new Todo("task 43" , false));
        todoRepository.save(new Todo("task 44" , true));
        todoRepository.save(new Todo("task 45" , false));
        todoRepository.save(new Todo("task 46" , false));
        todoRepository.save(new Todo("task 47" , false));
        todoRepository.save(new Todo("task 48" , true));
        todoRepository.save(new Todo("task 49" , true));
        todoRepository.save(new Todo("task 50" , true));
        };
    }
}
