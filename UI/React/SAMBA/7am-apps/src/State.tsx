//declaration of state   ( interfaces )
//initilization of state ( constructor )
//access the state ( render() )  {}

import React from "react";

interface TusarState{
    car:string;
    money:number;
    home:string;
};

interface TusarProps{}

class State extends React.Component<TusarProps,TusarState>{
    constructor(props:TusarProps){
        super(props);
        this.state = {
            car : "audi",
            money : 10000000,
            home : "hyderbad"
        }
    }
    render(){
        return(
            <React.Fragment>
                <h1>Car Brand......{this.state.car}</h1>
                <h1>Money.....{this.state.money}</h1>
                <h1>Address......{this.state.home}</h1>
            </React.Fragment>
        )
    }
};

export default State;

