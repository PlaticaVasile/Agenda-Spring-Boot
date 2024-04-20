import React from 'react';

const buttonStyle = {
  cursor: 'pointer',
  backgroundColor: '#53b5ff',
  color: 'white',
 
  transition: 'background-color 0.3s ease',
  border: '2px solid #007bff', // Added border with color

  padding: '0.5rem 1rem', // Adjusted padding for a smaller button
  borderRadius: '0.25rem', // Adjusted border radius
};

const buttonHoverStyle = {
  backgroundColor: '#0056b3',
};

const Heading = {
  fontSize: '1.3rem',
};

export default function Preprocess({ handleSignUp, handleLogin }) {
  return (
    <div className="d-flex justify-content-center align-items-center" style={{ minHeight: "5vh" }}>
      <div>
        <h1 style={Heading}>Choose method of authentication:</h1>
        <div style={{ ...buttonStyle }} onClick={handleSignUp}>Sign Up</div>
        <div style={{ ...buttonStyle}} onClick={handleLogin}>Log In</div>
      </div>
    </div>
  );
}
