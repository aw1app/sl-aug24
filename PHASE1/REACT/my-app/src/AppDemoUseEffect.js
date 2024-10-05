import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from 'react';
import { Component } from 'react';

function AppDemoUseEffect(props) {

  const [products, setProducts] = useState(null);
  const [x,setX]= useState(10);
  const [y,setY]= useState(20);

  useEffect(

    () => {
      console.log("INSIDE USE EFFECT");
      fetch('http://localhost:5000/products')
        .then(response => response.json())
        .then(data => setProducts(data))
        .catch(error => console.error(error));
    }
 
  ,

  []
);

const handleYChange = () =>{
  console.log("INSIDE handleYChange");
  setY( prevVal => prevVal + 1);
}

const handleXChange= () =>{
  console.log("INSIDE handleXChange");
  setX( prevVal => prevVal + 1);
  // let idNo = 100;
  // products.push ( {
  //   "id": idNo++,
  //   "name": "Motorala " + (idNo++),
  //   "price": "50000",
  //   "description": "",
  //   "inStock": true,
  //   "imagePath": "images/222.png"
  // })
};

return ( 

  <div>
    {products ? (
      <ul>
        {products.map(item => (
          <li
            key={item.id}>{item.name}</li>
        ))}
      </ul>
    ) : (
      <p>Loading...</p>
    )}

    <button onClick={handleXChange}> Change X </button>
    <button onClick={handleYChange}> Change Y</button>
  </div>
)



}

export default AppDemoUseEffect;
