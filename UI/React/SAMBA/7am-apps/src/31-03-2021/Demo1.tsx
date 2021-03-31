import React, { Component } from "react";
import Demo2 from "./Demo2";
interface IState{
    param1:string;
    param2:string;
};
interface IProps{}
class Demo1 extends Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
        this.state = {
            param1 : "Hello_1",
            param2 : "Hello_2"
        }
    };
    fun_one = (arg1:any):any=>{
        this.setState({
            param1 : arg1
        })
    };
    fun_two = (arg1:any):any=>{
        this.setState({
            param2 : arg1
        })
    };

    render(){
        return(
            <React.Fragment>
                <Demo2 key1={this.state.param1}
                       key2={this.state.param2}
                       key3={this.fun_one}
                       key4={this.fun_two}></Demo2>
            </React.Fragment>
        )
    }


};
export default Demo1;