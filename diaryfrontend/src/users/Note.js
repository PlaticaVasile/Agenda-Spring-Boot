import React from 'react';

const Note = ({ note }) => {
  return (
    <div className="note-container"
      style={{ maxHeight: '50px', overflowY: 'auto'}}>
      {note}
    </div>
  );
};

export default Note;