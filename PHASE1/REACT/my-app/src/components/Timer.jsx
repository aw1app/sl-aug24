
import { Component } from "react";


class Timer extends Component {

    constructor(props) {
        console.log("INSIDE constructor");

        super(props);
        this.state = {
          seconds: 0
        };
      }
      
      componentDidMount() {
        console.log("INSIDE componentDidMount");

        this.intervalId = setInterval(() => {
          this.setState(prevState => ({
            seconds: prevState.seconds + 1
          }));
        }, 1000);
      }

      componentWillUnmount() {
        clearInterval(this.intervalId);
      }


      render() {
        console.log("INSIDE render");

        return (
          <div>
            <h1>Timer: {this.state.seconds} seconds</h1>
            <button onClick={() => this.setState({ seconds: 0 })}>Reset</button>
          </div>
        );
      }
      

}

export default Timer;