import React from 'react';
import Second from './Second';

interface IState {

            key1: string;
            key2: number;
            key3: boolean;
            key4: any;
            key5: any[];
};

interface IProps{};

class First extends React.Component<IProps, IState>{

    constructor(props:IProps){
            super(props);
        this.state = {
            key1: "Hello_1",
            key2: 100,
            key3: false,
            key4: {"key" : "Hello"},
            key5: [{"e_id" : 1001, "e_name":"one", "e_sal" : 10000},
                    {"e_id" : 1002, "e_name":"two", "e_sal" : 10002},
                    {"e_id" : 1003, "e_name":"three", "e_sal" : 10003}]
        }
    };
    render(){

        return(

            <React.Fragment>
                <Second key1= {this.state.key1}
                        key2= {this.state.key2}
                        key3= {this.state.key3}
                        key4= {this.state.key4}
                        key5= {this.state.key5}></Second>
            </React.Fragment>


        )

    }
};

export default First;
