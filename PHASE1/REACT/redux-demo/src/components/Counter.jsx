
function Counter( {count,increment, decrement  }) {

    

    return (
        <div>
            <p> INSIDE COUNTER COMPONENT</p>
            <h3>Count: {count}</h3>

            <button onClick={increment}> +1 </button>
            <button onClick={decrement}> -1 </button>

        </div>
    );
}

export default Counter;