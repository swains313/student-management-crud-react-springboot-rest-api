import React from 'react'
import style from "./home.module.css"
import {Link} from "react-router-dom"

const Nav = () => {
  return (
    <div id={style.nav}>

        <Link to="/">Home</Link>

        <Link to="/studentlist">Student-List</Link>

        <Link to="/addstudent">Add-Student</Link>
        
    </div>
  )
}

export default Nav