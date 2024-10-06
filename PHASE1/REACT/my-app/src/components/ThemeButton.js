import React, { useContext } from 'react';
import ThemeContext from '../contexts/ThemeContext';


const ThemedButton = (props) => {
  const { theme, toggleTheme } = useContext(ThemeContext); // Access context values


  return (
    <button
      onClick={toggleTheme}
      style={{
        backgroundColor: theme === 'light' ? '#fff' : '#333',
        color: theme === 'light' ? '#000' : '#fff',
        padding: '10px 20px',
      }}
    >
     { props.title}
    </button>
  );
};

export default ThemedButton;
