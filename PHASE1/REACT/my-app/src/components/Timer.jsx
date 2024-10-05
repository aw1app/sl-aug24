
import { Component } from "react";


class Timer extends Component {

  constructor(props) {
    console.log("INSIDE constructor");

    super(props);
    this.state = {
      seconds: 0,
      maxSeconds: 15
    };
  }

  componentWillMount() {
    console.log("INSIDE componentWillMount");
  }

  componentDidMount() {
    console.log("INSIDE componentDidMount");

    this.intervalId = setInterval(() => {
      this.setState(prevState => ({
        seconds: prevState.seconds + 1
      }));
    }, 1000);
  }

    shouldComponentUpdate(nextProps, nextState) {
      if (nextState.seconds < this.state.maxSeconds)
        return true;
      else
        return false;
    }
  

  componentWillUnmount() {
    clearInterval(this.intervalId);
  }


  render() {
    console.log("INSIDE render");

    return (
      <React.Fragment>
        <h1>Timer V2: {this.state.seconds} seconds</h1>
        <button onClick={() => this.setState({ seconds: 0 })}>Reset</button>
      </React.Fragment>
    );
  }

}

export default Timer;