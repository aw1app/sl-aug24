import { createStore } from "react-redux";


const initialState = {
    count: 0
    };


    export function countReducer(state = initialState, action) {

        switch (action.type) {
            case 'increment':
                
                    return { count: state.count + 1 };
            case 'decrement':
               
                    return { count: state.count - 1 };
            default:
                throw new Error();
        }
    }

    const store = createStore(countReducer);

    export default store;