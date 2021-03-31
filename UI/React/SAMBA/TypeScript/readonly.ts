//readonly
//as a typescript developer, we can only read the content and we can't modify
class class_one{
    readonly var_one:string;
    constructor(){
        this.var_one="Hello_1";
    }
};
let obj:class_one = new class_one();
console.log( obj.var_one );

obj.var_one = "Hello_2";   //Cannot assign to 'var_one' because it is a read-only property.