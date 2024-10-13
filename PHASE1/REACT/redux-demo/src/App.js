import logo from './logo.svg';
import './App.css';
import { useDispatch, useSelector } from 'react-redux';
import Counter from './components/Counter';
import TodoList from './components/TodoList';

function App() {

  const count = useSelector(state => state.count);
  const myX = useSelector(state => state.x);

  const dispatch = useDispatch();

  return (
    
    <div className="App">
      <h2>Redux Demo Project</h2>

    <Counter count={count} 
     increment={ () => dispatch({ type: 'increment' })  } 
     decrement={ () => dispatch({ type: 'decrement' })  }
     />

    </div>
  );
}

export default App;
