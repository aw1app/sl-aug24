import React, { useState } from 'react';

function WeatherForm({ onSubmit }) {
  const [city, setCity] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(city);  // Call the onSubmit function passed as a prop
  };

  return (
    <form onSubmit={handleSubmit}>
      <input 
        type="text" 
        value={city} 
        onChange={(e) => setCity(e.target.value)} 
        placeholder="Enter city" 
      />
      <button type="submit">Get Weather</button>
    </form>
  );
}

export default WeatherForm;
