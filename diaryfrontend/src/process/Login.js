import React, { useState } from 'react';
import axios from 'axios';

export default function Login({ onLogin }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);

    const handleSubmit = async (event) => {
        event.preventDefault(); // Prevent default form submission behavior

        try {
            // Send data to the server
            const response = await axios.post('http://localhost:8080/user/login', {
                username: username,
                password: password
            });

            // Handle the response
            onLogin(username, response.data);
            setResponseData(response.data);
            setError(null);
            setUsername('');
            setPassword('');

        } catch (error) {
            // Handle errors
            onLogin(null, null);
            console.error('Error:', error);
            setResponseData(null);
            setError('An error occurred while sending data to the server.');
        }
    };

    return (
        <div className="d-flex justify-content-center align-items-center" style={{ minHeight: "10vh" }}>
            <div>
                <h2>Login</h2>
                <div style={{ maxWidth: "300px" }}>
                    <form onSubmit={handleSubmit} id='login-form'>
                        <div className="mb-2">
                            <label className='ml-4 pr-2'>
                                Username:
                                <input type="text" className="form-control" value={username} onChange={(e) => { setUsername(e.target.value); }} />
                            </label>
                        </div>
                        <div className="mb-2">
                            <label className='ml-4 pr-2'>
                                Password:
                                <input type="password" className="form-control" value={password} onChange={(e) => { setPassword(e.target.value); }} />
                            </label>
                        </div>
                        <button type="submit" className='mt-2 btn btn-primary'>Login</button>
                    </form>
                    {responseData && (
                        <div>
                            <h3>Response from Server:</h3>
                            <pre>{JSON.stringify(responseData, null, 2)}</pre>
                        </div>
                    )}
                    {error && <div className="ml-4 text-danger">Error: {error}</div>}
                </div>
            </div>
        </div>
    );
    
}
