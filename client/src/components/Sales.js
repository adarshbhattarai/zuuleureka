import React, { Component } from "react";
import axios from "../axios";

export default class Sales extends Component {

    constructor(props){
        super(props);
        this.state={
            orders:[]
        }
    }

    componentDidMount(){
        let salesUrl="sales/orders";
        axios.get(salesUrl).then(response=>{
            this.setState({
                orders: response.data
            })
        })
    }
    render(){
        return(
            <div>
            <p>Sales Dept</p>
            
                <table>
                <tr>
                <th> Quantity </th>
                <th> CustomerID </th>
                <th> ItemName </th>
                <th>TotalCost</th>
                {this.props.readOnly?null:  <th>Delete</th>}
                </tr>
                {
                this.state.orders.map(order=>{
                    return(
                        <tr>
                            <td>{order.quantity}</td>
                            <td>{order.customerId}</td>
                            <td>{order.itemName}</td>
                            <td>{order.totalCost}</td>
                            {this.props.readOnly ? null : <td><button >Delete </button></td> }
                        </tr>
                        
                    )
                })
            }
            </table>
        </div>
        );
    }

}