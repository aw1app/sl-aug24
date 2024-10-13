import { createStore } from "redux";


const initialState = {
    count: 0,
    x: 'Hello'
};


export function countReducer(state = initialState, action) {

    switch (action.type) {
        case 'increment':

            return { ...state, count: state.count + 1 };

        case 'decrement':

            return { ...state, count: state.count - 1 };
            
        default:
            return state;
    }
}

const store = createStore(countReducer);

export default store;