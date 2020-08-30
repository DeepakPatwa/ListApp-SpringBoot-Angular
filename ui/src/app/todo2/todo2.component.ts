import { Component, OnInit } from '@angular/core';
import { TodoService } from '../todo.service';
import { Todo } from '../todo';
import { PageEvent } from '@angular/material/paginator';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-todo2',
  templateUrl: './todo2.component.html',
  styleUrls: ['./todo2.component.css']
})
export class Todo2Component implements OnInit {

  totalElements: number = 0;
  todos: Todo[] = [];
  loading: boolean;
  startFc = new FormControl();
  endFc = new FormControl();

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.getTodos({ page: "0", size: "10" });
  }

  private getTodos(request) {
    console.log("in get todos");
    this.loading = true;
    this.todoService.listTodos(request)
      .subscribe(data => {
        this.todos = data['content'];
        this.totalElements = data['totalElements'];
        this.loading = false;
      }, error => {
        this.loading = false;
      });
  }

  nextPage(event: PageEvent) {
    const request = {};
    request['page'] = event.pageIndex.toString();
    request['size'] = event.pageSize.toString();
    this.getTodos(request);
  }

  checkValidation(start, end){
    if(start>end)
      {
        alert("starting Id can't be grater than ending Id");
        return false;
      }
    else
    {
      return true;
    }
  }

  refreshData(){
    const start = this.startFc.value;
    const end = this.endFc.value;
    console.log("start: "+ start + "end: "+ end);

    if(this.checkValidation(start, end)){

    const request = {start: start, end: end};
    console.log("in get todos");
    this.loading = true;
    this.todoService.refreshListTodos(request)
      .subscribe(data => {
        this.todos = data['content'];
        this.totalElements = data['totalElements'];
        this.loading = false;
      }, error => {
        this.loading = false;
      });
  }
}
}
