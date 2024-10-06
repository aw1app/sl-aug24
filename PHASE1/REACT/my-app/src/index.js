import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import AppDemoUseEffectAndDataFetching from './AppDemoUseEffectAndDataFetching'
import AppDemoRouter from './AppDemoRouter';


import reportWebVitals from './reportWebVitals';
import AppDemoContext from './AppDemoContext';
import AppDemoUseReducer from './AppDemoUseReducer';
import AppDemoCustomHook from './AppDemoCustomHook';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <>
    {/* <App /> */}
    {/* <AppDemoUseEffectAndDataFetching /> */}

    {/* Mini Project */}
    <AppDemoRouter />
    
    {/* <AppDemoContext /> */}
    {/* <AppDemoUseReducer /> */}

    {/* <AppDemoCustomHook /> */}
    </>
  </React.StrictMode>
);


reportWebVitals();

