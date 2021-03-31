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
var class_one = /** @class */ (function () {
    function class_one() {
    }
    class_one.prototype.display = function (arg1, arg2) {
        return arg1 + "    " + arg2;
    };
    ;
    return class_one;
}());
;
var obj1 = new class_one();
console.log(obj1.display("Hello_1", "Hello_2"));
console.log(obj1.display(true, false));
console.log(obj1.display(100, 200));
//console.log( obj1.display(100,"Hello") );
