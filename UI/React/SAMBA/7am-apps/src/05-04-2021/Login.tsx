import React, { createRef } from "react";

interface IState{
    login_status:string;
}

interface IProps{}

class Login extends React.Component<IProps,IState>{

    u_name = createRef<HTMLInputElement>();
    u_pwd = createRef<HTMLInputElement>();
    // u_email = React.createRef();
    private u_email: React.RefObject<HTMLInputElement>;

    constructor(props:IProps){
        super(props);
        this.state = {
            login_status : ""
        }
        this.u_email = React.createRef();
    };

    login = ()=>{
        if(this.u_name.current?.value === "admin" &&
            this.u_pwd.current?.value === "admin"){
                this.setState({
                    login_status : "success"
                })
        }else{
            this.setState({
                login_status:"fail"
            })
        }
    };

    

    render(){
        console.log(this.u_name.current?.value + " " + this.u_pwd.current?.value +" "+ this.u_email.current?.value);
        return(
            <React.Fragment>
                <input  type="text" name = "name" ref={this.u_name} ></input>
                <br></br><br></br>
                <input type="password" ref={this.u_pwd}></input>
                <br></br><br></br>
                <input type="text" placeholder="Enter Username" name="uname" required></input>
                <br></br><br></br>
                <input type="text" ref={this.u_email}></input>
                <br></br><br></br>
                <button onClick={this.login}>Login</button>
                <br></br><br></br>
                <h1>{this.state.login_status}</h1>
                
            </React.Fragment>
           
        )
    };

};

export default Login;