import React, { Component } from "react";
import '../App.css';
export default class Department extends Component {

    constructor(props){
        super(props);
        this.state={
            employees:[]
        }
    }
    render(){
        return(
            <div>
                <p>Department Dept</p>
            </div>
        );
    }
}