import React from 'react';
import Second from "./Second";

interface IState{
    key1 : string;
    key2 : number;
    key3 : boolean;
    key4 : any;
    key5 : any[];
};

interface IProps{}

class First extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
        this.state = {
          key1 : "Hello_1",
          key2 : 100,
          key3 : true,
          key4 : {"key":"Hello"},
          key5 : [{"e_id":111,"e_name":"e_one","e_sal":10000},
                  {"e_id":222,"e_name":"e_two","e_sal":20000},
                  {"e_id":333,"e_name":"e_three","e_sal":30000},
                  {"e_id":444,"e_name":"e_four","e_sal":40000},
                  {"e_id":555,"e_name":"e_five","e_sal":50000}]  
        }   
    };
    render(){
        return(
            <React.Fragment>
                <Second key1={this.state.key1}
                        key2={this.state.key2}
                        key3={this.state.key3}
                        key4={this.state.key4}
                        key5={this.state.key5}></Second>
            </React.Fragment>
        )
    }
};

export default First;