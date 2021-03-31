import React from "react";

//state
//state is the predefined object
//state object, used to define the component data
//we will define state by using interfaces
interface IState{
    strData : string,
    numData : number,
    booleanData : boolean,
    strArray : string[],
    objData : any,
    products : any[]
};

//props
interface IProps{}


//create the class
class App extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
        this.state = {
          strData : "welcome to typescript with reactjs",
          numData : 100,
          booleanData : true,
          strArray : [`Angular11`,`ReactJS`,`VueJS`],
          objData : {"key1":"Hello_1"},
          products : [{"p_id":111,"p_name":"p_one","p_cost":10000},
                      {"p_id":222,"p_name":"p_two","p_cost":20000},
                      {"p_id":333,"p_name":"p_three","p_cost":30000},
                      {"p_id":444,"p_name":"p_four","p_cost":40000},
                      {"p_id":555,"p_name":"p_five","p_cost":50000}]
        }
    };
    render(){
        return(
           <React.Fragment>
                <h1>{ this.state.strData }</h1>
                <h1>{ this.state.numData }</h1> 
                <h1>{ JSON.stringify(this.state.booleanData) }</h1> 
                {this.state.strArray.map((element:string,index:number)=>(
                  <h1 key={index}>{element}</h1>
                ))}
                <h1>{this.state.objData.key1}</h1>        
                <table>
                  <tr>
                    <th>SNO</th>
                    <th>P_ID</th>
                    <th>P_NAME</th>
                    <th>P_COST</th>
                  </tr>
                  {this.state.products.map((element:any,index:number)=>(
                      <tr key={index}>
                         <td>{index+1}</td>
                         <td>{element.p_id}</td>
                         <td>{element.p_name}</td>
                         <td>{element.p_cost}</td>
                      </tr>
                  ))}
                </table>
           </React.Fragment>
        )
    }
};

export default App;
