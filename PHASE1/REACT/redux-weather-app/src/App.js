import logo from './logo.svg';
import './App.css';
import store from './store';

function App() {
  return (
    <div className="App">
       <Provider store={store}>
        
       </Provider>
    </div>
  );
}

export default App;
