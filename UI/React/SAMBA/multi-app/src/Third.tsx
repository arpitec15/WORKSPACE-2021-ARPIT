import React from "react";

import First from "./First";

import Second from "./Second";

interface IProps{}

interface IState{}

class Third extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
    };
    render(){
        return(
            <React.Fragment>
                <First></First>
                <Second></Second>
            </React.Fragment>
        )
    };
};




export default Third;