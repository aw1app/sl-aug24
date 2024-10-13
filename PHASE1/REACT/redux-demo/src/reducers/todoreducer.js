import { combineReducers } from "redux";

const initialState = [{"id":1,"text":"Buy Groceries"}, {"id":2,"text":"Bring Kids from School"}];

const todoReducer = (state = initialState, action) => {

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
    todoR: todoReducer
});

export default rootReducer;

