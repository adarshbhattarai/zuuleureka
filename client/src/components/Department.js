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
        let salesUrl="manager/employees";
        axios.get(salesUrl).then(response=>{
            console.log(response)
        })
       
    }
    render(){
        return(
            <div>
                <p>Department Dept</p>
            </div>
        );
    }
}