import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// import store from './mystore';
import { Provider } from 'react-redux';

import AppForTodos from './AppForTodos';
import todostore from './stores/todostore';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <Provider store={store}>
    <App />
    </Provider> */}


<Provider store={todostore}>
    <AppForTodos />
    </Provider>

  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
