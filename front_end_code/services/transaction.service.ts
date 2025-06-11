import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from '../models/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl = 'http://localhost:8080/api/v1/accounts';  // Spring Boot backend base URL

  constructor(private http: HttpClient) { }

 getTransactionsByAccountId(accountId: number): Observable<Transaction[]> {
  return this.http.get<Transaction[]>(`${this.baseUrl}/gettransactionsforaccount/${accountId}`);
}


  // Deposit - matches @PostMapping("/deposit/{accountId}?amount=...")
  deposit(accountId: number, amount: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/deposit/${accountId}?amount=${amount}`, {});
  }

  // Withdraw - matches @PostMapping("/withdraw/{accountId}?amount=...")
  withdraw(accountId: number, amount: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/withdraw/${accountId}?amount=${amount}`, {});
  }

  // Transfer - matches @PostMapping("/transfer?fromAccountNumber=...&toAccountNumber=...&amount=...")
  transfer(fromAccountNumber: string, toAccountNumber: string, amount: number): Observable<any> {
    const params = `fromAccountNumber=${fromAccountNumber}&toAccountNumber=${toAccountNumber}&amount=${amount}`;
    return this.http.post(`${this.baseUrl}/transfer?${params}`, {});
  }
}
