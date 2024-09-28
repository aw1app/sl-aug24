import logo from './logo.svg';
import './App.css';
import { Component } from 'react';
import Product from './components/Product';
import ProductF from './components/ProductF';

class App extends Component {




  render() {
    // any processing ....

    return (
      <div className="App">

        <br/>
        <Product name="HP Laptop" price="10000" avl="true"> </Product>
        <Product name="Samsung Laptop" price="20000" avl="false"> </Product>

      <hr/>

        <ProductF name="F HP Laptop" price="1" avl="true"> </ProductF>
        <ProductF name="F Samsung Laptop" price="2" avl="false"> </ProductF>
      </div>
    );

  }


}

export default App;
