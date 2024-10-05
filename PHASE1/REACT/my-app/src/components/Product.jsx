import { Component } from 'react';

class Product extends Component {
    productName = "Samsung Mobile";
    productPrice = 0;



    constructor(props) {
        super(props);

        const { name, price } = this.props;
        this.productName = name;
        this.productPrice = price;

        // this.productName = this.props.name;
        //this.productPrice = this.props.price;

        this.state = {
            name: this.props.name,
            price: this.props.price,
            discount: 10,
            inStock: this.props.avl
        };

        this.xyz = this.buttonClicked.bind(this);
        this.nameInputChange = this.nameInputChange.bind(this);
        this.priceInputChange = this.priceInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        
    }

    buttonClicked(){
        console.log("BUTTON CLICKED ");
    }

    nameInputChange(evt){
        console.log("name  value CHANGED ");
        console.log(" value is  " + evt.target.value);

        this.setState( {name:evt.target.value} );
    }

    priceInputChange(evt){
        console.log("price value CHANGED ");
        console.log(" value is  " + evt.target.value);
        this.setState( {price:evt.target.value} );
    }

    handleSubmit(evt){
        console.log("INSIDE FORM SUBMIT HANDLER ");

        //prevent submission so that some validation can be done.
        evt.preventDefault();

    //validation
    // console.log(evt.target.name.value);
    // console.log(evt.target.price.value);
    }

    render() {
        let x = 10;

        //this.setState({ discount: 77 })

        return (

            <div>

                <h2> I am PRODUCT CLASS COMPONENT </h2>
                <p> value of productName is {this.state.name} </p>
                <p> value of productPrice is {this.state.price} </p>
                <p> Discount on this product is {this.state.discount} </p>
                <p>  Availble: {this.state.inStock === "true" ? "YES" : "NO"} </p>

                <form action="form-processing.php" method="POST" onSubmit={this.handleSubmit}>
                    NAME : <input type="text" name="name" value={this.state.name} onChange={this.nameInputChange}/>
                    <br/>
                    PRICE: <input type="text" name="price" value={this.state.price} onChange={this.priceInputChange}/>
                    <br/>
                    <input type="submit" />
                </form>
                
                <br/>
                <button onClick={this.xyz}>  Button Click! </button>

            </div>

        )

    }

}

export default Product;