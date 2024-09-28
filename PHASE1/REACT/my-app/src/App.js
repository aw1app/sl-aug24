import logo from './logo.svg';
import './App.css';
import { Component } from 'react';
import Product from './components/Product';

class App extends Component {

  render() {
    // any processing ....

    return (
      <div className="App">

        Hello React from a Class componet
        <br/>
        <Product></Product>
      </div>
    );

  }


}

export default App;
