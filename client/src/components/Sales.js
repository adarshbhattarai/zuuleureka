import React, { Component } from "react";
import axios from "../axios";

export default class Sales extends Component {

    constructor(props){
        super(props);
        this.state={
            orders:[],
            order:{
                quantity:'',
                customerId:'',
                itemName:'',
                totalCost:0
            },
            add:false
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount(){
        let salesUrl="sales/orders";
        axios.get(salesUrl).then(response=>{
            this.setState({
                orders: response.data,
                add:false,
            })
        })
    }

    handleChange(event) {
        event.preventDefault();
        const order={...this.state.order, [event.target.name]:event.target.value}
        this.setState(()=>({order}));
       
      }
    
      handleSubmit(event) {
        event.preventDefault();
        let headers = {
            'content-type': `application/json`
        }
        axios.post("sales/add", this.state.order, headers)
        .then(response=>{
           const order = this.state.order;
           let orders = [...this.state.orders];
           orders.push(order);
           this.setState({
            orders: orders,
            order:{
                quantity:'',
                customerId:'',
                itemName:'',
                totalCost:0
            },
            add:false
        })
        })
        
      }
    add(event){
        this.setState({
            add:!this.state.add,
        })
    }
    render(){
        return(
            <div>
            <p>Sales Dept</p>
            
                {this.props.readOnly?null:  <button onClick={this.add.bind(this)}>Add</button>}
                {
                    this.state.add? 
                    <form onSubmit={this.handleSubmit}>
                         <label>
                        Quantity: 
                        <input type="text" name="quantity" value={this.state.order.quantity} onChange={this.handleChange} />
                        </label>
                        <label>
                        Customer Id: 
                        <input type="text" name="customerId" value={this.state.order.customerId} onChange={this.handleChange} />
                        </label>
                        <label>
                        Item Name: 
                        <input type="text" name="itemName" value={this.state.order.itemName} onChange={this.handleChange} />
                        </label>
                        <label>
                        Total Cost: 
                        <input type="number" name="totalCost" value={this.state.order.totalCost} onChange={this.handleChange} />
                        </label>
                        <input type="submit" value="Save" />
                    </form> 
                    : null
                }
                <table>
                <tr>
                <th> Quantity </th>
                <th> CustomerID </th>
                <th> ItemName </th>
                <th>TotalCost</th>
                </tr>
                {
                this.state.orders.map(order=>{
                    return(
                        <tr>
                            <td>{order.quantity}</td>
                            <td>{order.customerId}</td>
                            <td>{order.itemName}</td>
                            <td>{order.totalCost}</td>
                        </tr>
                    )
                })
            }
            </table>
        </div>
        );
    }

}