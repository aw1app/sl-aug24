import { useState } from "react"

const ProductF = ( props ) =>{

    // State hook
     const [discount, setDiscount] = useState(10);
     const [inStock, setInsStock] = useState(props.avl);

    
    return (

        <div>

            {/* <p> value of x is {x} </p> */}
            <p> value of productName is {props.name} </p>
            <p> value of productPrice is {props.price} </p>
            <p> Discount on this product is {discount} </p>
            <p>  Availble: {inStock ==="true" ? "YES": "NO"} </p>

        </div>

    )

}

export default ProductF;