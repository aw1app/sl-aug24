import { combineReducers } from "redux";
import { countReducer } from "../mystore";

const initialTodos = [];

const todoReducer = (state = initialTodos, action) => {

    switch (action.type) {
        case 'ADD_TODO':
            return [...state, action.payload];      
  
        case 'REMOVE_TODO':
            return state.filter(todo => todo.id !== action.payload);

        default:
            return state;
    }
};


const rootReducer = combineReducers({
    todoR: todoReducer,
    countR: countReducer
});

export default rootReducer;

