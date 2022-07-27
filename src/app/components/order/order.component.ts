import { Component, DoCheck, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
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
    let order = new Order(0,this.dateOrder,this.cartService.getCartItems(),this.cartService.getCustomer(),this.cartService.getAmount());
    this.apiService.postOrder(order).subscribe({
      next : (data)=>{
        this.orderNumber = data.id;
        this.dateOrder = data.date;
        this.cartService.clear();
      },
      error : (err) => this.error = err.message,
      complete : () => this.error = null
    })
  }
}
