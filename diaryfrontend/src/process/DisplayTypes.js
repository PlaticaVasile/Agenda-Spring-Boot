import React, { useState, useEffect } from 'react';

function RadioButtons() {
    const [types, setTypes] = useState([]);
    const [selectedType, setSelectedType] = useState('');

    useEffect(() => {
        // Fetch data from localhost:8080/user/type
        fetch('http://localhost:8080/user/type')
            .then(response => response.json())
            .then(data => {
                // Assuming the response data is an array of strings representing types
                setTypes(data);
                // Set the default selected type
                if (data.length > 0) {
                    setSelectedType(data[0]);
                }
            })
            .catch(error => console.error('Error fetching types:', error));
    }, []);

    const handleTypeChange = (e) => {
        setSelectedType(e.target.value);
    };

    return (
        <div>
            <label>User Type:</label><br />
            {types.map((type, index) => (
                <div key={index}>
                    <input
                        type="radio"
                        id={type}
                        name="type"
                        value={type}
                        checked={selectedType === type}
                        onChange={handleTypeChange}
                    />
                    <label htmlFor={type}>{type}</label><br />
                </div>
            ))}
        </div>
    );
}

export default RadioButtons;
