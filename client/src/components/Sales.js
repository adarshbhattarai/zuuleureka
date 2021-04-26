import React, { Component } from "react";
import axios from "../axios";

export default class Sales extends Component {

    constructor(props){
        super(props);
    }

    componentDidMount(){
        let salesUrl="sales/orders";
        axios.get(salesUrl).then(response=>{
            console.log(response)
        })
    }
    render(){
        return(
            <div>
                <p>Sales Dept</p>
            </div>
        );
    }

}