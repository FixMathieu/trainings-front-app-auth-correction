import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Category } from '../model/category.model';
import { Customer } from '../model/customer.model';
import { Training } from '../model/training.model';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  getTrainingsByCategory(categoryId: number) {
    return this.http.get<Training[]>(environment.host+"/trainings/category/"+categoryId);
  }

 

  constructor(private http:HttpClient) { }

  public getCategory() {
    return this.http.get<Category[]>(environment.host+"/category");
  }

  public getTrainings() {
    return this.http.get<Training[]>(environment.host+"/trainings");
  }

  public getTraining(id : number) {
    return this.http.get<Training>(environment.host+"/trainings/"+id);
  }

  public getUsers() {
    return this.http.get<User[]>(environment.host + "/users");
  }

  public postTraining(training : any){
    console.log(training);
    return this.http.post<Training>(environment.host+"/trainings" , training);
  }

  public delTraining(training: Training) {
    return this.http.delete(environment.host+"/trainings/" + training.id);
  }

  public putTraining(training: any) {
    return this.http.put<Training>(environment.host+"/trainings/"+training.id, training);
  }
  saveCustomer(customer : any) {
    localStorage.setItem('customer',JSON.stringify(customer));
    
  }
 public getCustomer() {
     let customer =this.http.get<Customer>(environment.host+"/customer/"+localStorage.getItem('customer'));
    if(customer)  return  customer;
    // return new Customer("unknown","","","","");
    return this.http.post<Customer>(environment.host+"/customer",customer);
  }
  public postCustomer(customer : any){
   

    return this.http.post<Customer>(environment.host+"/customer",customer);
  }

}
