import React, { Component } from "react";
import axios from "axios";

export default class Sales extends Component {

    constructor(props){
        super(props);
    }

    componentDidMount(){

        let salesUrl="https://api.coindesk.com/v1/bpi/currentprice.json";
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