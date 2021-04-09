import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import State from "./State";
import First from "./First";
//import Parent from "./Parent";

//31-03-2021
import Parent from "./31-03-2021/Parent";
import Demo1 from "./31-03-2021/Demo1";
import Login from "./05-04-2021/Login"


ReactDOM.render(
  <React.StrictMode>
    <Login />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
