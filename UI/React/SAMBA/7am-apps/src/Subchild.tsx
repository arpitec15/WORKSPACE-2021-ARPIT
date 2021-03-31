import React from "react";
interface IProps{
    key1:string;
    key2:string;
    key3:number;
    key4:number;
    key5:number;
    key6:string;
    key7:string;
};
interface IState{}
class Subchild extends React.Component<IProps,IState>{
    constructor(props:IProps){
        super(props);
    };
    render(){
        return(
            <React.Fragment>
                {this.props.key7}
                <table style={{border:'1px solid red'}}>
                    <tr>
                        <th style={{border:'1px solid red'}}>Name</th>
                        <th style={{border:'1px solid red'}}>Brand</th>
                        <th style={{border:'1px solid red'}}>Price ($)</th>
                        <th style={{border:'1px solid red'}}>Qty</th>
                        <th style={{border:'1px solid red'}}>CountInStock</th>
                        <th style={{border:'1px solid red'}}>Image</th>
                    </tr>
                    <tr>
                        <td style={{border:'1px solid red'}}>{this.props.key1}</td>
                        <td style={{border:'1px solid red'}}>{this.props.key2}</td>
                        <td style={{border:'1px solid red'}}>{this.props.key3}</td>
                        <td style={{border:'1px solid red'}}>{this.props.key4}</td>
                        <td style={{border:'1px solid red'}}>{this.props.key5}</td>
                        <td ><img width="100" style={{border:'1px solid red'}} src={this.props.key6}></img></td>
                    </tr>    
                </table>     
            </React.Fragment>
        )
    };
};
export default Subchild;