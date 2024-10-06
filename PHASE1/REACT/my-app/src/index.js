import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import AppDemoUseEffectAndDataFetching from './AppDemoUseEffectAndDataFetching'
import AppDemoRouter from './AppDemoRouter';


import reportWebVitals from './reportWebVitals';
import AppDemoContext from './AppDemoContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <>
    {/* <App /> */}
    {/* <AppDemoUseEffectAndDataFetching /> */}
    {/* <AppDemoRouter /> */}
    <AppDemoContext />
    </>
  </React.StrictMode>
);


reportWebVitals();

