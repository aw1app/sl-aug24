import logo from './logo.svg';
import './App.css';
import { Component } from 'react';
import useCounter from './hooks/useCounter';

function AppDemoCustomHook() {

  //Use the custom hook we just created.
  const { count, increment, decrement } = useCounter(100);


  return (
    <div>
      <p> Demo Custom Hook  </p>
      <h3> Count : {count} </h3>

      <button onClick={increment}>+</button>
      <button onClick={decrement}>-</button>

    </div>
  );

}

export default AppDemoCustomHook;
