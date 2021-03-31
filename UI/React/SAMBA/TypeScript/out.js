var namespace1;
(function (namespace1) {
    namespace1.sub_one = "ReactJS";
    namespace1.sub_two = "NodeJS";
    namespace1.sub_three = "MongoDB";
    namespace1.obj = {
        key1: "MEAN Stack",
        key2: "MERN Stack",
        key3: "MEVN Stack"
    };
    function fun_one() {
        return namespace1.sub_one;
        ;
    }
    namespace1.fun_one = fun_one;
    ;
    class class_one {
        constructor() {
            this.var_one = namespace1.sub_one;
            this.var_two = namespace1.sub_two;
            this.var_three = namespace1.sub_three;
        }
    }
    namespace1.class_one = class_one;
    ;
    ;
    let namespace2;
    (function (namespace2) {
        ;
    })(namespace2 = namespace1.namespace2 || (namespace1.namespace2 = {}));
    ;
})(namespace1 || (namespace1 = {}));
;
/// <reference path="demo1.ts" />
console.log(namespace1.sub_one, namespace1.sub_two, namespace1.sub_three);
console.log(namespace1.obj.key1, namespace1.obj.key2, namespace1.obj.key3);
console.log(namespace1.fun_one());
let obj = new namespace1.class_one();
console.log(obj.var_one, obj.var_two, obj.var_three);
let json_obj = {
    var_one: "ReactJS With TypeScript",
    fun_one: () => {
        return "ReactJS With JSX";
    }
};
console.log(json_obj.var_one, json_obj.fun_one());
let obj1 = {
    s_one: "VueJS",
    s_two: "NodeJS",
    s_three: "Deno"
};
console.log(obj1.s_one, obj1.s_two, obj1.s_three);
class class_one {
    constructor() {
        this.s_one = "VueJS";
        this.s_two = "NodeJS";
        this.s_three = "MongoDB";
    }
}
;
let my_obj = new class_one();
console.log(my_obj.s_one, my_obj.s_two, my_obj.s_three);
