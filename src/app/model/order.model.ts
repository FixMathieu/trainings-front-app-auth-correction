import { Customer } from "./customer.model";
import { Training } from "./training.model";

export class Order {
    id : number | undefined;
    date : Date = new Date();
    items : Map<number,Training>;
    customer : Customer;
    amount : number | undefined;
  

    constructor(id : number,date : Date,items :Map<number,Training>,customer : Customer,amount : number){
        this.id = id;
        this.date = date;
        this.items = items;
        this.customer = customer;
        this.amount = amount;
    }
}