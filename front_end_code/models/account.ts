export interface Account {
  accountId?: number;          // change from id if backend uses this
  customerId?: number|null;
  branchId: number;
  accountNumber?: string;
  accountType: string;
  balance: number;
  dateOpened?: string;
  ifscCode: string;
}
