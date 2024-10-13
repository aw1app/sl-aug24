import './App.css';
import { useDispatch, useSelector } from 'react-redux';
import TodoList from './components/TodoList';

function AppForTodos() {

  const todos = useSelector(state => state.todoR);

  const dispatch = useDispatch();

  const removeTodo = (id) => dispatch ( {type:'REMOVE_TODO', payload: id } );

  return (
    
    <div className="App">
      <h2>Redux Demo Project</h2>

       <TodoList todos={todos} removeTodo={ removeTodo }/>

    </div>
  );
}

export default AppForTodos;
