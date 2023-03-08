import React, { useEffect, useState } from 'react'
import axios from "axios"
import { useNavigate, Link } from 'react-router-dom'


const AllStudent = () => {

    let [students,setStudents]=useState([])

    useEffect(()=>{
        axios.get("http://localhost:8080/api/v1/students")
        .then((response)=>{
            setStudents(response.data)
        })
    },[])

    let navigate=useNavigate()

    let deleteEmp=(id)=>{
        axios.delete(`http://localhost:8080/api/v1/students/${id}`)
        .then(()=>{
           window.location.assign("/studentlist")
           //window.location.reload(false);
        })
    }



  return (
    <div style={{background:"linear-gradient(white,rgb(23, 146, 173)", height:"85vh"}} >
    <div className='container'>
        <br />
        <div><h3>Employee List</h3></div>
        
                <div className='row'>
                <table className='table table-striped table-bordered'>
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Gender</th>
                            <th>Age</th>
                            <th>Email Id</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    {students.map((data)=>{
            return(
                    <tbody>
                                <tr>
                                    <td>{data.firstName}</td>
                                    <td>{data.lastName}</td>
                                    <td>{data.gender}</td>
                                    <td>{data.age}</td>
                                    <td>{data.gmail}</td>
                                    <td>
                                       {/* onClick={()=> this.updateEmp(employee.id)} */}
                                        <Link to={`/updatestudent/${data.id}`} > <button className='btn btn-info' >Update</button></Link>
                                         <button style={{marginLeft: "3px"}} className='btn btn-danger' onClick={()=> deleteEmp(data.id)}>Delete</button>
                                        {/* <Link  to="/viewemployee/${employee.id}" ><button className='btn btn-primary' style={{marginLeft: "10px"}}>View</button></Link> */}
    
                                    </td>
                                </tr>
                    </tbody>
                        )
                    })}
    
                </table>
    
            </div>
        
    </div>
    </div>
  )
}

export default AllStudent