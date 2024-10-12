
function Counter() {

    

    return (
        <div>
            <p> INSIDE COUNTER COMPONENT</p>
            <h3>Count: {state.count}</h3>

            <button onClick={() => dispatch({ type: 'increment' })}> +1 </button>
            <button onClick={() => dispatch({ type: 'decrement' })}> -1 </button>

        </div>
    );
}

export default Counter;