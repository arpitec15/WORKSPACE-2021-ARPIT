//generics are used to provide the "type safety"
//by using generics we will decide "datatypes" dynamically.

/*
    function fun_one<T>(arg1:T):T{
        return arg1;
    };
    console.log( fun_one<string>("hello") );
    console.log( fun_one<number>(100) );
    console.log( fun_one<boolean>(true) );
    console.log( fun_one<any>({"msg":"welcome to reactjs"}) );
    console.log( fun_one<string[]>(["Angular","ReactJS","VueJS"]) );
*/

/*
    function fun_one<A,B>(arg1:A,arg2:B):void{
        console.log( arg1, arg2 );
    };
    fun_one<string,string>("Hello_1","Hello_2");
    fun_one<number,number>(100,100);
    fun_one<boolean,number>(true,100);
*/


/*
    class class_one<A,B,C>{
        var_one:A;
        var_two:B;
        var_three:C;
        constructor(arg1:A,arg2:B,arg3:C){
            this.var_one=arg1;
            this.var_two=arg2;
            this.var_three=arg3;
        }
        fun_one<A>():any{
            return this.var_one;
        };
        fun_two<B>():any{
            return this.var_two;
        };
        fun_three<C>():any{
            return this.var_three;
        };
    };
    let obj1:class_one<string,string,string> = new class_one("Hello_1","Hello_2","Hello_3");
    console.log( obj1.fun_one(), obj1.fun_two(), obj1.fun_three() );

    let obj2:class_one<number,number,number> = new class_one(100,200,300);
    console.log( obj2.fun_one(), obj2.fun_two(), obj2.fun_three() );

    let obj3:class_one<any,any,any> = new class_one({"key1":"ReactJS"},{"key1":"React Native"},{"key1":"NodeJS"});
    console.log( obj3.fun_one(), obj3.fun_two(), obj3.fun_three() );
*/


/*
    interface interface1<A,B>{
        arg1:A;
        arg2:B;
        fun_one(arg1:A,arg2:B):any;
    };
    let obj1:interface1<string,string> = {
        arg1 : "Hello_1",
        arg2 : "Hello_2",
        fun_one : (arg1:string,arg2:string):any=>{
            return arg1+"   "+arg2;
        }
    };
    console.log( obj1.arg1, obj1.arg2 , obj1.fun_one(obj1.arg1,obj1.arg2) );
*/




































































