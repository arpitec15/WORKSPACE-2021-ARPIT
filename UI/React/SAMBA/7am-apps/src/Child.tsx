import React from "react";
import Subchild from "./Subchild";

interface IProps{
    key1:string;
    key2:string;
    key3:number;
    key4:number;
    key5:number;
    key6:string;
    
}

interface IState{
    key7:string
}

class Child extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
        this.state = {
            key7 : "Hello"
        };
    }
    render(){
        return(
            <React.Fragment>
               <Subchild {...this.props}
                         key7={this.state.key7}></Subchild> 
            </React.Fragment>
        )
    };
};

export default Child;