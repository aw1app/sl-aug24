import { useState } from "react"

const XYZ = <h1> WELCOME </h1>;

const Seller = (props) =>{

    return (
    
            <div> I am a Seller by name {props.name}</div>

    )


}

// const ProductF = ( { name,price, avl }) => {
const ProductF = (props) => {

    //props destructuring
    //const {name,price,avl} = props;


    // State hook
    const [name, setName] = useState('');
    const [discount, FFFFF] = useState(10);
    const [inStock, setInsStock] = useState(props.avl);


    //FFFFF(99);


    return (

        <div>

            {XYZ}
            <p>  Name is {props.name} </p>
            <p>  Name is {name} </p>
            <p> value of productPrice is {props.price} </p>
            <p> Discount on this product is {discount} </p>
            <p>  Availble: {inStock === "true" ? "YES" : "NO"} </p>

            <Seller name="Tulsi"></Seller>

        </div>

    )

}

export default ProductF;