import { useReducer } from 'react';
import {countReducer, initialState} from '../reducers/counterReducer';

function Counter() {
// OR line 3 can be Counter = () => {

    const [state, dispatch] = useReducer(countReducer, initialState);

    return (
        <div>
            <p> INSIDE COUNTER COMPONENT</p>
            <h3>Count: {state.count}</h3>

            <button onClick={() => dispatch({ type: 'increment' })}> + </button>
            <button onClick={() => dispatch({ type: 'decrement' })}> - </button>
        </div>
    );
}

export default Counter;