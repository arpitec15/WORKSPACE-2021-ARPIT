import React from "react";

interface IProps{}

interface IState{}

class Second extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
    };
    render(){
        return(
            <h1>Second !!!</h1>
        )
    }
};

export default Second;