import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const AddStudent = () => {

    let[firstName,setFirstname]=useState("")
    let[lastName,setLastname]=useState("")
    let[gender,setGender]=useState("")
    let[age,setAge]=useState("")
    let[gmail,setGmail]=useState("")

    let navigate=useNavigate()



    let saveEmployee=(e)=>{
        e.preventDefault()
        let student={firstName,lastName,gender,age,gmail}
        console.log(JSON.stringify(student));
       
        axios.post("http://localhost:8080/api/v1/students",student)
        .then(()=>{
            
        })
        navigate("/studentlist")

    }

  return (
    <div style={{background:"linear-gradient(white,rgb(23, 146, 173)", height:"85vh"}}>
        <br /><br />
        <div className='container'>
          <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
           
              <h3 className='text-center'>Add Student</h3>

              <div className='card-body'>
                <form>
                  <div className='form-group'>
                    <label htmlFor="">First Name</label>
                    <input type="text" name='firstName' placeholder='First Name' className='form-control' 
                    value={firstName} onChange={(e)=>{setFirstname(e.target.value)}} />
                  </div>

                  <div className='form-group'>
                    <label htmlFor="">Last Name</label>
                    <input type="text" name='lastName' placeholder='Last Name' className='form-control' 
                     value={lastName} onChange={(e)=>{setLastname(e.target.value)}}    />
                  </div>

                  <div className='form-group'>
                    <label htmlFor="">Gender  </label><br />

                    <input type="radio" name="gender"   className='form-control'      value="male"  onChange={(e)=>{setGender(e.target.value)}}  /> Male &ensp;
                    <input type="radio" name="gender" className='form-control'        value="female"  onChange={(e)=>{setGender(e.target.value)}}   /> Female
                  </div>
                  <div className='form-group'>
                    <label htmlFor="">Age</label>
                    <input type="number" name='age' placeholder='Age' className='form-control'
                    value={age} onChange={(e)=>{setAge(e.target.value)}}  />
                  </div>

                  <div className='form-group'>
                    <label htmlFor="">Email Id</label>
                    <input type="text" name='gmail' placeholder='Email Id' className='form-control'
                    value={gmail} onChange={(e)=>{setGmail(e.target.value)}}  />
                  </div>

                <button className='btn btn-success' onClick={saveEmployee}>Save</button>
                  {/* <button className='btn btn-danger' onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button> */}



                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
  )
}

export default AddStudent