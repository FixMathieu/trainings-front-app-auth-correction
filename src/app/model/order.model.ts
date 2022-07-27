import { Customer } from "./customer.model";
import { Details } from "./details.model";

export class Order {
    id : number | undefined;
    total : number;
  //  date : Date = new Date();
    customer : Customer;
    details : Array<Details>;
    
  

    constructor(customer : Customer,amount : number,details : Array<Details>){
       // this.date = date;
        this.customer = customer;
        this.total = amount;
        this.details = details;
    }
}