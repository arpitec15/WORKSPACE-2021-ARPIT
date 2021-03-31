import React, { Component } from "react";
import Child from "./Child";

interface IProps{}

interface IState{
    name : string;
    address : string;
    course : string;
}

class Parent extends Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
        this.state = {
            name : "AshokIT",
            address : "Hyderabad",
            course : "ReactJS"
        }
    };

    myfun = ()=>{
       this.setState({
           name : "Ashok",
           address:"Hyd",
           course:"ReactJS With TypeScript !!!"
       })
    };
   

    render(){
        return(
            <React.Fragment>
                <Child
                  key1={this.state.name}
                  key2={this.state.address}
                  key3={this.state.course}
                  key4={this.myfun}></Child>
            </React.Fragment>
        )
    };
};

export default Parent;