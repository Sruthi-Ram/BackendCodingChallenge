import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from '../../services/customer.service';
import { NgForm } from '@angular/forms';
import { Customer } from '../../models/customer';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {
  customer: Customer = {
    userId:0,
    name: '',
    gender: '',
    contactNumber: '',
    address: '',
    dateOfBirth: '',
    aadharNumber: '',
    panNumber: ''
  };

  
  constructor(private route: ActivatedRoute, private customerService: CustomerService) {}

  ngOnInit(): void {
   const id: string | null = this.route.snapshot.paramMap.get('userId');
if (id) {
  this.customer.userId = +id;
}

  }

onSubmit(form: NgForm) {
  if (form.valid) {
    this.customerService.registerCustomer(this.customer).subscribe({
      next: (res) => {
        alert('Registration successful!');
        form.resetForm();
      },
      error: (err) => {
        alert('Registration failed. Try again.');
        console.error(err);
      }
    });
  }
}

}
