import React from "react";

interface IState{
  sub:string;
}

interface IProps{}

class App extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
        this.state = {
            sub : "ReactJS"
        }
    }

    my_fun = ()=>{
        this.setState({
          sub : "ReactJS With TypeScript !!!"
        })
    };

    render(){
      return(
          <React.Fragment>
               <h1>{this.state.sub}</h1>
               <br></br>
               <button onClick={this.my_fun}>Change</button>  
          </React.Fragment>
      )
    };
};

export default App;