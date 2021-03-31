//static
//static members, we can access directly by using "class" names
//we can't access static members by using "class" objects
/*
    class class_one{
        static var_one:string;
        constructor(){
            this.var_one = "Hello_1";
        };
    };
    //Note : we can't initilize static members by using constructor
*/
/*
    class class_one{
        static var_one:string = "Hello_1";
    };
    let obj:class_one = new class_one();
    obj.var_one;
    //Property 'var_one' does not exist on type 'class_one'. Did you mean to access the static member 'class_one.var_one' instead?
*/
/*
    static class class_one{
        static constructor(){}
    };

//static keyword won't applicable to classes as well as constructor
*/
/*
    class class_one{
        static var_one:string = "Hello_1";
        static fun_one():string{
            return this.var_one;
        };
    };
    console.log( class_one.var_one, class_one.fun_one() );   //Hello_1 Hello_1
*/
/*
    class class_one{
        static var_one:string = "Hello_1";
        fun_one():string{
            return this.var_one;
        };
    };
    //we can't access static members to "non static area"
*/
var class_one = /** @class */ (function () {
    function class_one() {
    }
    class_one.prototype.fun_one = function () {
        return "Hello_1";
    };
    class_one.fun_two = function () {
        return new class_one();
    };
    ;
    return class_one;
}());
;
console.log(class_one.fun_two().fun_one());
