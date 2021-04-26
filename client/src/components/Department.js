import React, { Component } from "react";
import '../App.css';
import axios from "../axios";
export default class Department extends Component {

    constructor(props){
        super(props);
        this.state={
            employees:[]
        }
    }

    componentDidMount(){
        let deptUrl="manager/employees";
        axios.get(deptUrl).then(response=>{
            this.setState({
                employees: response.data
            })
        })
       
    }
    render(){
        return(
            <div>
                <p>Department Dept</p>
                
                    <table>
                    <tr>
                    <th> FirstName </th>
                    <th> LastName </th>
                    <th> Email </th>
                    <th>departmentId</th>
                    {this.props.readOnly?null:  <th>Edit</th>}
                    {this.props.readOnly?null:  <th>Delete</th>}
                    </tr>
                    {
                    this.state.employees.map(employee=>{
                        return(
                            <tr>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td>
                                <td>{employee.deptId}</td>
                        {this.props.readOnly ? null : <td> <button >Edit </button></td> }
                        {this.props.readOnly ? null : <td><button >Delete</button></td> }
                            </tr>
                            
                        )
                    })
                }
                </table>
            </div>
        );
    }
}