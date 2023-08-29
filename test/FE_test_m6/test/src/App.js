import './App.css';
import React from "react";
import {Routes, Route} from 'react-router-dom'

import {PenaltyList} from "./component/PenaltyList";
import {CreatePlayer} from "./component/CreatePlayer";
import {Top5} from "./component/Top5";

function App() {
  return (
    <>
        <Routes>
            {/*<Route path='/' element={<OrderList/>}>*/}
            {/*    <Route path='/' element={<Pagination/>}/>*/}
            {/*</Route>*/}
            <Route path='/' element={<PenaltyList/>}/>
            <Route path='/create' element={<CreatePlayer/>}/>
            <Route path='/top5' element={<Top5/>}/>
        </Routes>
    </>
  );
}

export default App;
