import logo from './logo.svg';
import './App.css';
import { Component } from 'react';

import ThemedButton from './components/ThemedButton';
import ThemeProvider from './contexts/ThemeProvider'

class AppDemoContext extends Component {

  render() {


    return (
      <div>

        <ThemeProvider>
          <ThemedButton title="Buy"/> &nbsp;&nbsp;
          <ThemedButton title="Sell"/>
          
        </ThemeProvider>
      </div>
    );

  }

}

export default AppDemoContext;
