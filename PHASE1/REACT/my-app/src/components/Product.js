import { Component } from 'react';

class Product extends Component {
     productName = "Samsung Mobile";

    render() {
        let x = 10;

        return (

            <div>

            <p> value of x is {x} </p>
            <p> value of productName is {this.productName} </p>

            </div>

        )

    }

}

export default Product;