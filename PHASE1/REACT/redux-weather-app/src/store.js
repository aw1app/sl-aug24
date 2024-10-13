import { createStore, applyMiddleware } from 'redux';
import {thunk} from 'redux-thunk';
import weatherReducer from './reducers/reducers'; // Import the reducer

// Create the store with middleware
const store = createStore(weatherReducer, applyMiddleware(thunk));

export default store;

