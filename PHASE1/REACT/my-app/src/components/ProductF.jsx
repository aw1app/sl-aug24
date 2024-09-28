import { useState } from "react"

const XYZ = <h1> WELCOME </h1>;

const ProductF = (props) => {


    // State hook
    const [name, setName] = useState('');
    const [discount, setDiscount] = useState(10);
    const [inStock, setInsStock] = useState(props.avl);


    return (

        <div>

            {XYZ}
            <p>  Name is {props.name} </p>
            <p>  Name is {name} </p>
            <p> value of productPrice is {props.price} </p>
            <p> Discount on this product is {discount} </p>
            <p>  Availble: {inStock === "true" ? "YES" : "NO"} </p>

        </div>

    )

}

export default ProductF;