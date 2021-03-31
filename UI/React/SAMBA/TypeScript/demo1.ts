namespace namespace1{
    export let sub_one:string = "ReactJS";
    export let sub_two:string = "NodeJS";
    export let sub_three:string = "MongoDB";

    export let obj:any = {
        key1 : "MEAN Stack",
        key2 : "MERN Stack",
        key3 : "MEVN Stack"
    };

    export function fun_one():string{
        return sub_one;;
    };

    export class class_one{
        var_one:string = sub_one;
        var_two:string = sub_two;
        var_three:string = sub_three;
    };

    export interface interface1{
        var_one:string;
        fun_one():string;
    };

    export namespace namespace2{
        export interface interface2{
            s_one:string;
            s_two:string;
            s_three:string;
        };
    };


};