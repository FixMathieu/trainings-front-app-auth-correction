import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/model/category.model';
import { Training } from 'src/app/model/training.model';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css']
})
export class TrainingComponent implements OnInit {
  myForm : FormGroup;
  training : Training;
  categoryId : number = 0;
  error : string = "";
  status : boolean = false;

  constructor(private formBuilder : FormBuilder, private apiService : ApiService, 
    private router : Router, private route:ActivatedRoute) { 
    let category=new Category(0,"");
    this.training = new Training(0,"","",0,1,category);
    this.myForm = this.formBuilder.group({
        id   : [this.training.id],
        name : [this.training.name, Validators.required],
        description : [this.training.description, Validators.required],
        price : [this.training.price, [Validators.required,Validators.min(50)]], 
        category:[this.training.category.id,[Validators.required]]   
    })
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    if(id > 0) {
      this.status = true;
      this.apiService.getTraining(id).subscribe({
        next : (data) => {
            this.training = data;
            this.myForm.setValue({id : this.training.id , name : this.training.name, description : this.training.description, 
              price : this.training.price,category:this.training.category.id});
        },
        error : (err) => this.error = err
      })
    }
  }

  onAddTraining(form : FormGroup){
    if(form.valid){
      console.log(form.value.category.id)
      let category=new Category(form.value.category,"");
      this.apiService.postTraining({name:form.value.name , description:form.value.description 
          , price:form.value.price , quantity:1 ,category:category}).subscribe({
            next : (data) => console.log(data),  
            error : (err) => this.error = err.message,
            complete : () => this.router.navigateByUrl('trainings')
          })
    }
  }  

  updateTraining(form : FormGroup){
    this.apiService.putTraining({id :form.value.id , name:form.value.name , description:form.value.description 
      , price:form.value.price , quantity:1,category:form.value.category.id}).subscribe({
        next : (data) => console.log(data),  
        error : (err) => this.error = err.message,
        complete : () => this.router.navigateByUrl('trainings')
      })
  }
}
