import React, { Component } from 'react';


class App extends Component {
  constructor() {
    super();
    this.state = {
      students: [],
      name : ""
    }
  };

  
  com


  componentDidMount = () => {
    fetch("http://localhost:8080/api")
      .then(res => res.json())
      .then(json => this.setState({ students: json }
      ));
  }


  anyNamesYet = () => {
   return  this.state.students.length > 0 ? <h1> Here are the students</h1> : <h1>No students </h1>
  }

  render() {
    return (
      <div className="App" >
        {this.anyNamesYet()}
        {this.state.students.map(st => 
          <div key={st.id}>{st.name}</div>
        )}
        

      </div>
    );
  }
}


export default App;
