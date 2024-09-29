import { Component } from "react";
class ProductList extends Component {
    products = [
        {
            "id": "1",
            "name": "HP Laptop",
            "price": 100000,
            "description": "HP Gaming Laptop",
            "inStock": true,
            "imagePath": "images/111.png"
        },
        {
            "id": 0,
            "name": "Nokia 3305",
            "price": "5000",
            "description": "",
            "inStock": true,
            "imagePath": "images/222.png"
        },
        {
            "id": 0,
            "name": "Nokia 2000",
            "price": "10000",
            "description": "",
            "inStock": true,
            "imagePath": "images/222.png"
        }
    ];


    editProduct = (evt) => {
        console.log("IN editProduct");
    }

    render() {
        return (
            <div style={ {border:"solid 1px", "border-color": 'red'} } >
                <h2>PRODUCT LIST COMPONENT</h2>
                <table border="1">

                    {this.products.map( (product) => (
                        <tr> <td>{product.name}</td><td>{product.price}</td> 
                        <td> <button onClick={this.editProduct} >EDIT</button></td> </tr>
                    ))}

                </table>
            </div>
        )
    }
}
export default ProductList