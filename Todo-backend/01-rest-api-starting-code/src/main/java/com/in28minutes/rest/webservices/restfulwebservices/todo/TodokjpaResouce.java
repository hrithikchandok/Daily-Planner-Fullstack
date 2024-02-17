package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.todo.repository.TodoRepository;

@RestController
public class TodokjpaResouce {
       
	@Autowired 
	   private TodoService todoService;
	    
	
	@Autowired
	private TodoRepository todoRepository;
	
	  @GetMapping("/users/{username}/todos")
	   public List<Todo> gettodos(@PathVariable String username) {
		  return todoRepository.findByUsername(username);
//		      
	  }
	  
	  @GetMapping(value="/users/{usename}/todos/{id}")
	  public Optional<Todo> getTodos(@PathVariable int id)
	  {
		   return todoRepository.findById(id);
//		 return  todoService.findById(id);  
//		return null;    
		     
	  }       
	  
	  @DeleteMapping(value="/users/{usename}/todos/{id}")
	  public void deltodo(@PathVariable int id)
	  {   
		    todoRepository.deleteById(id);
//		   todoService.deleteById(id);  
		    
//		return null; 
		   
	  } 
	  
	  @PutMapping(value="/users/{username}/todos/{id}")
	  public Todo updatre(@PathVariable int id, @RequestBody Todo todo)
	  {
		  todoRepository.save(todo);
//		   todoService.updateTodo(todo);
		   
		   return todo;
	  }
	  
	  @PostMapping(value="/users/{username}/todos")
	  public Todo addTodo(@PathVariable String username, @RequestBody Todo todo)
	  {    
		  todo.setUsername(username);
		  todo.setId(null);
		  
		  return todoRepository.save(todo);
//		   return todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		   
	  }
	  
        	  
}
 