import React from "react";

interface IProps{}

interface IState{}

class First extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
    };
    render(){
        return(
            <h1>First !!!</h1>
        )
    };
};

export default First;