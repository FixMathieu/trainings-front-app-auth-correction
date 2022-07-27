import { Order } from "./order.model";
import { Training } from "./training.model";

export class Details {
    id : number | undefined;
    quantity : number;
    training : Training | undefined;
    order : Order;
  

    // constructor(id:number,quantity : number, training: Training | undefined, order : Order) {
    //     this.id = id;
    //     this.quantity = quantity;
    //     this.training = training;
    //     this.order = order;
      
    // }

    constructor(quantity : number, training: Training | undefined, order : Order) {
        this.quantity = quantity;
        this.training = training;
        this.order = order;
      
    }
};