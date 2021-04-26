import React, { Component } from "react";
import '../App.css';
import axios from "../axios";
export default class Department extends Component {

    constructor(props){
        super(props);
        this.state={
            employees:[],
            employee:{
                firstName:'',
                lastName:'',
                email:'',
                deptId:'',
                id:''
            },
            add:false,
            edit:false
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount(){
        let deptUrl="manager/employees";
        axios.get(deptUrl).then(response=>{
            this.setState({
                employees: response.data
            })
        })
       
    }

    handleChange(event) {
        event.preventDefault();
        const employee={...this.state.employee, [event.target.name]:event.target.value}
        this.setState(()=>({employee}));
       
      }
    
      handleSubmit(event) {
        event.preventDefault();
        let headers = {
            'content-type': `application/json`
        }
        axios.post("manager/employee", this.state.employee, headers)
        .then(response=>{
           console.log(response.data);
           const employees = this.state.employees.filter(employee => employee.id!=response.data);
           const employee = this.state.employee;
           employee.id=response.data;
           employees.push(employee);
           employees.sort((a, b) => a.id - b.id);
           this.setState({
            add:false,
            edit:false,
            employees: employees,
            employee:{
                firstName:'',
                lastName:'',
                email:'',
                deptId:'',
                id:''
            },
        })
        })
        
      }
      

    delete(id){
        let headers = {
            'content-type': `application/json`
        }
        axios.delete("manager/employee/"+id, this.state.employee, headers)
        .then(response=>{
            alert("Deleted "  + response.data);
            this.setState({
                add:false,
                edit:false,
                employees: this.state.employees.filter(employee => employee.id !== id),
                employee:{
                    firstName:'',
                    lastName:'',
                    email:'',
                    deptId:'',
                    id:''
                },
            })
        })
        
    }

    update(id){
        const employee = this.state.employees.find((e)=>e.id===id)
        console.log(employee)
        this.setState({
            add:false,
            edit:true,
            employee:{
                firstName: employee.firstName,
                lastName: employee.lastName,
                email: employee.email,
                deptId: employee.deptId,
                id: employee.id
            }
        },()=>{console.log(this.state)})
        
    }
    add(event){
        this.setState({
            add:!this.state.add,
            edit:false
        })
    }
    render(){
        return(
            <div>
                <p>Department Dept</p>
                
                {this.props.readOnly?null:  <button onClick={this.add.bind(this)}>Add</button>}
                {
                    this.state.add || this.state.edit ? 
                    <form onSubmit={this.handleSubmit}>
                         <label>
                        FirstName: 
                        <input type="text" name="firstName" value={this.state.employee.firstName} onChange={this.handleChange} />
                        </label>
                        <label>
                        Last Name: 
                        <input type="text" name="lastName" value={this.state.employee.lastName} onChange={this.handleChange} />
                        </label>
                        <label>
                        Email: 
                        <input type="text" name="email" value={this.state.employee.email} onChange={this.handleChange} />
                        </label>
                        <label>
                        Department Id: 
                        <input type="number" name="deptId" value={this.state.employee.deptId} onChange={this.handleChange} />
                        </label>
                        <input type="submit" value="Save" />
                    </form> 
                    : null
                }
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
                            <tr key={employee.id}>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td>
                                <td>{employee.deptId}</td>
                        {this.props.readOnly ? null : <td> <button onClick={this.update.bind(this,employee.id)}>Edit </button></td> }
                        {this.props.readOnly ? null : <td><button onClick={this.delete.bind(this,employee.id)}>Delete</button></td> }
                            </tr>
                            
                        )
                    })
                }
                </table>
            </div>
        );
    }
}