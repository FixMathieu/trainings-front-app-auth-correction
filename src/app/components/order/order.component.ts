import { Component, DoCheck, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer.model';
import { Details } from 'src/app/model/details.model';
import { Order } from 'src/app/model/order.model';
import { ApiService } from 'src/app/services/api.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit,OnChanges,DoCheck,OnDestroy {
  dateOrder : Date = new Date();
orderNumber : number | undefined;
error = null;

  constructor(public cartService : CartService,public apiService: ApiService, private router : Router) { }

  ngOnChanges(changes: SimpleChanges): void {
      console.log('ngOnChanges' + changes);
  }

  ngOnInit(): void {
      console.log('ngOnInit')
  }

  ngDoCheck(): void {
      console.log('ngDoCheck')
  }

  ngOnDestroy(): void {
      console.log('ngOnDestroy')
  }

  onOrder(){
    // if(confirm("Aujourd'hui c'est gratuit, merci de votre visite :)")){
    //   this.apiService.postCustomer({name:form.value.name,firstName:form.value.firstName,
    //     address:form.value.address,phone:form.value.phone,email:form.value.email}).subscribe({
    //      next : (data) => console.log(data),  
    //      error : (err) => this.error = err.message,
    //      complete : () => this.router.navigateByUrl('order')
    //     });
    //   this.cartService.clear();
    //   this.router.navigateByUrl('');
    // }

    let customer = new Customer("","","","","");
    let order = new Order(customer,0,new Array<Details>());

    //Create detailsList
    let detailsList : Array<Details> = [];

    //console.log(this.cartService.getCartItems());
    for (let i=0 ;  i<this.cartService.getCartItems().size ;i++){
      detailsList[i] = new Details(1,this.cartService.getCartItems().get(i+1),order);
      //console.log(this.cartService.getCartItems().get(i+1));
    }
    



    order = new Order(this.cartService.getCustomer(),this.cartService.getAmount(), detailsList);
    console.log(order);
    
    if(confirm("Merci de votre achat.")){
    this.apiService.postOrder(order).subscribe({
      next : (data)=>{
        this.orderNumber = data.id;
       // this.dateOrder = data.date;
      },
      error : (err) => this.error = err.message,
      complete : () => this.error = null
    })
    this.cartService.clear();
    this.router.navigateByUrl('trainings');
  }
    




    // for (let i=0 ;  i<this.cartService.getCartItems.length ;i++){
    //   this.apiService.postDetails(new Details(0,1,this.cartService.getCartItems().get(i),order));
    // }
  }
}
//0,this.cartService.getCartItems[i].quantity,this.cartService.getCartItems[i].training, this.apiService.get