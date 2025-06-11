export interface LoanApplication {
  applicationId?: string; // use `number` if your json-server returns number IDs
  customerId?: number;
  loanId: number;
  requestedAmount: number;
  purpose: string;
  applicationDate?: string;
  status?: string;
}
