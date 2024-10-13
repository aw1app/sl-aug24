import './App.css';
import { useDispatch, useSelector } from 'react-redux';
import TodoList from './components/TodoList';

function AppForTodos() {

  const todos = useSelector(state => state.todoAdd);

  const dispatch = useDispatch();

  return (
    
    <div className="App">
      <h2>Redux Demo Project</h2>

       <TodoList todos={todos} removeTodo={ (id) => dispatch ( {type:'REMOVE_TODO', payload:id } ) }/>

    </div>
  );
}

export default AppForTodos;
