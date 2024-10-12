
function Counter(props) {

    

    return (
        <div>
            <p> INSIDE COUNTER COMPONENT</p>
            <h3>Count: {props.count}</h3>

            <button onClick={props.increment}> +1 </button>
            <button onClick={props.decrement}> -1 </button>

        </div>
    );
}

export default Counter;