import React from "react";
import {Link} from "react-router-dom"
import '../App.css';
function Nav(){

    const navStyle = {
        color:"white"
    }

    return (
        <nav> 
            <h3>Verizon-Zuul-Eureka-Microservice</h3>
            <u1 className='nav-Links'>
                <Link to="/" style={navStyle}> <li>Home</li> </Link>
                <Link to="/department" style={navStyle}> <li>Department</li> </Link>
                <Link to="/sales" style={navStyle}> <li>Sales</li> </Link>
            </u1>
        </nav>
    )
}

export default Nav;