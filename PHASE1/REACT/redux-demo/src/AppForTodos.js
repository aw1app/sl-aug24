import './App.css';
import { useDispatch, useSelector } from 'react-redux';
import TodoList from './components/TodoList';
import AddTodoForm from './components/AddTodoForm';

function AppForTodos() {

  const todos = useSelector(state => state.todoR);

  const dispatch = useDispatch();

  const removeTodo = (id) => dispatch ( {type:'REMOVE_TODO', payload: id } );

  const addTodo = (todoObj) => dispatch ( {type:'ADD_TODO', payload: todoObj } );

  return (
    
    <div className="App">
      <h2>Redux Demo Project</h2>

       <TodoList todos={todos} removeTodo={ removeTodo }/>
       <br/>
       <p>Add a new Todo here:</p>
       <AddTodoForm addTodo={addTodo} />

    </div>
  );
}

export default AppForTodos;
