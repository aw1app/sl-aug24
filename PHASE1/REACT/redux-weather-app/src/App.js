import './App.css';
import store from './store';
import WeatherForm from './components/WeatherForm';
import Weather from './components/Weather';

import {useSelector, useDispatch, Provider } from 'react-redux';
import { fetchWeather } from './reducers/actions';

function App() {

  const dispatch = useDispatch();
  
  const weatherData = useSelector((state) => state.weatherData);
  const loading = useSelector((state) => state.loading);
  const error = useSelector((state) => state.error);

  const handleSubmit = (city) => {
    dispatch(fetchWeather(city));  // Dispatch the fetchWeather action
  };

  return (   
    
    <div className="App">
      <h1>Weather App</h1>

      <WeatherForm onSubmit={handleSubmit} />  

      <Weather loading={loading} weatherData={weatherData} error={error} /> 
        
      
    </div>

   
  );
}

export default App;
