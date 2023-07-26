import logo from './logo.svg';
import './App.css';
import {OrderList} from "./component/OrderList";
import React from "react";
import {Routes, Route} from 'react-router-dom'
import {Pagination} from "./component/Pagination";
import {CreateButton} from "./component/CreateButton";
import {CreateOrderForm} from "./component/CreateOrderForm";

function App() {
  return (
    <>
        <Routes>
            <Route path='/' element={<OrderList/>}>
                <Route path='/' element={<Pagination/>}/>
            </Route>
            <Route path='/create-order' element={<CreateOrderForm/>}/>
        </Routes>
    </>
  );
}

export default App;
