import { createStore } from "redux";
import rootReducer from "../reducers/todoreducer";



const todostore = createStore(rootReducer);

export default todostore;