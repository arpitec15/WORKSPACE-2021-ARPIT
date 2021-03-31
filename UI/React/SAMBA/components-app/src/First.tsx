//import "React" class
//React is the Predefined "class"
//React class used to create the "Component"
import React from "react";

//props
//props is the predefined "object"
//props used to receive the data from "another" component
//in general, we will define props by using "interfaces"
interface IProps{}


//state
//state is the predefined object 
//state used to represent the component data
//in general, we will represent state by using interfaces
interface IState{}



//create the class
class First extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
    }

    render(){
        return(
            <h1>Welcome to AshokIT for ReactJS !!!</h1>
        )   
    }

};

//export the First component
export default First;