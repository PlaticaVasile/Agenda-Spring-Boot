import React, { useState } from 'react';
import axios from 'axios';
import DisplayTypes from './DisplayTypes';

export default function Signup({ onSignup }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    const [type, setType] = useState('Standard');
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);

    const handleSubmit = async (event) => {
        event.preventDefault(); // Prevent default form submission behavior

        try {
            // Send data to the server
            const response = await axios.put('http://localhost:8080/user/add', {
                username: username,
                password: password,
                email: email,
                type: type
            });

            // Handle the response
            onSignup(username, response.data);
            setResponseData(response.data);
            setError(null);
            setUsername(''); setPassword(''); setEmail(''); setType('');

        } catch (error) {
            // Handle errors
            onSignup(null, null);
            console.error('Error:', error);
            setResponseData(null);
            setError('An error occurred while sending data to the server.');
        }
    };

    return (
        <div className="d-flex justify-content-center align-items-center" style={{ minHeight: "10vh" }}>
            <div className="ml-4">
                <h2>Signup</h2>
                <div style={{ maxWidth: "300px" }}>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-2">
                            <label className='ml-4 pr-2'>
                                Email:
                                <input type="email" className="form-control" value={email} onChange={(e) => setEmail(e.target.value)} />
                            </label>
                        </div>
                        <div className="mb-2">
                            <label className='ml-4 pr-2'>
                                Username:
                                <input type="text" className="form-control" value={username} onChange={(e) => setUsername(e.target.value)} />
                            </label>
                        </div>
                        <div className="mb-2">
                            <label className='ml-4 pr-2'>
                                Password:
                                <input type="password" className="form-control" value={password} onChange={(e) => setPassword(e.target.value)} />
                            </label>
                        </div>
                        <DisplayTypes /><br />
                        <button type="submit" className='btn btn-primary'>Sign Up</button>
                    </form>
                    {responseData && (
                        <div>
                            <h3>Response from Server:</h3>
                            <pre>{JSON.stringify(responseData, null, 2)}</pre>
                        </div>
                    )}
                    {error && <div className="text-danger">Error: {error}</div>}
                </div>
            </div>
        </div>
    );
        
}
