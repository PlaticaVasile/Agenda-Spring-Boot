import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Note from './Note';


export default function Diary({ usernameDiary }) {

  const [allNotes, setAllNotes] = useState([]); 
  // State to store all notes
  const fetchNotes = async () => {
    try {
      const response = 
      await axios.post('http://localhost:8080/agenda/notes', {
        username: usernameDiary
      });
      if (Array.isArray(response.data)) {
        setAllNotes(response.data); 
        // Update allNotes state with the received data
      } else {
        console.error('Invalid data received:', response.data);
        setError('Invalid data received from the server.');
      }
    } catch (error) {
      console.error('Error fetching notes:', error);
      setError('An error occurred while fetching notes.');
    }
  };

useEffect(() => {
  // Update datetime la fiecare secunda
  const updateDateTime = () => {
    const now = new Date();
    const datetimeElement = document.getElementById('datetime');
    if (datetimeElement) {
      datetimeElement.textContent = now.toLocaleString();
    }
  };

  updateDateTime(); // Initial call
  const intervalId = setInterval(updateDateTime, 1000); 
  // Update la fiecare secunda

  return () => clearInterval(intervalId);
}, []);


const [username, setUsername] = useState('');
const [notes, setNotes] = useState('');
const [error, setError] = useState('');
const [view, setView] = useState(false);

const handleSubmit = async (event) => { 
  //submit paseaza datele pentru interogare(in cazul asta adaugare de field)
  event.preventDefault(); // Prevent default form submission behavior

  try {
    // Send data to the server
    const response = 
    await axios.put('http://localhost:8080/agenda/add-note', {
      username: usernameDiary,
      notes: notes
    });

    // Handle the response
    //setUsername(usernameDiary);
    setNotes("note added succesfully!!");
    fetchNotes();
    // Reload the page after notes are saved
    //window.location.reload();
  } catch (error) {
    // Handle errors
    console.error('Error:', error);
    setError('An error occurred while sending data to the server.');
    // Reload the page after notes are saved
    //window.location.reload();
  }
};

const btnClick = () => {
  if (view) {
    setView(false);
    console.log('Dont View user notes');
  }
  else {
    setView(true);
    console.log('View user notes');
  }
};

useEffect(() => {
  fetchNotes();
}, [usernameDiary]);

  return (
    <>
      <link
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        rel="stylesheet"
      />
      <div className="user-info">
        <span>User: {usernameDiary}</span>
        <br />
        <span id="datetime"></span>
      </div>
      <div className="container">
        <div className="row">
          <div className="col-md-8 offset-md-2">
            <form onSubmit={handleSubmit}>
              <textarea
                className="form-control"
                id="notepad"
                rows="10"
                value={notes}
                onChange={(e) => setNotes(e.target.value)}
              ></textarea>
              <button className='mt-2 mb-3 btn btn-primary' type='submit'>Save notes</button>
            </form>
            <div className="scrollable-notes">
              <button onClick={btnClick} className='btn btn-primary mb-3'>View all notes</button>
              <ul>
                {allNotes.map((note, index) => (
                  <div key={index} className="note" style={{ display: (view) ? 'block' : 'none' }}>
                    <div id="listCSS">
                      <li>
                        {view && <Note note={note} />} {/* Conditional rendering of Note component */}
                      </li>
                    </div>
                  </div>
                ))}
              </ul>
            </div>
          </div>
        </div>
      </div>
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </>
  );
}