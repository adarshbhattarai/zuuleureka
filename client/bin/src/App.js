import logo from './logo.svg';
import './App.css';
import  Department from './components/Department';
import  Sales from './components/Sales';
import  Nav from './components/Nav';
import {BrowserRouter as Router,Switch, Route} from 'react-router-dom';

function App() {
  return (
    <Router>
    <div className="App">
        <Nav/>
        <Switch>
        <Route path="/" component={Home} exact></Route>
        <Route path="/department" component={Department} exact ></Route>
        <Route path="/sales" component={Sales} exact></Route>
        </Switch>
    </div>
    </Router>
  );
}

const Home = () => (
  <div>
    <h1>Home Page</h1>
    <div>
      <Department/>
    </div>
    <div>
      <Sales/>
    </div>
  </div>
)

export default App;
