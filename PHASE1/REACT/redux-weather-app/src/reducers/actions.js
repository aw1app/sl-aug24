import axios from "axios";

// actions.js
export const FETCH_WEATHER_REQUEST = 'FETCH_WEATHER_REQUEST';
export const FETCH_WEATHER_SUCCESS = 'FETCH_WEATHER_SUCCESS';
export const FETCH_WEATHER_FAILURE = 'FETCH_WEATHER_FAILURE';


export const fetchWeather = (city) => {
    return async (dispatch) => {
        
        dispatch({ type: FETCH_WEATHER_REQUEST }); // Dispatch request action

        try {
            const response = await axios.get(`https://api.openweathermap.org/data/2.5/weather?q=${city}&APPID=c706e8c31d7e3e0fcdbb5761d05d6907`);
            dispatch({ type: FETCH_WEATHER_SUCCESS, payload: response.data }); // Dispatch success action with data
        } catch (error) {
            dispatch({ type: FETCH_WEATHER_FAILURE, payload: error.message }); // Dispatch failure action with error message
        }
    };
};


