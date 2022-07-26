import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer.model';
import { CartService } from 'src/app/services/cart.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {  
  myForm : FormGroup;
  customer : Customer;
  error: any;
  // cartService: any;
  // apiService: any;

  constructor(public apiService : ApiService, private router : Router, private formBuilder : FormBuilder) {  
     this.customer = new Customer("","","","","");
   /* this.myForm = new FormGroup({
      name : new FormControl(this.customer.name),
      firstName : new FormControl(this.customer.firstName),
      address : new FormControl(this.customer.address),
      phone : new FormControl(this.customer.phone),
      email : new FormControl(this.customer.email)
    }) */
    this.myForm = this.formBuilder.group({
      name : [this.customer.name, Validators.required],
      firstName : [this.customer.firstName, Validators.required],
      address : [this.customer.address, [Validators.required,Validators.minLength(5)]],
      phone : [this.customer.phone, [Validators.required,Validators.maxLength(10)]],
      email : [this.customer.email, [Validators.required,Validators.pattern('[a-z0-9.@]*')]]
    })
  }

  ngOnInit(): void {  
  }
  onSaveCustomer(form : FormGroup){
    // this.myForm = form;
    console.log("voilà : " + form);
    if(form.valid){
      console.log("dans le if : " + form.value.firstName);
      this.apiService.postCustomer({name:form.value.name,firstName:form.value.firstName,
       address:form.value.address,phone:form.value.phone,email:form.value.email}).subscribe({
        next : (data) => console.log(data),  
        error : (err) => this.error = err.message,
        complete : () => this.router.navigateByUrl('order')
       });
       this.apiService.saveCustomer(new Customer(form.value.name,form.value.firstName,
        form.value.address,form.value.phone,form.value.email));
    }
  }

}
