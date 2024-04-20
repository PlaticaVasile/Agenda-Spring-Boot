import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { Navigate, BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Preprocess from './process/Preprocess';
import Signup from './process/Signup';
import Login from './process/Login';
import Diary from './users/Diary';
import React, { useState } from 'react';
import './App.css';


export default function App() {
  const [signup, setSignup] = useState(false);
  const [login, setLogin] = useState(false);
  const [route_signup, setRouteSignUp] = useState(false);
  const [route_login, setRouteLogIn] = useState(false);
  const [usernameDiary, setUsernameDiary] = useState(''); // State to store username for Diary
  //const navigate = useNavigate(); // Use useHistory hook

  const handleSignUp = () => {
    // Logic for handling sign-up action
    setSignup(true);
    setLogin(false);
    console.log('Sign Up');
  };

  const handleLogin = () => {
    // Logic for handling login action
    setSignup(false);
    setLogin(true);
    console.log('Log In');
  };


  const handleSignup1 = (username, message) => {
    // Do something with the updated values
    console.log('sign up username:', username);
    console.log('sign up message:', message);
    if (message === "New field added with success") {
      setRouteSignUp(true);
      //navigate('/diary');
      setUsernameDiary(username);
    }
    else {
      setRouteSignUp(false);
      setUsernameDiary("default");
    }
  };

  const handleLogin1 = (username, message) => {
    // Do something with the updated values
    console.log('log in username:', username);
    console.log('log in message:', message);
    if (message === "Login successful!") {
      setRouteLogIn(true)
      //navigate('/diary');
      setUsernameDiary(username);
    }
    else {
      setRouteLogIn(false);
      setUsernameDiary("default");
    }
  };


  const handleLogout = () => {
    // Reset all state values to their initial state
    setSignup(false);
    setLogin(false);
    setRouteSignUp(false);
    setRouteLogIn(false);
    setUsernameDiary('');
  };

  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home/>}></Route>
          <Route exact path="/diary" element={<Diary usernameDiary={usernameDiary} />}></Route>
        </Routes>
        <div id='auth-area' style={{ display: (route_login || route_signup) ? 'none' : 'block' }}>
          <Preprocess handleSignUp={handleSignUp} handleLogin={handleLogin} />
          {signup && <Signup onSignup={handleSignup1} />}
          {login && <Login onLogin={handleLogin1} />}
        </div>
        <div>
          {(route_login || route_signup) && <Navigate to="/diary" />}
        </div>
      </Router>
    </div>
  );
}