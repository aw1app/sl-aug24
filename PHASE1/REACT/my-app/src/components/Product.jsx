import { Component } from 'react';

class Product extends Component {
    productName = "Samsung Mobile";
    productPrice = 0;



    constructor(props) {
        super(props);
        this.productName = this.props.name;
        this.productPrice = this.props.price;

        this.state = {
            discount:10,
            inStock: this.props.avl
        };
    }


    render() {
        let x = 10;

        return (

            <div>

                {/* <p> value of x is {x} </p> */}
                <p> value of productName is {this.productName} </p>
                <p> value of productPrice is {this.productPrice} </p>
                <p> Discount on this product is {this.state.discount} </p>
                <p>  Availble: {this.state.inStock ==="true" ? "YES": "NO"} </p>

            </div>

        )

    }

}

export default Product;