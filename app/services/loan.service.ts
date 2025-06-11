import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Loan } from '../models/loan';
import { LoanApplication } from '../models/loan-application';

@Injectable({
  providedIn: 'root',
})
export class LoanService {
  private baseUrl = 'http://localhost:8080/api/v1'; // Your backend base URL

  constructor(private http: HttpClient) {}

  // Get all loans
 getAllLoans(): Observable<Loan[]> {
  return this.http.get<Loan[]>(`${this.baseUrl}/loans/getAllLoans`);
}


  // Apply for a loan
  applyLoan(application: LoanApplication): Observable<any> {
    // Match the backend DTO properties exactly
    const payload = {
      customerId: application.customerId,
      loanId: application.loanId,
      requestedAmount: application.requestedAmount,
      purpose: application.purpose,
   
    };
    return this.http.post(`${this.baseUrl}/loan-applications/createLoanApplication`, payload);
  }

 // Corrected method in loan.service.ts
getLoanApplicationsByCustomerId(customerId: number): Observable<LoanApplication[]> {
  return this.http.get<LoanApplication[]>(`${this.baseUrl}/loan-applications/getLoanApplicationsByCustomerId/${customerId}`);
}

}
