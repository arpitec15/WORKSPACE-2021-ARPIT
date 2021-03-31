//generics are used to provide the "type safety"
//by using generics we will decide "datatypes" dynamically.
;
var obj1 = {
    arg1: "Hello_1",
    arg2: "Hello_2",
    fun_one: function (arg1, arg2) {
        return arg1 + "   " + arg2;
    }
};
console.log(obj1.arg1, obj1.arg2, obj1.fun_one(obj1.arg1, obj1.arg2));
