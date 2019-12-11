import React, { Component } from "react";

import axios from "axios";

class App extends Component {
  async componentDidMount() {
    const response = await axios.get("http://localhost:8080/api/users");
    console.log(response);
  }
  render() {
    return <div>Something!</div>;
  }
}

export default App;
