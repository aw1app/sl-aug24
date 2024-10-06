import { Component, useState } from "react";
import ThemeContext from "./ThemeContext";


 const ThemeProvider = (props) => {

      const [theme, setTheme] = useState('light');


      const toggleTheme = () => {
        setTheme( prevTheme => ( prevTheme === 'light' ? 'dark' : 'light'));
      };


      return(
        <ThemeContext.Provider value={ {theme,toggleTheme} }>

        {props.children}       

        </ThemeContext.Provider>
      )


}

export default ThemeProvider;