/// <reference path="demo1.ts" />
console.log( namespace1.sub_one, namespace1.sub_two, namespace1.sub_three );
console.log( namespace1.obj.key1, namespace1.obj.key2, namespace1.obj.key3 );
console.log( namespace1.fun_one() );

let obj:namespace1.class_one = new namespace1.class_one();
console.log( obj.var_one, obj.var_two, obj.var_three );

let json_obj:namespace1.interface1 = {
    var_one : "ReactJS With TypeScript",
    fun_one : ():string=>{
        return "ReactJS With JSX"
    }
};  
console.log( json_obj.var_one, json_obj.fun_one() );

let obj1:namespace1.namespace2.interface2 = {
    s_one : "VueJS",
    s_two : "NodeJS",
    s_three : "Deno"
};
console.log( obj1.s_one, obj1.s_two, obj1.s_three );

class class_one implements namespace1.namespace2.interface2{
    s_one = "VueJS";
    s_two = "NodeJS";
    s_three = "MongoDB"
};
let my_obj:class_one = new class_one();
console.log( my_obj.s_one, my_obj.s_two, my_obj.s_three );



