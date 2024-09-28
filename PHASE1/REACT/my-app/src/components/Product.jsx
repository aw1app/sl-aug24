import { Component } from 'react';

class Product extends Component {
     productName = "Samsung Mobile";
     productPrice=0;

     constructor(props){
        super(props);
        this.productName = this.props.name;
        this.productPrice = this.props.price;
     }


    render() {
        let x = 10;

        return (

            <div>

            {/* <p> value of x is {x} </p> */}
            <p> value of productName is {this.productName} </p>
            <p> value of productPrice is {this.productPrice} </p>

            </div>

        )

    }

}

export default Product;