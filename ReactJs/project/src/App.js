import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Routes, Route } from "react-router-dom"
import Home from './component/Home';
import Nav from './component/Nav';
import AllStudent from './component/AllStudent';
import Footer from './component/Footer';
import AddStudent from './component/AddStudent';
import UpdateStudent from './component/UpdateStudent';

function App() {
  return (
    <div className="App">
   
   <BrowserRouter>
   <Nav></Nav>
   <Routes>
    <Route path='/' element={<Home/>}></Route>
    <Route path="/studentlist" element={<AllStudent/>}></Route>
   <Route path="/addstudent" element={<AddStudent/>}></Route>
   <Route path='/updatestudent/:id' element={<UpdateStudent/>}></Route>
   </Routes>
   <Footer/>
   </BrowserRouter>
   

    </div>
  );
}

export default App;
