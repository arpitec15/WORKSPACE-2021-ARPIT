//behaves like many   (polymorphism)
//1) function overriding   (dynamic polymorphism)
//2) function overloading  (static polymorphism)

//function overriding
//overriding the parent class functionality with child class functionality called as function overrriding

/*
    class Parent{
        dbFun():any{
            return "MySQL Data Soon...!";
        };
    };
    class Child extends Parent{
        dbFun():any{
            return "MongoDB Data Soon...!";
        };
    };

    let obj:Child = new Child();
    console.log( obj.dbFun() );    //MongoDB Data Soon...!

    //parent class and child class should contain same function.
    //in above example parent class functionality overriding by child class functionality
    //in parent class we have "MySQL Data Soon...." overriding by "MongoDB Data Soon...!"
    //we need inheritance to see the function overriding
*/


//function overloading
//same function with different "arguments" called as function "overloading"
//we can implement function overloading with single class, no need to choose "inheritance"
class class_one{
    display(arg1:string,arg2:string):any;

    display(arg1:number,arg2:number):any;

    display(arg1:boolean,arg2:boolean):any;

    display(arg1:any,arg2:any):any{
        return arg1+"    "+arg2;
    };
};

let obj1:class_one = new class_one();
//console.log( obj1.display("Hello_1","Hello_2") );
//console.log( obj1.display(true,false) );
//console.log( obj1.display(100,200) );
//console.log( obj1.display(100,"Hello") );
//same function with same number of arguments but datatype is different called as function overloading















