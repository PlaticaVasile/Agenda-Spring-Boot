import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar({ onLogout }) {
  const handleLogout = () => {
    // Call the onLogout function passed from the parent component
    onLogout();
  };
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
          <Link className='btn btn-outline-light' onClick={handleLogout} to="/">Log out</Link>
        </div>
      </nav>
    </div>
  )
}